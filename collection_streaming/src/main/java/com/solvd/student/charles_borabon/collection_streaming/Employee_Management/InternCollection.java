package com.solvd.student.charles_borabon.collection_streaming.Employee_Management;

// InternCollection, extending EmployeeCollection for managing interns
public class InternCollection extends EmployeeCollection {
    public void listInterns() {
        for (Employee employee : employees) {
            if (employee instanceof Intern) {
                System.out.println(employee);
            }
        }
    }
}