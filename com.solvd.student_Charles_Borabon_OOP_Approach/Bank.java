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
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void display() {
        System.out.println("This is the main bank class. Not much to see here.");
    }
}
