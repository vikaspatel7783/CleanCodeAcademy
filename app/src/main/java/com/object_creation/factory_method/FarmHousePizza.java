package com.object_creation.factory_method;

public class FarmHousePizza extends Pizza {

    @Override
    Pizza createPizza() {
        return new FarmHousePizza();
    }
}
