package com.simplification.decorator1;

public class EligibilityRequest extends ServiceRequest {

    @Override
    protected Request prepareRequest() {
        Request request = new Request();
        request.setRequestId("1");
        request.setRequestPayload("This is Eligibility request payload");
        System.out.println("Eligibility core request");
        return request;
    }
}
