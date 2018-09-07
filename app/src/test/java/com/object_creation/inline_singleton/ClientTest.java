package com.object_creation.inline_singleton;

import junit.framework.Assert;

import org.junit.Test;

public class ClientTest {

    @Test
    public void printTheMessage() {
        new Client().printTheMessage("This should be printed");
        Assert.assertTrue(true);
    }
}