package com.object_creation.factory_method;

public class MargeritaPizza extends Pizza {

    @Override
    Pizza createPizza(String... ingredients) {
        return new MargeritaPizza();
    }
}
