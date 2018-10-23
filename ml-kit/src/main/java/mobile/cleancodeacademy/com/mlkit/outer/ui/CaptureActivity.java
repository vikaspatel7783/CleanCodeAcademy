package mobile.cleancodeacademy.com.mlkit.outer.ui;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode;
import com.google.firebase.ml.vision.cloud.label.FirebaseVisionCloudLabel;

import java.io.IOException;
import java.util.List;

import mobile.cleancodeacademy.com.mlkit.R;
import mobile.cleancodeacademy.com.mlkit.outer.Controller;
import mobile.cleancodeacademy.com.mlkit.outer.ObjectResultCallback;

public class CaptureActivity extends AppCompatActivity {

    private static final String TAG = CaptureActivity.class.getSimpleName();

    private static final String SIZE_PREVIEW = "w:max"; // Available on-screen width.
    private static final String SIZE_1024_768 = "w:1024"; // ~1024*768 in a normal ratio
    private static final String SIZE_640_480 = "w:640"; // ~640*480 in a normal ratio

    private static final String KEY_IMAGE_URI = "com.googletest.firebase.ml.demo.KEY_IMAGE_URI";
    private static final String KEY_IMAGE_MAX_WIDTH =
            "com.googletest.firebase.ml.demo.KEY_IMAGE_MAX_WIDTH";
    private static final String KEY_IMAGE_MAX_HEIGHT =
            "com.googletest.firebase.ml.demo.KEY_IMAGE_MAX_HEIGHT";
    private static final String KEY_SELECTED_SIZE =
            "com.googletest.firebase.ml.demo.KEY_SELECTED_SIZE";

    private static final int REQUEST_IMAGE_CAPTURE = 10;
    private static final int PERMISSION_CAMERA = 51;
    boolean isLandScape;
    private Button getImageButton;
    private ImageView preview;
    private String selectedSize = SIZE_PREVIEW;
    private Uri imageUri;
    // Max width (portrait mode)
    private Integer imageMaxWidth;
    // Max height (portrait mode)
    private Integer imageMaxHeight;
    private Bitmap bitmapForDetection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanbuy_still_image);

        getImageButton = (Button) findViewById(R.id.getImageButton);
        getImageButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startCameraIntentForResult();
                    }
                });

        preview = (ImageView) findViewById(R.id.previewPane);

        isLandScape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        if (savedInstanceState != null) {
            imageUri = savedInstanceState.getParcelable(KEY_IMAGE_URI);
            imageMaxWidth = savedInstanceState.getInt(KEY_IMAGE_MAX_WIDTH);
            imageMaxHeight = savedInstanceState.getInt(KEY_IMAGE_MAX_HEIGHT);
            selectedSize = savedInstanceState.getString(KEY_SELECTED_SIZE);

            if (imageUri != null) {
                tryReloadAndDetectInImage();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkForCameraPermission();
    }

    private void checkForCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_CAMERA);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable(KEY_IMAGE_URI, imageUri);
        if (imageMaxWidth != null) {
            outState.putInt(KEY_IMAGE_MAX_WIDTH, imageMaxWidth);
        }
        if (imageMaxHeight != null) {
            outState.putInt(KEY_IMAGE_MAX_HEIGHT, imageMaxHeight);
        }
        outState.putString(KEY_SELECTED_SIZE, selectedSize);
    }

    private void startCameraIntentForResult() {
        // Clean up last time's image
        imageUri = null;
        preview.setImageBitmap(null);

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.TITLE, "New Picture");
            values.put(MediaStore.Images.Media.DESCRIPTION, "From Camera");
            imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case PERMISSION_CAMERA:
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {

                    boolean hasUserDeniedWithNeverAskAgain = ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0]);
                    if (!hasUserDeniedWithNeverAskAgain) {
                        // show permission settings screen
                        takeToAppSettings();
                    }

                    Toast.makeText(this, "Camera permission must be granted", Toast.LENGTH_LONG).show();
                    finish();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            switch (resultCode) {
                case RESULT_OK:
                    tryReloadAndDetectInImage();
                    break;

                default:
                    finish();
                    break;
            }
        }
    }

    private void takeToAppSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivity(intent);
    }

    private void tryReloadAndDetectInImage() {
        try {
            if (imageUri == null) {
                return;
            }

            Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);

            // Get the dimensions of the View
            Pair<Integer, Integer> targetedSize = getTargetedWidthHeight();

            int targetWidth = targetedSize.first;
            int maxHeight = targetedSize.second;

            // Determine how much to scale down the image
            float scaleFactor =
                    Math.max(
                            (float) imageBitmap.getWidth() / (float) targetWidth,
                            (float) imageBitmap.getHeight() / (float) maxHeight);

            Bitmap resizedBitmap =
                    Bitmap.createScaledBitmap(
                            imageBitmap,
                            (int) (imageBitmap.getWidth() / scaleFactor),
                            (int) (imageBitmap.getHeight() / scaleFactor),
                            true);

            preview.setImageBitmap(resizedBitmap);
            bitmapForDetection = resizedBitmap;

            handleReSizedBitmap(bitmapForDetection);

        } catch (IOException e) {
            Log.e(TAG, "Error retrieving saved image");
        }
    }

    // Returns max image width, always for portrait mode. Caller needs to swap width / height for
    // landscape mode.
    private Integer getImageMaxWidth() {
        if (imageMaxWidth == null) {
            // Calculate the max width in portrait mode. This is done lazily since we need to wait for
            // a UI layout pass to get the right values. So delay it to first time image rendering time.
            if (isLandScape) {
                imageMaxWidth =
                        ((View) preview.getParent()).getHeight() - findViewById(R.id.controlPanel).getHeight();
            } else {
                imageMaxWidth = ((View) preview.getParent()).getWidth();
            }
        }

        return imageMaxWidth;
    }

    // Returns max image height, always for portrait mode. Caller needs to swap width / height for
    // landscape mode.
    private Integer getImageMaxHeight() {
        if (imageMaxHeight == null) {
            // Calculate the max width in portrait mode. This is done lazily since we need to wait for
            // a UI layout pass to get the right values. So delay it to first time image rendering time.
            if (isLandScape) {
                imageMaxHeight = ((View) preview.getParent()).getWidth();
            } else {
                imageMaxHeight =
                        ((View) preview.getParent()).getHeight() - findViewById(R.id.controlPanel).getHeight();
            }
        }

        return imageMaxHeight;
    }

    // Gets the targeted width / height.
    private Pair<Integer, Integer> getTargetedWidthHeight() {
        int targetWidth;
        int targetHeight;

        switch (selectedSize) {
            case SIZE_PREVIEW:
                int maxWidthForPortraitMode = getImageMaxWidth();
                int maxHeightForPortraitMode = getImageMaxHeight();
                targetWidth = isLandScape ? maxHeightForPortraitMode : maxWidthForPortraitMode;
                targetHeight = isLandScape ? maxWidthForPortraitMode : maxHeightForPortraitMode;
                break;
            case SIZE_640_480:
                targetWidth = isLandScape ? 640 : 480;
                targetHeight = isLandScape ? 480 : 640;
                break;
            case SIZE_1024_768:
                targetWidth = isLandScape ? 1024 : 768;
                targetHeight = isLandScape ? 768 : 1024;
                break;
            default:
                throw new IllegalStateException("Unknown size");
        }

        return new Pair<>(targetWidth, targetHeight);
    }


    private void handleReSizedBitmap(Bitmap sizedBitmap) {
        Controller controller = new Controller();
        controller.detectImage(sizedBitmap, new DetectionResultsCallback());
    }

    public static class DetectionResultsCallback implements ObjectResultCallback {

        @Override
        public void barcodeDetectionResult(List<FirebaseVisionBarcode> results) {

            for (FirebaseVisionBarcode result : results) {
                String scannedBarcodeResult = result.getRawValue();
                Log.i("Scanned Result", scannedBarcodeResult);
            }
        }

        @Override
        public void labelCloudDetectionResult(List<FirebaseVisionCloudLabel> result) {

        }

        @Override
        public void onFailure(Exception e) {
            e.printStackTrace();
            Log.e("ERROR", e.getMessage());
        }
    }

}
