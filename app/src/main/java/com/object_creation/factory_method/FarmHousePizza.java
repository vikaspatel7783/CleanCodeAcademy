package com.object_creation.factory_method;

public class FarmHousePizza extends Pizza {

    @Override
    Pizza createPizza(String... ingredients) {
        return new FarmHousePizza();
    }
}
