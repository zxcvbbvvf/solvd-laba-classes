import bank.Bank;
import bank.BankCustomer;
import management.Employee;
import management.Management;
import zoo.Zoo;
import zoo.ZooAnimal;

public class Main {
    public static void main(String[] args) {
        // bank package test
        Bank bank = new Bank(123456, "John Doe", 1000.00);
        System.out.println(bank.toString());
        System.out.println("--------------------");

        BankCustomer customer = new BankCustomer(123456, "John Doe", 1000.00, "Jane Doe", "1234 Elm St", "555-555-5555", "jane@email.com");
        System.out.println(customer.toString());
        customer.deposit(500.00);
        System.out.println(customer.toString());
        customer.withdraw(200.00);
        System.out.println(customer.toString());
        System.out.println("--------------------");

        // zoo package test
        Zoo zoo = new Zoo(1, "Lion");
        System.out.println(zoo.toString());
        System.out.println("--------------------");

        ZooAnimal zooAnimal = new ZooAnimal(1, "Lion", "Roar");
        ZooAnimal zooAnimal2 = new ZooAnimal(1, "Lion", "Roar");
        System.out.println(zooAnimal.toString());
        System.out.println("Are the two ZooAnimal obejcts the same? " + zooAnimal.equals(zooAnimal2));
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
        System.out.println(employee2.toString());
    }
}