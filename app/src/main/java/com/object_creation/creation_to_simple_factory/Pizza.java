package com.object_creation.creation_to_simple_factory;

class Pizza {

    Pizza() {}

    Pizza(String doubleCheese) {}

    Pizza(String veggies, String capsicum, String mushroom, String tomatoes) {}

    Pizza(String onion, String capsicum, String tomatoes, String jalapenos, String herbs) {}

    Pizza(String corn, String blackOlives, String onion, String capsicum, String mushrooms, String tomatoes, String jalapenos) {}

    /*public static Pizza createMargheritaWithSingleCheesePizza() {
        return new Pizza();
    }

    public static Pizza createMargheritaWithDoubleCheesePizza() {
        return new Pizza("DoubleCheese");
    }

    public static Pizza createFarmHousePizza() {
        return new Pizza("veggies", "capsicum", "mushroom", "tomatoes");
    }

    public static Pizza createMaxicanGreenPizza() {
        return new Pizza("onion", "capsicum", "tomatoes", "jalapenos", "herbs");
    }

    public static Pizza createExtraVagenzaPizza() {
        return new Pizza("corn", "blackOlives", "onion", "capsicum", "mushrooms", "tomatoes", "jalapenos");
    }*/

    public void printAboutUs() {}

    public void locateTheStore() {}

    public void shareFeedback(String feedback) {}

    public void rateUs(String ratings) {}

    public void fetchFoodDeliveryParterners() {}
}
