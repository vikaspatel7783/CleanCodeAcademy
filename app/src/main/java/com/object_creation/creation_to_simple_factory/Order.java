package com.object_creation.creation_to_simple_factory;


public class Order {

    public void orderPizza() {

        Pizza margheritaWithSingleCheesePizza = PizzaFactory.createMargheritaWithSingleCheesePizza();

        Pizza margheritaWithDoubleCheesePizza = PizzaFactory.createMargheritaWithDoubleCheesePizza();

        Pizza farmHousePizza = PizzaFactory.createFarmHousePizza();

        Pizza maxicanGreenPizza = PizzaFactory.createMaxicanGreenPizza();

        Pizza extraVagenzaPizza = PizzaFactory.createExtraVagenzaPizza();
    }

}
