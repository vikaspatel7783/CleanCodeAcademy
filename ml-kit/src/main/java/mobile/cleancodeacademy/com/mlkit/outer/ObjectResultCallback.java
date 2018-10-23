package mobile.cleancodeacademy.com.mlkit.outer;

import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode;
import com.google.firebase.ml.vision.cloud.label.FirebaseVisionCloudLabel;

import java.util.List;

public interface ObjectResultCallback {

    void barcodeDetectionResult(List<FirebaseVisionBarcode> result);

    void labelCloudDetectionResult(List<FirebaseVisionCloudLabel> result);

    void onFailure(Exception e);

}
