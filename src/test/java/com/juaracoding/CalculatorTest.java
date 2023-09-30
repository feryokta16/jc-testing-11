package com.juaracoding;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
    @Test
    public void testAdd(){
        Calculator calculator = new Calculator();
        calculator.add(10, 5);
        //expected=15 dan actual = setelah eksekusi

        Assert.assertEquals(calculator.add(10,5),15);
    }
}
