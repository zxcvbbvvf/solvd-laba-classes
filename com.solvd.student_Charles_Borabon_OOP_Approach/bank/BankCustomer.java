package bank;

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
    public void display() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer Address: " + customerAddress);
        System.out.println("Customer Phone: " + customerPhone);
        System.out.println("Customer Email: " + customerEmail);
        System.out.println("Current Balance: " + balance);
    }
}
