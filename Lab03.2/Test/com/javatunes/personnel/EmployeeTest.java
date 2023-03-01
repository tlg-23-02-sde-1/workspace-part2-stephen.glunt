package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee emp1;
    private Employee emp2;
    @Before
    public void setUp() throws Exception {
        emp1 = new SalariedEmployee("Joseph", Date.valueOf("2010-10-10"));
        emp2 = new SalariedEmployee("Joseph", Date.valueOf("2010-10-10"));
    }



    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate(){
        emp2.setName("Jack");
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate() {
        emp2.setHireDate(Date.valueOf("2020-02-02"));
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp1, emp2);
    }
}