package com.solvd.student.charles_borabon.threads.Employee_Management;

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

    public void listEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}