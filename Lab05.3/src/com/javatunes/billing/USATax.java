/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.billing;

/**
 * Domestic orders have a graduated tax scheme:
 * The first $20.00 is tax-free.
 * Amount over $20.00 is taxed at 10.0%.
 * <p>
 * TODO: implement this algorithm.
 */
public class USATax implements TaxCalculator {
    private static final double MIN_TAXABLE = 20.0;
    private static final double TAX_RATE = .1;

    @Override
    public double taxAmount(double taxable) {
        return (taxable <= MIN_TAXABLE)? 0.0 : (taxable - MIN_TAXABLE) *TAX_RATE;
    }
}