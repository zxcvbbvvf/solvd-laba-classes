import bank.BankCustomer;
import management.Employee;
import management.Management;
import zoo.Zoo;
import zoo.ZooAnimal;

public class Main {
    public static void main(String[] args) {
        // bank package test
        BankCustomer customer = new BankCustomer(123456, "John Doe", 1000.00, "Jane Doe", "1234 Elm St", "555-555-5555", "joe@email.com");
        BankCustomer customer2 = new BankCustomer(123456, "Jane Doe", 1000.00, "Jane Doe", "1234 Elm St", "555-555-5555", "jane@email.com");
        System.out.println(customer.toString());
        customer.deposit(500.00);
        System.out.println(customer.toString());
        customer.withdraw(200.00);
        System.out.println(customer.toString());
        System.out.println("Number of customers: " + BankCustomer.getCustomerCount());
        System.out.println("--------------------");

        // zoo package test
        Zoo zoo = new Zoo();
        System.out.println(zoo.toString());
        System.out.println("--------------------");

        ZooAnimal zooAnimal = new ZooAnimal("Lion", "Roar", 3);
        ZooAnimal zooAnimal2 = new ZooAnimal("Moose", "Moo", 2);
        System.out.println(zooAnimal.toString());
        System.out.println();
        System.out.println(zooAnimal2.toString());
        System.out.println();
        System.out.println("Number of animals: " + ZooAnimal.getAnimalCount());
        System.out.println("Are the two ZooAnimal objects the same? " + zooAnimal.equals(zooAnimal2));
        System.out.println("Hash code for zooAnimal: " + zooAnimal.hashCode());
        System.out.println("Hash code for zooAnimal2: " + zooAnimal2.hashCode());
        System.out.println("--------------------");

        // management package test
        Management management = new Management("John Doe");
        System.out.println(management.toString());
        System.out.println("--------------------");

        Employee employee = new Employee("John Doe", "HR", "Manager");
        Employee employee2 = new Employee("Jane Doe", "HR", "Manager");
        System.out.println(employee.toString());
        System.out.println();
        System.out.println(employee2.toString());
        System.out.println();
        System.out.println("Number of management objects: " + Management.getManagementCount());
        System.out.println("Number of employees: " + Employee.getEmployeeCount());
    }
}