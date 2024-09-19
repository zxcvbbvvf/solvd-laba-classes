package com.solvd.student.charles_borabon.threads.Employee_Management;

// DirectorCollection, extending EmployeeCollection for managing directors
public class DirectorCollection extends EmployeeCollection {
    public void listDirectors() {
        for (Employee employee : employees) {
            if (employee instanceof Director) {
                System.out.println(employee);
            }
        }
    }
}