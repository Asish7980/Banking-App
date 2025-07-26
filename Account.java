import java.util.*;

public abstract class Account {
    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;
    protected List<Transaction> transactions = new ArrayList<>();

    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        transactions.add(new Transaction("Account Opened", initialBalance, "Initial deposit"));
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount, "Deposited to account"));
            System.out.println("Deposited to " + accountNumber + ": $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public abstract void withdraw(double amount);

    public void displayBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    public void displayAccountInfo() {
        System.out.println("\n--- Account Info ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: $" + balance);
    }

    public void showTransactionHistory() {
        System.out.println("\n--- Transaction History for " + accountNumber + " ---");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    public void addTransaction(String type, double amount, String description) {
        transactions.add(new Transaction(type, amount, description));
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }
}
