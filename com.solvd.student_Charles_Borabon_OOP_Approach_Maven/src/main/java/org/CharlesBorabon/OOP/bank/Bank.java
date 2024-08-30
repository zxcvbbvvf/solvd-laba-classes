package org.CharlesBorabon.OOP.bank;

public class Bank {
    int accountNumber;
    String accountHolder;
    double balance;

    public Bank(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "This is the main bank class. Not much to see here.";
    }
}
