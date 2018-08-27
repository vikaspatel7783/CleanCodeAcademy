package com.object_creation.method_creation.refactor;

public class Order {

    public void orderPizza() {

        Pizza margheritaWithSingleCheesePizza = Pizza.createMargheritaWithSingleCheesePizza();

        Pizza margheritaWithDoubleCheesePizza = Pizza.createMargheritaWithDoubleCheesePizza("DobleCheese");

        Pizza farmHousePizza = Pizza.createFarmHousePizza("veggies", "capsicum", "mushroom", "tomatoes");

        Pizza maxicanGreenPizza = Pizza.createMaxicanGreenPizza("onion", "capsicum", "tomatoes", "jalapenos", "herbs");

        Pizza extraVagenzaPizza = Pizza.createExtraVagenzaPizza("corn", "blackOlives", "onion", "capsicum", "mushrooms", "tomatoes", "jalapenos");
    }

}
