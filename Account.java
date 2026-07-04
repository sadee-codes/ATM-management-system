import java.util.ArrayList;

public class Account {

    private String accountNumber;
    private String customerName;
    private String pin;
    private double balance;
    private ArrayList<Transaction> transactions;

    public Account(String accountNumber, String customerName, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.pin = pin;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
            System.out.println("Deposit Successful!");
        } else {
            System.out.println("Invalid Amount!");
        }
    }

    public boolean withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid Amount!");
            return false;
        }

        if (amount > balance) {
            System.out.println("Insufficient Balance!");
            return false;
        }

        balance -= amount;
        transactions.add(new Transaction("Withdraw", amount));
        System.out.println("Withdrawal Successful!");

        return true;
    }

    public void changePin(String newPin) {
        pin = newPin;
        System.out.println("PIN Changed Successfully!");
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void displayAccountDetails() {

        System.out.println("\n===== Account Details =====");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Customer Name  : " + customerName);
        System.out.println("Balance        : Rs." + balance);
    }

    public void displayMiniStatement() {

        System.out.println("\n===== Mini Statement =====");

        if (transactions.isEmpty()) {
            System.out.println("No Transactions Found.");
            return;
        }

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }

        System.out.println("--------------------------");
        System.out.println("Current Balance : Rs." + balance);
    }
}