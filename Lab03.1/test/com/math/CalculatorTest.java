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

import org.junit.*;

public class CalculatorTest {

    // object(s) under test - called a "fixture" in JUnit
    private Calculator calc;

    @BeforeClass
    public static void initializeEntireTestRun() {
        System.out.println("initializeEntireTestRun");
    }

    @AfterClass
    public static void finalizeTestRun() {
        System.out.println("finalizeTestRun");
    }

    @Before
    public void setUp() {
        System.out.println("setUp");
        calc = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    public void testAdd() {
        System.out.println("Test Add");
        assertEquals(5, calc.add(1, 4));  // expected, actual
        assertEquals(12, calc.add(1, 5, 8, -2));
    }

    @Test
    public void testDivide() {
        System.out.println("Test Divide");
        assertEquals(String.valueOf(3.5), 3.5, calc.divide(7, 2), 0.001);
    }

    @Test
    public void testIsEven(){
        System.out.println("Test isEven");
        assertTrue(calc.isEven(13982));
        assertFalse(calc.isEven(1953));
    }

    @Test
    public void testSubtract() {
        System.out.println("Test subtract");
        assertEquals(-5, calc.subtract(10, 5, 5,5));
    }
}