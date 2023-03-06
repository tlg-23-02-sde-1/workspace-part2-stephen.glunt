/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import com.javatunes.billing.Location;
import com.javatunes.billing.TaxCalculator;
import com.javatunes.billing.TaxCalculatorFactory;

import java.util.Collection;

public class Order {
    private String id;
    private Double cartTotal;
    private TaxCalculator taxCalc;
    private Location location;

    public Order(String id) {
        this.id = id;
    }

    public Order(String id, TaxCalculator taxCalc){
        this(id);
        this.taxCalc = taxCalc;
    }

    public Order(String id, Location location){
        this(id);
        this.location = location;
        this.taxCalc = TaxCalculatorFactory.getTaxCalculator(location);
    }

    /**
     * DONE:
     * get the items from the cart and iterate over them, print each item's product code
     * get cart total and print
     */
    public void processCart(ShoppingCart<? extends Product> cart) {
        System.out.println("Order: " + getId() + " contains the following:");

        Collection<? extends Product> cartItems = cart.allItems();
        for (Product product : cartItems) {
            System.out.println(product.getCode());
        }
        cartTotal = cart.total();
        System.out.println("Order Total: " + cart.total());
    }

    public String getId() {
        return id;
    }

    public Double getCartTotal() {
        return cartTotal;
    }

    public double getTax(TaxCalculator calculator) {
      return calculator.taxAmount(getCartTotal());
    }

    public double getTax(){
        return taxCalc.taxAmount(getCartTotal());
    }
}