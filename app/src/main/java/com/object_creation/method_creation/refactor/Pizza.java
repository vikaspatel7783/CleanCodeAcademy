package com.object_creation.method_creation.refactor;

public class Pizza {

    private Pizza() {}

    private Pizza(String doubleCheese) {}

    private Pizza(String veggies, String capsicum, String mushroom, String tomatoes) {}

    private Pizza(String onion, String capsicum, String tomatoes, String jalapenos, String herbs) {}

    private Pizza(String corn, String blackOlives, String onion, String capsicum, String mushrooms, String tomatoes, String jalapenos) {}

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
