package bank;

public final class BankCustomer extends Bank implements BankCustomerMethods {
    private final int accountNumber;
    private double balance;
    private final String customerName;
    private final String customerAddress;
    private final String customerPhone;
    private final String customerEmail;
    static int customerCount = 0;

    public static int getCustomerCount() {
        return customerCount;
    }

    public BankCustomer(int accountNumber, String accountHolder, double balance, String customerName, String customerAddress, String customerPhone, String customerEmail) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        customerCount++;
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Ammount deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (this.balance - amount < 0) {
            System.out.println("Insufficient funds.");
        } else {
            this.balance -= amount;
            System.out.println("Ammount withdrawn: " + amount);
        }
    }

    @Override
    public int getAccountNum() {
        return this.accountNumber;
    }

    @Override
    public String getAccountName() {
        return this.customerName;
    }

    @Override
    public int getBalance() {
        return (int) this.balance;
    }

    @Override
    public String toString() {
        return "Customer ID" + this.getAccountNum() + "\n"
             + "Customer Name: " + this.getAccountName() + "\n"
             + "Customer Balance: " + this.getBalance() + "\n";
    }
}
