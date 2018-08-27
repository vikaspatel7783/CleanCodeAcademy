package com.cleancodeacademy.mobile;

import com.accumulation.visitor_pattern.MyMain;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    /*@Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }*/

    @Test
    public void testTotalFamiliesContributionTo30() {
        MyMain myMain = new MyMain();
        int totalContribution = myMain.collectContribution();
        Assert.assertEquals(50,totalContribution);
    }

}