package com.solvd.student.charles_borabon.oop_approach_part2;
import com.solvd.student.charles_borabon.oop_approach_part2.Employee_Management.Director;
import com.solvd.student.charles_borabon.oop_approach_part2.Employee_Management.Employee;
import com.solvd.student.charles_borabon.oop_approach_part2.Employee_Management.Intern;
import com.solvd.student.charles_borabon.oop_approach_part2.Employee_Management.Manager;

public class Main {

    public static void main(String[] args) {
        // Create Employee objects
        Employee emp1 = new Manager("Alice", 1001, 50000, "HR");
        Employee emp2 = new Director("Bob", 1002, 80000, "IT", 10000);

        // Test polymorphism
        emp1.work();  // Manager work method
        emp2.work();  // Director work method

        // Final class
        Intern intern = new Intern("Charlie", 1003, 20000);
        intern.work();

        // Test static method and block
        System.out.println("Number of managers: " + Manager.getManagerCount());

        // Test final method
        emp1.displayEmployeeInfo();
    }
}