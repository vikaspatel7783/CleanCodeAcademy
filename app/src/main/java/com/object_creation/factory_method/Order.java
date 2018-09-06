package com.object_creation.factory_method;

public class Order {

    public Pizza orderPizza(String pizzaType) {

        switch (pizzaType) {
            case "Margerita":
                return new MargeritaPizza();

            case "FarmHouse":
                return new FarmHousePizza();

            default:
                throw new IllegalArgumentException("Invalid pizza type provided= " + pizzaType);
        }
    }

}
