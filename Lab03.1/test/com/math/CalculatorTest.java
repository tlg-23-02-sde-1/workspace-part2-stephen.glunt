/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {
        System.out.println("Test Add");
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(1, 4));  // expected, actual
        assertEquals(12, calc.add(1, 5, 8, -2));
    }

    @Test
    public void testDivide() {
        System.out.println("Test Divide");
        Calculator calc = new Calculator();
        assertEquals(String.valueOf(3.5), 3.5, calc.divide(7, 2), 0.001);
    }

    @Test
    public void testIsEven(){
        System.out.println("Test isEven");
        Calculator calc = new Calculator();
        assertTrue(calc.isEven(13982));
        assertFalse(calc.isEven(1953));
    }

    @Test
    public void testSubtract() {
        System.out.println("Test subtract");
        Calculator calc = new Calculator();
        assertEquals(-5, calc.subtract(10, 5, 5,5));
    }
}