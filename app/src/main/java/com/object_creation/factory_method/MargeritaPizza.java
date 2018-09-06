package com.object_creation.factory_method;

public class MargeritaPizza extends Pizza {

    @Override
    Pizza createPizza() {
        return new MargeritaPizza();
    }
}
