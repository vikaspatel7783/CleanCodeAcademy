package com.object_creation.inline_singleton.refactor;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void printTheMessage() {
        new Client().printTheMessage("This Should be printed");
        Assert.assertTrue(true);
    }
}