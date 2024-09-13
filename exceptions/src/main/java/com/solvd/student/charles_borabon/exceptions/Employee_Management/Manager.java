package com.solvd.student.charles_borabon.exceptions.Employee_Management;

import java.util.Objects;

public class Manager extends Employee {
    private String department;
    private static String company = "Solvd Corp";
    private static int managerCount = 0;

    // Static block
    static {
        System.out.println("Static block in Manager is called.");
        managerCount = 0;
    }

    public Manager(String name, int id, double salary, String department) {
        super(name, id, salary);
        this.department = department;
        managerCount++;
    }

    // Static method
    public static int getManagerCount() {
        return managerCount;
    }

    // Method to get department
    public String getDepartment() {
        return department;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Manager [Name=" + name + ", ID=" + id + ", Salary=" + salary + ", Department=" + department + "]";
    }

    // Override hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), department);
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Manager)) return false;
        if (!super.equals(obj)) return false;
        Manager manager = (Manager) obj;
        return Objects.equals(department, manager.department);
    }

    @Override
    public void work() {
        System.out.println(name + " is managing the department " + department);
    }
}