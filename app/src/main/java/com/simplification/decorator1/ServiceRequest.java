package com.simplification.decorator1;

public abstract class ServiceRequest {

    abstract Request prepareRequest();

    class Request {

        String requestId;
        String requestPayload;

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public String getRequestPayload() {
            return requestPayload;
        }

        public void setRequestPayload(String requestPayload) {
            this.requestPayload = requestPayload;
        }

    }

}
