package mobile.cleancodeacademy.com.mlkit.outer;

import android.support.annotation.NonNull;

import mobile.cleancodeacademy.com.mlkit.core.VisionProcessorBase;

public class ObjectProcessor {

    private VisionProcessorBase[] mDetectorClasses = new VisionProcessorBase[0];

    private ObjectProcessor() { }

    public VisionProcessorBase[] getObjectProcessors() {
        return mDetectorClasses;
    }

    public ObjectProcessor(@NonNull VisionProcessorBase... detectorClasses) {
        mDetectorClasses = detectorClasses;
    }

}
