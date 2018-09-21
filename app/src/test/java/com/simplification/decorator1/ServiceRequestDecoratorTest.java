package com.simplification.decorator1;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceRequestDecoratorTest {

    @Test
    public void testHexEncodedEligibilityRequest() {
        HexServiceRequestDecorator hexServiceRequestDecorator = new HexServiceRequestDecorator(new EligibilityRequest());
        hexServiceRequestDecorator.prepareRequest();
        Assert.assertTrue(true);
    }

    @Test
    public void testHexEncodedAndHashedEligibilityRequest() {
        ServiceRequest eligibilityRequest = new EligibilityRequest();

        eligibilityRequest = new HexServiceRequestDecorator(eligibilityRequest);

        eligibilityRequest = new HashServiceRequestDecorator(eligibilityRequest);

        eligibilityRequest.prepareRequest();

        Assert.assertTrue(true);
    }

}