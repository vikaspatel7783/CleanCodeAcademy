package com.object_creation.method_creation.refactor;

public class Order {

    public void orderPizza() {

        Pizza margheritaWithSingleCheesePizza = Pizza.createMargheritaWithSingleCheesePizza();

        Pizza margheritaWithDoubleCheesePizza = Pizza.createMargheritaWithDoubleCheesePizza();

        Pizza farmHousePizza = Pizza.createFarmHousePizza();

        Pizza maxicanGreenPizza = Pizza.createMaxicanGreenPizza();

        Pizza extraVagenzaPizza = Pizza.createExtraVagenzaPizza();
    }

}
