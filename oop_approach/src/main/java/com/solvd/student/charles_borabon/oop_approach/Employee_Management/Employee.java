package com.solvd.student.charles_borabon.oop_approach.Employee_Management;

import java.util.Objects;

public class Employee {
    protected String name;
    protected int id;
    protected double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Employee [Name=" + name + ", ID=" + id + ", Salary=" + salary + "]";
    }

    // Override hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(name, id, salary);
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return id == employee.id && Double.compare(employee.salary, salary) == 0 && Objects.equals(name, employee.name);
    }
}