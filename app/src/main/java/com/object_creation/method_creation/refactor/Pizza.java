package com.object_creation.method_creation.refactor;

public class Pizza {

    private Pizza() { // default (Margherita with single cheese layer)
    }

    private Pizza(String doubleCheese) { //Double cheese Margherita
    }

    private Pizza(String veggies, String capsicum, String mushroom, String tomatoes) { // Farm house
    }

    private Pizza(String onion, String capsicum, String tomatoes, String jalapeino, String herbs) { // Maxican green wave
    }

    private Pizza(String corn, String blackOlives, String onion, String capsicum, String mushrooms, String tomatoes, String jalapenos) { // Extravaganza
    }

    public static Pizza createMargheritaWithDoubleCheesePizza(String doubleCheese) {
        return new Pizza(doubleCheese);
    }

    public static Pizza createExtraVagenzaPizza(String corn, String blackOlives, String onion, String capsicum, String mushrooms, String tomatoes, String jalapenos) {
        return new Pizza(corn, blackOlives, onion, capsicum, mushrooms, tomatoes, jalapenos);
    }

    public static Pizza createMaxicanGreenPizza(String onion, String capsicum, String tomatoes, String jalapeino, String herbs) {
        return new Pizza(onion, capsicum, tomatoes, jalapeino, herbs);
    }

    public static Pizza createFarmHousePizza(String veggies, String capsicum, String mushroom, String tomatoes) {
        return new Pizza(veggies, capsicum, mushroom, tomatoes);
    }

    public static Pizza createMargheritaWithSingleCheesePizza() {
        return new Pizza();
    }
}
