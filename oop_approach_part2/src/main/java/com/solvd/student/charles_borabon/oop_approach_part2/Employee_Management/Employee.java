package com.solvd.student.charles_borabon.oop_approach_part2.Employee_Management;

import java.util.Objects;

public abstract class Employee implements Payable, Promotable, Trainable, Transferable, Retirable {
    protected final String name;
    protected final int id;
    protected double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Abstract method to be implemented by subclasses
    public abstract void work();

    // Final method
    public final void displayEmployeeInfo() {
        System.out.println("Employee: " + name + ", ID: " + id);
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

    // Methods from the interfaces
    @Override
    public void getPaid() {
        System.out.println(name + " has been paid " + salary);
    }

    @Override
    public void promote() {
        System.out.println(name + " has been promoted.");
    }

    @Override
    public void train() {
        System.out.println(name + " is attending a training session.");
    }

    @Override
    public void transfer() {
        System.out.println(name + " has been transferred.");
    }

    @Override
    public void retire() {
        System.out.println(name + " has retired.");
    }
}