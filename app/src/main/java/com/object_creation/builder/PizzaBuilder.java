package com.object_creation.builder;

public class PizzaBuilder {

    private boolean doubleCheese;
    private boolean veggies;
    private boolean capsicum;
    private boolean tomatoes;
    private boolean onion;
    private boolean herbs;
    private boolean corn;
    private boolean blackOlives;
    private boolean mushrooms;
    private boolean jalapenos;

    public PizzaBuilder addDoubleCheese() {
        this.doubleCheese = true;
        return this;
    }

    public PizzaBuilder addVeggies() {
        this.veggies = true;
        return this;
    }

    public PizzaBuilder addCapsicum() {
        this.capsicum = true;
        return this;
    }

    public PizzaBuilder addTomatoes() {
        this.tomatoes = true;
        return this;
    }

    public PizzaBuilder addOnion() {
        this.onion = true;
        return this;
    }

    public PizzaBuilder addHerbs() {
        this.herbs = true;
        return this;
    }

    public PizzaBuilder addCorn() {
        this.corn = true;
        return this;
    }

    public PizzaBuilder addBlackOlives() {
        this.blackOlives = true;
        return this;
    }

    public PizzaBuilder addMushrooms() {
        this.mushrooms = true;
        return this;
    }

    public PizzaBuilder addJalapenos() {
        this.jalapenos = true;
        return this;
    }

    public Pizza build() {
        if (doubleCheese) {
            return new MargeritaPizza();
        }
        return new FarmHousePizza();
    }
}