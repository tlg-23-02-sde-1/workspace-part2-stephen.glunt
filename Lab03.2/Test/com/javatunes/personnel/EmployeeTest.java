package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee emp1;
    private Employee emp2;
    private Employee emp3;
    private Employee emp4;
    @Before
    public void setUp() throws Exception {
//        emp1 = new SalariedEmployee("Joseph", Date.valueOf("2010-10-10"));
//        emp2 = new SalariedEmployee("Joseph", Date.valueOf("2010-10-10"));
        emp1 = getDummyEmployee("Joseph", Date.valueOf("2010-10-10"));
        emp2 = getDummyEmployee("Joseph", Date.valueOf("2010-10-10"));
        emp3 = new DummyEmployee("Joseph", Date.valueOf("2010-10-10"));
        emp4 = new DummyEmployee("Joseph", Date.valueOf("2010-10-10"));
    }

    private Employee getDummyEmployee(String name, Date date){
        return new Employee() {
            public double pay() {return 0;}
            public double payTaxes() {return 0;}
        };
    }


    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate(){
        emp3.setName("Jack");
        assertNotEquals(emp4, emp3);
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

    // NAMED MEMBER-LEVEL INNER CLASSES
    private class DummyEmployee extends Employee {
        DummyEmployee (String name, Date date){
            super(name, date);
        }

        @Override
        public double pay() {
            return 0;
        }

        @Override
        public double payTaxes() {
            return 0;
        }
    }
}