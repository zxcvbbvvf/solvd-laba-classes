package com.solvd.student.charles_borabon.oop_approach;
import com.solvd.student.charles_borabon.oop_approach.Employee_Management.Director;
import com.solvd.student.charles_borabon.oop_approach.Employee_Management.Employee;
import com.solvd.student.charles_borabon.oop_approach.Employee_Management.Manager;

public class Main {

    public static void main(String[] args) {
        // Create Employee object
        Employee emp1 = new Employee("Alice", 1001, 50000);
        Employee emp2 = new Employee("Bob", 1002, 55000);
        
        // Create Manager object
        Manager mgr1 = new Manager("Carol", 1003, 60000, "HR");
        Manager mgr2 = new Manager("Dave", 1004, 62000, "Finance");
        
        // Create Director object
        Director dir1 = new Director("Eve", 1005, 80000, "IT", 10000);
        Director dir2 = new Director("Frank", 1006, 85000, "Marketing", 12000);

        // Test toString() method
        System.out.println("Employee toString: " + emp1.toString());
        System.out.println("Manager toString: " + mgr1.toString());
        System.out.println("Director toString: " + dir1.toString());

        // Test equals() method
        System.out.println("\nComparing Employees: " + emp1.equals(emp2));
        System.out.println("Comparing Managers: " + mgr1.equals(mgr2));
        System.out.println("Comparing Directors: " + dir1.equals(dir2));

        // Test hashCode() method
        System.out.println("\nEmployee hashCode: " + emp1.hashCode());
        System.out.println("Manager hashCode: " + mgr1.hashCode());
        System.out.println("Director hashCode: " + dir1.hashCode());
    }
}
