package com.solvd.student.charles_borabon.threads.Employee_Management;

// EmployeeGroup: Generalized group of employees
public class EmployeeGroup extends EmployeeCollection {
    public void groupDetails() {
        System.out.println("This is a group of employees with " + employees.size() + " members.");
    }
}