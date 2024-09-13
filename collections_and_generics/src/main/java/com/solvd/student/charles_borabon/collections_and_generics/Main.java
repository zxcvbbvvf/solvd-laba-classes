package com.solvd.student.charles_borabon.collections_and_generics;
import com.solvd.student.charles_borabon.collections_and_generics.Employee_Management.CustomLinkedList;
import com.solvd.student.charles_borabon.collections_and_generics.Employee_Management.Director;
import com.solvd.student.charles_borabon.collections_and_generics.Employee_Management.DirectorCollection;
import com.solvd.student.charles_borabon.collections_and_generics.Employee_Management.Employee;
import com.solvd.student.charles_borabon.collections_and_generics.Employee_Management.EmployeeGroup;
import com.solvd.student.charles_borabon.collections_and_generics.Employee_Management.Intern;
import com.solvd.student.charles_borabon.collections_and_generics.Employee_Management.InternCollection;
import com.solvd.student.charles_borabon.collections_and_generics.Employee_Management.Manager;
import com.solvd.student.charles_borabon.collections_and_generics.Employee_Management.ManagerCollection;

public class Main {
    public static void main(String[] args) {
        // Test LinkedList with Generics
        CustomLinkedList<String> stringList = new CustomLinkedList<>();
        stringList.add("Alice");
        stringList.add("Bob");
        stringList.add("Charlie");
        System.out.println("LinkedList of Strings:");
        stringList.display();
        stringList.remove("Bob");
        System.out.println("After removing Bob:");
        stringList.display();

        // Test EmployeeCollection and its subclasses
        Employee emp1 = new Manager("John", 45, 0.0, "Manager");
        Employee emp2 = new Intern("Anna", 22, 0.0);
        Employee emp3 = new Director("Robert", 50, 0.0, "Director", 0.0);

        ManagerCollection managerCollection = new ManagerCollection();
        managerCollection.addEmployee(emp1);
        managerCollection.addEmployee(emp3); // Added Director, but only managers should be listed
        System.out.println("\nManager Collection:");
        managerCollection.listManagers();

        InternCollection internCollection = new InternCollection();
        internCollection.addEmployee(emp2);
        System.out.println("\nIntern Collection:");
        internCollection.listInterns();

        DirectorCollection directorCollection = new DirectorCollection();
        directorCollection.addEmployee(emp3);
        System.out.println("\nDirector Collection:");
        directorCollection.listDirectors();

        // Test EmployeeGroup
        EmployeeGroup employeeGroup = new EmployeeGroup();
        employeeGroup.addEmployee(emp1);
        employeeGroup.addEmployee(emp2);
        employeeGroup.addEmployee(emp3);
        System.out.println("\nEmployee Group:");
        employeeGroup.groupDetails();
        employeeGroup.listEmployees();
    }
}