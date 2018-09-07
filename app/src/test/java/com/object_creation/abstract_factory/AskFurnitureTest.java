package com.object_creation.abstract_factory;

import junit.framework.Assert;

import org.junit.Test;

public class AskFurnitureTest {

    @Test
    public void askForFurniture() {

        FurnitureClient.Furniture indianFurniture = new AskFurniture().askForFurniture("Arabian");

        Assert.assertTrue(indianFurniture != null);
    }
}