package org.CharlesBorabon.OOP.bank;

public class BankCustomer extends Bank {
    String customerName;
    String customerAddress;
    String customerPhone;
    String customerEmail;

    public BankCustomer(int accountNumber, String accountHolder, double balance, String customerName, String customerAddress, String customerPhone, String customerEmail) {
        super(accountNumber, accountHolder, balance);
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
    }

    @Override
    public String toString() {
        return "Customer Name: " + this.customerName + "\n"
             + "Customer Address: " + this.customerAddress + "\n"
             + "Customer Phone: " + this.customerPhone + "\n"
             + "Customer Email: " + this.customerEmail + "\n"
             + "Current Balance: " + this.balance + "\n";
    }
}
