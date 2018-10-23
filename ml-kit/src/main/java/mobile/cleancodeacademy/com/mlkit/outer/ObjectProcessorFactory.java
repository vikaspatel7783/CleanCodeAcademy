package mobile.cleancodeacademy.com.mlkit.outer;

import com.google.firebase.ml.vision.cloud.FirebaseVisionCloudDetectorOptions;
import com.google.firebase.ml.vision.label.FirebaseVisionLabelDetectorOptions;

import mobile.cleancodeacademy.com.mlkit.core.barcodescanning.BarcodeScanningProcessor;
import mobile.cleancodeacademy.com.mlkit.core.cloudimagelabeling.CloudImageLabelingProcessor;
import mobile.cleancodeacademy.com.mlkit.core.imagelabeling.ImageLabelingProcessor;

public class ObjectProcessorFactory {

    public static ImageLabelingProcessor getImageLabelDeviceProcessor(float confidence) {
        FirebaseVisionLabelDetectorOptions options =
                new FirebaseVisionLabelDetectorOptions.Builder()
                        .setConfidenceThreshold(confidence)
                        .build();
        ImageLabelingProcessor imageLabelingProcessor = new ImageLabelingProcessor(options);
        return imageLabelingProcessor;
    }

    public static CloudImageLabelingProcessor getImageLabelCloudProcessor(ObjectResultCallback objectResultCallback, int maxResults) {
        FirebaseVisionCloudDetectorOptions options =
                new FirebaseVisionCloudDetectorOptions.Builder()
                        .setMaxResults(maxResults)
                        .setModelType(FirebaseVisionCloudDetectorOptions.STABLE_MODEL)
                        .build();
        CloudImageLabelingProcessor cloudImageLabelingProcessor = new CloudImageLabelingProcessor(options, objectResultCallback);
        return cloudImageLabelingProcessor;
    }

    public static BarcodeScanningProcessor getBarcodeDeviceProcessor(ObjectResultCallback objectResultCallback) {
        BarcodeScanningProcessor barcodeScanningProcessor = new BarcodeScanningProcessor(objectResultCallback);
        return barcodeScanningProcessor;
    }

}
