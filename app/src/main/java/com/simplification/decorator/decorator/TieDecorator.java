package com.simplification.decorator.decorator;

import com.simplification.decorator.Statue;

class TieDecorator extends StatueDecorator {

    private final Statue statue;

    TieDecorator(Statue statue){
        this.statue = statue;
    }


    @Override
    public void print() {
        statue.print();
        System.out.println("Tie Decorator");
    }
}
