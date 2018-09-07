package com.object_creation.factory_method;

import junit.framework.Assert;

import org.junit.Test;

public class OrderTest {

    @Test
    public void orderFarmHousePizza() {

        Pizza farmHouse = new Order().orderPizza("veggies", "capsicum");

        Assert.assertTrue(farmHouse instanceof FarmHousePizza);
    }

    @Test
    public void orderMargeritaPizza() {

        Pizza margerita = new Order().orderPizza("DoubleCheese");

        Assert.assertTrue(margerita instanceof MargeritaPizza);
    }
}