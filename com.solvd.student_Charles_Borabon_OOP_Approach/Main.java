import bank.Bank;
import bank.BankCustomer;
import zoo.Zoo;
import zoo.ZooAnimal;

public class Main {
    public static void main(String[] args) {
        // bank package test
        Bank bank = new Bank(123456, "John Doe", 1000.00);
        bank.display();
        bank.deposit(500.00);
        bank.display();
        bank.withdraw(200.00);
        bank.display();
        System.out.println("--------------------");

        BankCustomer customer = new BankCustomer(123456, "John Doe", 1000.00, "Jane Doe", "1234 Elm St", "555-555-5555", "jane@email.com");
        customer.display();
        customer.deposit(500.00);
        customer.display();
        customer.withdraw(200.00);
        customer.display();
        System.out.println("--------------------");

        // zoo package test
        Zoo zoo = new Zoo(1, "Lion");
        zoo.printZoo();
        System.out.println("--------------------");

        ZooAnimal zooAnimal = new ZooAnimal(1, "Lion", "Roar");
        zooAnimal.printZoo();
    }
}