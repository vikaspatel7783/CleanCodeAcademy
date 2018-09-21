package com.simplification.decorator.decorator;

import com.simplification.decorator.WaxStatue;
import com.simplification.decorator.Statue;
import com.simplification.decorator.PlasticStatue;

import junit.framework.Assert;

import org.junit.Test;

public class TieDecoratorTest {

    @Test
    public void testPlasticStatueWithTie() {
        TieDecorator tieDecorator = new TieDecorator(new PlasticStatue());
        tieDecorator.print();
        Assert.assertTrue(true);
    }

    @Test
    public void testWaxStatueWithTie() {
        TieDecorator tieDecorator = new TieDecorator(new WaxStatue());
        tieDecorator.print();
        Assert.assertTrue(true);
    }

    @Test
    public void testPlasticStatueWithTieAndCoat() {
        Statue plasticStatue = new PlasticStatue();
        plasticStatue = new TieDecorator(plasticStatue);
        plasticStatue = new CoatDecorator(plasticStatue);
        plasticStatue.print();
        Assert.assertTrue(true);
    }

    @Test
    public void testWaxStatueWithTieAndCoat() {
        Statue waxStatue = new WaxStatue();
        waxStatue = new TieDecorator(waxStatue);
        waxStatue = new CoatDecorator(waxStatue);
        waxStatue.print();
        Assert.assertTrue(true);
    }

}