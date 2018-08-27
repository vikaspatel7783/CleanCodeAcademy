package com.object_creation.method_creation;

public class Order {

    public void orderPizza() {

        Pizza pizza1 = new Pizza();

        Pizza pizza2 = new Pizza("DoubleCheese");

        Pizza pizza3 = new Pizza("veggies", "capsicum", "mushroom", "tomatoes");

        Pizza pizza4 = new Pizza("onion", "capsicum", "tomatoes", "jalapenos", "herbs");

        Pizza pizza5 = new Pizza("corn", "blackOlives", "onion", "capsicum", "mushrooms", "tomatoes", "jalapenos");
    }

}
