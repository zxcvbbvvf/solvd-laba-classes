package com.solvd.student.charles_borabon.collections_and_generics.Employee_Management;

import java.util.ArrayList;
import java.util.List;

public class EmployeeCollection {
    protected List<Employee> employees;

    public EmployeeCollection() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void displayEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}