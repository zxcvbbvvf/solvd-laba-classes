package com.solvd.student.charles_borabon.lambda_enums.Employee_Management;

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
