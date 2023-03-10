/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import static org.junit.Assert.*;

import com.javatunes.billing.TaxCalculator;
import com.javatunes.billing.TaxCalculatorFactory;
import com.javatunes.billing.USATax;
import org.junit.Before;
import org.junit.Test;
import com.javatunes.billing.Location;

public class OrderTaxTest {
    private ShoppingCart<Product> cart1;
    private ShoppingCart<Product> cart2;

    @Before
    public void init() {
        cart1 = new ShoppingCart<Product>();  // $20.00
        cart1.addItem(new MusicItem("CD-501"));
        cart1.addItem(new MusicItem("CD-519"));

        cart2 = new ShoppingCart<Product>();  // $120.00
        cart2.addItem(new MusicItem("CD-511"));
        cart2.addItem(new MusicItem("CD-512"));
        cart2.addItem(new MediaPlayer("MP3-LP150"));
        cart2.addItem(new MediaPlayer("MP4-JR1205"));
    }

    /**
     * TODO: (for each of the test cases below)
     * 1. Create an order for *each* cart in the setup, e.g., Order order1 = new Order(...)
     * 2. Remember to call order1.processCart(cart1) -> that method computes the order's total cost.
     * 3. DEPENDING ON YOUR IMPLEMENTATION, initialize somehow the Order's TaxCalculator strategy.
     *     - For example, if you wrote a factory for TaxCalculator (option 1), make sure the Order has a Location set,
     *       since the factory (most likely) is using this to determine which strategy to provide.
     *     - If you are injecting the TaxCalculator into the Order (option 2, perhaps from an OrderFactory), use that
     *       factory to create the Orders.
     *     - If you're injecting the TaxCalculator from the client, do so here.
     * 4. Verify that the order's tax is as expected.
     * <p>
     * TEST NOTE: you can split the two orders per location into two test cases, if desired.
     */
    @Test
    public void testTaxOnlineOrder() {
        Order myOrder = new Order("Online", Location.ONLINE);
        myOrder.processCart(cart1);
        double tax = myOrder.getTax();
        assertEquals(0., tax, 0.00001);
        myOrder.processCart(cart2);
        assertEquals(0., myOrder.getTax(), .0001);

    }

    @Test
    public void testTaxEuropeOrder() {
        Order myOrder = new Order("Europe");
        myOrder.processCart(cart1);
        double tax = myOrder.getTax(TaxCalculatorFactory.getTaxCalculator(Location.EUROPE));
        assertEquals(20. * .17, tax, .0001);
        myOrder.processCart(cart2);
        tax = myOrder.getTax(TaxCalculatorFactory.getTaxCalculator(Location.EUROPE));
        assertEquals(25.4, tax, .0001);
    }

    @Test
    public void testTaxUSAOrder() {
        Order myOrder = new Order("USA", TaxCalculatorFactory.getTaxCalculator(Location.USA));
        myOrder.processCart(cart1);
        double tax = myOrder.getTax();
        assertEquals(0., tax, .0001);
        myOrder.processCart(cart2);
        tax = myOrder.getTax();
        assertEquals(10., tax, .0001);
    }
}