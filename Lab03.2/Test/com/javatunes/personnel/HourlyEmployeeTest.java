package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    private HourlyEmployee emp1;
    private HourlyEmployee emp2;
    @Before
    public void setUp()  {
        emp1 = new HourlyEmployee("Carl", Date.valueOf("2020-02-02"), 40.0, 40.);
        emp2 = new HourlyEmployee("Carl", Date.valueOf("2020-02-02"), 40.0, 40.);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame(){
        assertEquals(emp1, emp2);
    }

    @Test
    public void pay() {
        assertEquals(1600.0, emp1.pay(), .001);
    }

    @Test
    public void payTaxes() {
        assertEquals(400.0, emp1.payTaxes(), .001);
    }

    @Test
    public void getRate() {
        assertEquals(40., emp1.getRate(), .001);
    }

    @Test
    public void setRate() {
        emp1.setRate(50.0);
        assertEquals(50.0, emp1.getRate(), .001);
    }

    @Test
    public void getHours() {
        assertEquals(40., emp1.getHours(), .001);
    }

    @Test
    public void setHours() {
        emp1.setHours(50.);
        assertEquals(50., emp1.getHours(), .001);
    }
}