package com.solvd.student.charles_borabon.collections_and_generics.Employee_Management;

// ManagerCollection, extending EmployeeCollection for managing managers
public class ManagerCollection extends EmployeeCollection {
    public void listManagers() {
        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                System.out.println(employee);
            }
        }
    }
}
