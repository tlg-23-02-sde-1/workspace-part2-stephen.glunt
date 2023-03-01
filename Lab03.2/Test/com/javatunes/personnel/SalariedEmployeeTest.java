package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    //object under test - called a "fixture" in JUnit
    private SalariedEmployee emp1;
    private SalariedEmployee emp2;

    @Before
    public void setUp() {
        emp1 = new SalariedEmployee("Joseph", Date.valueOf("2010-10-10"),50_000.0);
        emp2 = new SalariedEmployee("Joseph", Date.valueOf("2010-10-10"),50_000.0);

    }

    @Test
    public void hashCode_equalObjects_mustHaveEqualHashCodes(){
        assertEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate_sameSalary() {
        emp2.setName("Jack");
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differtntHireDate_sameSalary() {
        emp2.setHireDate(Date.valueOf("2020-02-02"));
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_differentSalary(){
        emp2.setSalary(1000.);
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame(){
        assertEquals(emp1, emp2);
    }

    @Test
    public void testPay(){
        assertEquals(50_000.0, emp1.pay(), .0001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(15_000.0, emp1.payTaxes(), 0.001);
    }
}