package com.adv.java.iostream;

import java.time.*;
import java.io.*;
public class Employee implements Serializable {
    private String name;
    private double salary;
    private LocalDate hireDate;

    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        hireDate = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getHireDay() {
        return hireDate.toString();
    }
}
