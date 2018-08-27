package com.object_creation.creation_to_simple_factory;

public class PizzaFactory {

    public static Pizza createMargheritaWithSingleCheesePizza() {
        return new Pizza();
    }

    public static Pizza createMargheritaWithDoubleCheesePizza() {
        return new Pizza("DoubleCheese");
    }

    public static Pizza createFarmHousePizza() {
        return new Pizza("veggies", "capsicum", "mushroom", "tomatoes");
    }

    public static Pizza createMaxicanGreenPizza() {
        return new Pizza("onion", "capsicum", "tomatoes", "jalapenos", "herbs");
    }

    public static Pizza createExtraVagenzaPizza() {
        return new Pizza("corn", "blackOlives", "onion", "capsicum", "mushrooms", "tomatoes", "jalapenos");
    }

}
