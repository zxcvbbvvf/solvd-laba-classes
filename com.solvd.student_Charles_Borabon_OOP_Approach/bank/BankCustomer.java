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
    public String toString() {
        return "Customer Name: " + customerName + "\n"
             + "Customer Address: " + customerAddress + "\n"
             + "Customer Phone: " + customerPhone + "\n"
             + "Customer Email: " + customerEmail + "\n"
             + "Current Balance: " + balance + "\n";
    }
}
