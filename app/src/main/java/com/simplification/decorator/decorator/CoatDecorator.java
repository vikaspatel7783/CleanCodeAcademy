package com.simplification.decorator.decorator;

import com.simplification.decorator.Statue;

class CoatDecorator extends StatueDecorator {

    private final Statue statue;

    CoatDecorator(Statue statue) {
        this.statue = statue;
    }

    @Override
    public void print() {
        statue.print();
        System.out.println("Coat Decorator");
    }
}
