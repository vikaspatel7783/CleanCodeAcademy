package mobile.cleancodeacademy.com.mlkit.outer;

import android.content.Context;
import android.content.Intent;

import mobile.cleancodeacademy.com.mlkit.outer.ui.CaptureActivity;

public class Interactor {

    public void openCameraAndCaptureImage(Context context) {
        Intent intentOpenCameraActivity = new Intent(context, CaptureActivity.class);
        context.startActivity(intentOpenCameraActivity);
    }

}
