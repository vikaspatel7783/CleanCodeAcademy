package com.object_creation.encapsulate_to_factory;


public class Order {

    public void orderPizza() {

        Pizza margheritaWithSingleCheesePizza = Pizza.createMargheritaWithSingleCheesePizza();

        Pizza margheritaWithDoubleCheesePizza = Pizza.createMargheritaWithDoubleCheesePizza();

        Pizza farmHousePizza = Pizza.createFarmHousePizza();

        Pizza maxicanGreenPizza = Pizza.createMaxicanGreenPizza();

        Pizza extraVagenzaPizza = Pizza.createExtraVagenzaPizza();
    }

}
