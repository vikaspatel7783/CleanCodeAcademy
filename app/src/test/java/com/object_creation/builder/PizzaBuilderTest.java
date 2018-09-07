package com.object_creation.builder;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.*;

public class PizzaBuilderTest {

    @Test
    public void createFarmHousePizza() {

        PizzaBuilder pizzaBuilder = new PizzaBuilder();

        pizzaBuilder.addBlackOlives();
        pizzaBuilder.addCapsicum();
        pizzaBuilder.addCorn();
        pizzaBuilder.addHerbs();
        pizzaBuilder.addOnion();

        Pizza pizza = pizzaBuilder.build();

        Assert.assertTrue(pizza != null);

    }
}