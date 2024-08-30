package org.CharlesBorabon.OOP_Part2.bank;

public abstract class Bank {
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void transfer(double amount, BankCustomer toAccount);
}
