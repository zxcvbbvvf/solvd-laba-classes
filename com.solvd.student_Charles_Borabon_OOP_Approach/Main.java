import bank.Bank;
import bank.BankCustomer;

public class Main {
    public static void main(String[] args) {
        // bank package test
        Bank bank = new Bank(123456, "John Doe", 1000.00);
        bank.display();
        bank.deposit(500.00);
        bank.display();
        bank.withdraw(200.00);
        bank.display();
        System.out.println();

        BankCustomer customer = new BankCustomer(123456, "John Doe", 1000.00, "Jane Doe", "1234 Elm St", "555-555-5555", "jane@email.com");
        customer.display();
        customer.deposit(500.00);
        customer.display();
        customer.withdraw(200.00);
        customer.display();
    }
}