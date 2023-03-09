/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

public class EmployeeStreamsTest {
    private Collection<Employee> allEmployees;

    @Before
    public void setUp() {
        allEmployees = Department.getDepartment().getEmployees();
    }

    /**
     * STARTER TASK - given to us as an example
     * TASK: find all employees with salary < 40000.0 and sort them by natural order.
     * Employee implements Comparable: natural order is id increasing.
     *
     * RESULT: Employees 2 and 15, in that order.
     */
    @Test
    public void testSalaryLessThanSortNaturalOrder() {
        List<Employee> employees = allEmployees.stream()
                .filter(emp -> emp.getSalary() < 40000.0)
                .sorted()  // natural order
                .collect(Collectors.toList());

        assertEquals(2, employees.size());
        assertEquals(Long.valueOf(2),  employees.get(0).getId());
        assertEquals(Long.valueOf(15), employees.get(1).getId());
    }

    /**
     * TASK: find all employees whose name is 5 characters or less,
     * and sort them by salary increasing.
     */
    @Test
    public void findAll_nameLengthAtMost5_sortBySalary() {
        List<Employee> employees = allEmployees.stream()
                .filter(employee -> employee.getName().length() <= 5)
               // .sorted((a,b) -> Double.compare(a.getSalary(),b.getSalary()))
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
        dump(employees);
    }

    /**
     * TASK: find all employees that make 50000+
     * and sort them by hireDate increasing (earlier first).
     */
    @Test
    public void findAll_salaryAtLeast50000_sortByHireDate() {
        List<Employee> employees = allEmployees.stream()
                .filter(employee -> employee.getSalary() >= 50_000.)
//                .sorted((e1,e2) -> e1.getHireDate().compareTo(e2.getHireDate()))
                .sorted(Comparator.comparing(Employee::getHireDate))
                .collect(Collectors.toList());
        dump(employees);
    }

    /**
     * TASK: how many employees make at least 75K?
     */
    @Test
    public void count_salaryAtLeast75000() {
        long employeeCount = allEmployees.stream()
                .filter(employee -> employee.getSalary() >= 75_000.)
                .count();
        System.out.println(employeeCount);
    }

    /**
     * TASK: find the 3 highest-paid employees and sort them by name.
     */
    @Test
    public void threeHighestPaid_sortByName() {
        List<Employee> topThreePaid = allEmployees.stream()
                //.sorted((a,b) -> Double.compare(b.getSalary(), a.getSalary()))
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(3)
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
        dump(topThreePaid);
    }

    /**
     * TASK: find all names of the employees hired in 2010 or later.
     * JUST THE NAMES, and sort them in natural order.
     */
    @Test
    public void findAllNames_hired2010Later() {
        List<String> latestHires = allEmployees.stream()
                .filter(employee -> employee.getHireDate().isAfter(LocalDate.of(2009,12,31)))
                .map(Employee::getName)
                .sorted()
                .collect(Collectors.toList());
        dump(latestHires);
    }

    /**
     * TASK: pay all employees that make 50000 or less,
     * and pay them in this order: lowest-paid first, highest-paid last.
     *
     * NOTE: you are simply performing an action on them, not collecting them at the end.
     */
    @Test
    public void payAll_salaryAtMost50000_lowestPaidFirst() {
        allEmployees.stream()
                .filter(employee -> employee.getSalary() <= 50_000.)
//                .sorted((a,b) -> Double.compare(a.getSalary(), b.getSalary()))
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(Employee::pay);
    }

    /**
     * TASK: make all employees with salary 75000+ work(),
     * and do it in descending salary order, i.e., highest-paid works first, lowest-paid works last.
     */
    @Test
    public void workAll_salaryAtLeast75000_descendingSalaryOrder() {
        allEmployees.stream()
                .filter(employee -> employee.getSalary() >= 75_000.)
//                .sorted((a,b) -> Double.compare(b.getSalary(), a.getSalary()))
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(Employee::work);


    }

    /**
     * TASK: find all employees hired after the year 2000 that make less than 50000 dollars,
     * and give them a raise up to a clean 100K, doing so in order of least paid first.
     */
    @Test
    public void giveRaise_salaryLessThan50000_hiredAfter2000_lowestPaidFirst() {
        List<Employee> result = allEmployees.stream()
                .filter(employee -> employee.getHireDate().isAfter(LocalDate.of(2000,12,31)))
                .filter(employee -> employee.getSalary() < 50_000)
//                .sorted((a,b) -> Double.compare(a.getSalary(), b.getSalary()))
                .sorted(Comparator.comparing(Employee::getSalary))
                .peek(employee -> employee.setSalary(100_000.))
                .collect(Collectors.toList());

        dump(result);
    }

    /**
     * TASK: yes or no, do we have any employees whose name starts with 'Z'?
     */
    @Test
    public void anyEmployees_nameStartWithZ() {
        boolean empWithZName = allEmployees.stream()
                .anyMatch(employee -> employee.getName().startsWith("Z"));

        assertTrue(empWithZName);
    }

    /**
     * TASK: yes or no, are all employees hired in 2000 or later?
     */
    @Test
    public void allEmployeesHired2000_orLater() {
        boolean allHiredAfter2000 = allEmployees.stream()
                .allMatch(employee -> employee.getHireDate().isAfter(LocalDate.of(1999,12,31)));
        assertFalse(allHiredAfter2000);
    }

    /**
     * TASK: find the average salary of all employees hired in 2000 or later
     */
    @Test
    public void averageSalary_hired2000_orLater() {
        double averageSalary_hired2000_orLater = allEmployees.stream()
                .filter(employee -> employee.getHireDate().isAfter(LocalDate.of(1999, 12,31)))
                .mapToDouble(Employee::getSalary)//employee -> employee.getSalary()
                .average()
                .orElse(Double.NaN);
        System.out.println(averageSalary_hired2000_orLater);
    }

    /**
     * TASK: divide the employees into two groups:
     *  - those that make at least 50K
     *  - those that don't
     * This is called a "partitioning" operation.
     * The result is always Map<Boolean,List<Employee>>
     */
    @Test
    public void twoGroups_atLeast50K_lessThan50K() {
        Map<Boolean,List<Employee>> atLeast50K = allEmployees.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getSalary() >= 50_000.));
        List<Employee> fiftyPlus = atLeast50K.get(true);
        List<Employee> lessThanFifty = atLeast50K.get(false);

        dump(fiftyPlus);
        System.out.println("\n\nThis is the poor group:");
        dump(lessThanFifty);
    }

    /**
     * TASK: group our Employees by year of hire
     * 1999 | List<Employee> that were hired in 1999
     * 2009 | List<Employee> that were hired in 2009
     */
    @Test
    public void groupingByYearOfHire() {
        Map<Integer, List<Employee>> groupedByHireYear = allEmployees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getHireDate().getYear()));

        List<List<Employee>> result = new ArrayList<>(groupedByHireYear.values());

        for(var item : result){
            System.out.println();
            dump(item);
        }

    }

    /**
     * TASK: sort the 'animals' list by string length, and break all ties by natural order.
     *  For example: ant, bat, cat, dog, horse, snake, tiger, giraffe, panther
     */
    @Test
    public void twoPartComparator() {
        List<String> animals = Arrays.asList("monkey", "sloth", "baboon", "tiger", "snake", "panda", "parrot", "panther", "rhino", "horse");
        animals.sort(Comparator.comparing(String::length).thenComparing(String::compareTo));

        dump(animals);
    }

    // helper method to dump a Collection to stdout
    private static void dump(Collection<?> collection) {
        collection.forEach(System.out::println);
    }

    // helper method to dump a Map to stdout
    private static void dump(Map<?,?> map) {
        map.forEach((key, value) -> System.out.println(key + " | " + value));
    }
}