package com.object_creation.abstract_factory;

import com.object_creation.abstract_factory.products.concret_products.IndianChair;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.*;

public class AskFurnitureTest {

    @Test
    public void askForFurniture() {

        FurnitureClient.Furniture indianFurniture = new AskFurniture().askForFurniture("Indian");

        Assert.assertTrue(indianFurniture != null && indianFurniture.chair instanceof IndianChair);
    }
}