package com.hotelmolveno.hotel;

import com.hotelmolveno.controller.SimpleCalculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleCalculatorTest {
    private SimpleCalculator calculator;

    @Before
    public void setUp(){
        this.calculator = new SimpleCalculator();
    }

    @Test
    public void testSubtract(){
        int actual = this.calculator.subtract(50, 5);

        Assert.assertEquals(45, actual);
    }

    @Test
    public void testDivide(){
        int actual = this.calculator.devide(50, 5);

        Assert.assertEquals(10, actual);
    }
    @Test
    public void testMultiply(){
        int actual = this.calculator.multiply(50, 5);

        Assert.assertEquals(250, actual);
    }

    @After
    public void tearDown(){
        this.calculator = null;
    }
}
