package com.simplification.decorator;

public class WaxStatue extends Statue {

    @Override
    public void print() {
        System.out.println(WaxStatue.class.getSimpleName());
    }
}
