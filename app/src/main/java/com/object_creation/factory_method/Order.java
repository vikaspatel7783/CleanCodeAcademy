package com.object_creation.factory_method;

public class Order {

    public Pizza orderPizza(String... ingredients) {

        if (ingredients.length == 1 && ingredients[0].equals("DoubleCheese")) {
            return new MargeritaPizza().createPizza(ingredients[0]);

        } else if (ingredients[0].equals("veggies") && ingredients[1].equals("capsicum")) {
            return new FarmHousePizza().createPizza(ingredients);
        }

        return null;
    }

}
