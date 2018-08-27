package com.object_creation.encapsulate_to_factory;

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

    public static Pizza createPizza(String doubleCheese) {
        return new Pizza(doubleCheese);
    }

    public static Pizza createPizza(String corn, String blackOlives, String onion, String capsicum, String mushrooms, String tomatoes, String jalapenos) {
        return new Pizza(corn, blackOlives, onion, capsicum, mushrooms, tomatoes, jalapenos);
    }

    public static Pizza createPizza(String onion, String capsicum, String tomatoes, String jalapeino, String herbs) {
        return new Pizza(onion, capsicum, tomatoes, jalapeino, herbs);
    }

    public static Pizza createPizza(String veggies, String capsicum, String mushroom, String tomatoes) {
        return new Pizza(veggies, capsicum, mushroom, tomatoes);
    }

    public static Pizza createPizza() {
        return new Pizza();
    }
}
