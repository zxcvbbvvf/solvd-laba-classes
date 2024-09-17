package com.solvd.student.charles_borabon.collection_streaming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import com.solvd.student.charles_borabon.collection_streaming.Employee_Management.CustomLinkedList;
import com.solvd.student.charles_borabon.collection_streaming.Employee_Management.Director;
import com.solvd.student.charles_borabon.collection_streaming.Employee_Management.DirectorCollection;
import com.solvd.student.charles_borabon.collection_streaming.Employee_Management.Employee;
import com.solvd.student.charles_borabon.collection_streaming.Employee_Management.EmployeeGroup;
import com.solvd.student.charles_borabon.collection_streaming.Employee_Management.Intern;
import com.solvd.student.charles_borabon.collection_streaming.Employee_Management.InternCollection;
import com.solvd.student.charles_borabon.collection_streaming.Employee_Management.Manager;
import com.solvd.student.charles_borabon.collection_streaming.Employee_Management.ManagerCollection;

// Complex Enums
enum Department {
    HR("Human Resources", 10),
    IT("Information Technology", 20),
    SALES("Sales", 30),
    MARKETING("Marketing", 40),
    FINANCE("Finance", 50);

    private String name;
    private int code;

    Department(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public static Department getDepartmentByCode(int code) {
        for (Department dep : Department.values()) {
            if (dep.getCode() == code) {
                return dep;
            }
        }
        return null;
    }
}

enum Position {
    MANAGER("Manager", 5000),
    DIRECTOR("Director", 10000),
    INTERN("Intern", 2000),
    CEO("CEO", 20000),
    CFO("CFO", 15000);

    private String title;
    private double salary;

    Position(String title, double salary) {
        this.title = title;
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public double getSalary() {
        return salary;
    }
}

enum EmployeeStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    RETIRED("Retired"),
    TERMINATED("Terminated");

    private String status;

    EmployeeStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

enum CompanyBenefits {
    HEALTH_INSURANCE(1),
    PENSION_PLAN(2),
    STOCK_OPTIONS(3),
    COMPANY_CAR(4),
    RELOCATION_ALLOWANCE(5);

    private int benefitId;

    CompanyBenefits(int benefitId) {
        this.benefitId = benefitId;
    }

    public int getBenefitId() {
        return benefitId;
    }

    public static List<CompanyBenefits> getBenefitsList() {
        return Arrays.asList(CompanyBenefits.values());
    }
}

enum ProjectType {
    DEVELOPMENT("Development"),
    MARKETING("Marketing Campaign"),
    SUPPORT("Customer Support"),
    RESEARCH("Research & Development"),
    SALES("Sales Initiative");

    private String description;

    ProjectType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

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
        System.out.println("--------------------");

        // Test EmployeeCollection and its subclasses
        Employee emp1 = new Manager("John", 45, 0.0, 5, "Manager");
        Employee emp2 = new Intern("Anna", 22, 0.0, 0);
        Employee emp3 = new Director("Robert", 50, 0.0, 10, "Director", 0.0);

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
        System.out.println("--------------------");

        // Test EmployeeGroup
        EmployeeGroup employeeGroup = new EmployeeGroup();
        employeeGroup.addEmployee(emp1);
        employeeGroup.addEmployee(emp2);
        employeeGroup.addEmployee(emp3);
        System.out.println("\nEmployee Group:");
        employeeGroup.groupDetails();
        employeeGroup.listEmployees();
        System.out.println("--------------------");

        // Lambda Functions from java.util.function
        Predicate<Employee> isManager = emp -> emp instanceof Manager;
        Function<Employee, String> employeeName = Employee::getName;
        Consumer<Employee> printEmployee = emp -> System.out.println("Employee: " + emp.getName());
        Supplier<Director> directorSupplier = () -> new Director("New Director", 40, 5000, 9, "Director", 1000);
        UnaryOperator<Employee> promoteEmployee = emp -> {
            emp.setAge(emp.getAge() + 1);
            return emp;
        };

        // Test Lambdas
        System.out.println("Is emp1 a manager? " + isManager.test(emp1));
        System.out.println("emp2 name: " + employeeName.apply(emp2));
        printEmployee.accept(emp1);
        Director newDirector = directorSupplier.get();
        System.out.println("New Director Name: " + newDirector.getName());
        promoteEmployee.apply(emp1);
        System.out.println("Promoted Manager's Age: " + emp1.getAge());
        System.out.println("--------------------");

        // Custom Lambda with Generics
        BiFunction<String, Integer, String> concatenateStringAndInt = (str, num) -> str + num;
        UnaryOperator<List<String>> reverseList = list -> {
            Collections.reverse(list);
            return list;
        };
        Predicate<Map<String, Integer>> hasValueGreaterThanTen = map -> map.values().stream().anyMatch(val -> val > 10);

        // Testing custom lambdas
        System.out.println("Concatenated result: " + concatenateStringAndInt.apply("Age: ", 25));
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        System.out.println("Reversed names: " + reverseList.apply(names));
        Map<String, Integer> sampleMap = new HashMap<>();
        sampleMap.put("Key1", 5);
        sampleMap.put("Key2", 15);
        System.out.println("Map has value greater than 10: " + hasValueGreaterThanTen.test(sampleMap));
        System.out.println("--------------------");
    }
}