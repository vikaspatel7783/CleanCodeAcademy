package mobile.cleancodeacademy.com.mlkit.outer;

import android.graphics.Bitmap;

import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode;
import com.google.firebase.ml.vision.cloud.label.FirebaseVisionCloudLabel;

import java.util.List;

import mobile.cleancodeacademy.com.mlkit.core.VisionProcessorBase;

public class Controller {

    private ObjectProcessor mObjectProcessor;
    private Bitmap mCapturedImage;
    private ObjectResultCallback mObjectResultCallback;

    private void setObjectProcessor(ObjectProcessor mlProcessor) {
        mObjectProcessor = mlProcessor;
    }

    private void setInputImage(Bitmap capturedImage) {
        mCapturedImage = capturedImage;
    }

    private void setDetectionResultCallback(ObjectResultCallback objectResultCallback) {
        mObjectResultCallback = objectResultCallback;
    }

    private void startDetection() {
        VisionProcessorBase[] processors = mObjectProcessor.getObjectProcessors();

        /*for (VisionProcessorBase processor: processors) {
            processor.process(mCapturedImage);
        }*/
        processors[0].process(mCapturedImage);
    }

    public void detectImage(Bitmap capturedImage, ObjectResultCallback objectResultCallback) {

        Controller controller = new Controller();

        ObjectProcessor objectProcessors = new ObjectProcessor(
                ObjectProcessorFactory.getBarcodeDeviceProcessor(objectResultCallback),
                ObjectProcessorFactory.getImageLabelCloudProcessor(objectResultCallback, 10)
        );

        controller.setObjectProcessor(objectProcessors);
        controller.setInputImage(capturedImage);
        //controller.setDetectionResultCallback(objectResultCallback);

        controller.startDetection();

    }


}
