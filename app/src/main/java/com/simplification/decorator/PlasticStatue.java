package com.simplification.decorator;

public class PlasticStatue extends Statue {

    @Override
    public void print() {
        System.out.println(PlasticStatue.class.getSimpleName());
    }
}
