package com.simplification.decorator1;

public class HashServiceRequestDecorator extends ServiceRequestDecorator {

    private final ServiceRequest serviceRequest;

    public HashServiceRequestDecorator(ServiceRequest serviceRequest) {
        super(serviceRequest);
        this.serviceRequest = serviceRequest;
    }

    @Override
    Request prepareRequest() {
        Request request = serviceRequest.prepareRequest();
        System.out.println("Hashed service request");
        return request;
    }
}
