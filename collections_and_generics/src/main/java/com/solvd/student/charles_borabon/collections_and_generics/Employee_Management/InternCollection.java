package com.solvd.student.charles_borabon.collections_and_generics.Employee_Management;

// InternCollection, extending EmployeeCollection for managing interns
public class InternCollection extends EmployeeCollection {
    public void displayInterns() {
        for (Employee employee : employees) {
            if (employee instanceof Intern) {
                System.out.println(employee);
            }
        }
    }
}