package com.simplification.decorator1;

public class HexServiceRequestDecorator extends ServiceRequestDecorator {

    private final ServiceRequest serviceRequest;

    public HexServiceRequestDecorator(ServiceRequest serviceRequest) {
        super(serviceRequest);
        this.serviceRequest = serviceRequest;
    }

    @Override
    Request prepareRequest() {
        Request request = serviceRequest.prepareRequest();
        System.out.println("Hex encoded request");
        return request;
    }
}
