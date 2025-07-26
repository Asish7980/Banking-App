import java.util.*;

public class BankSystem {
    private final Map<String, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void transferFunds(String fromAcc, String toAcc, double amount) {
        Account sender = accounts.get(fromAcc);
        Account receiver = accounts.get(toAcc);

        if (sender == null || receiver == null) {
            System.out.println("One or both account numbers are invalid.");
            return;
        }

        if (amount <= 0) {
            System.out.println("Invalid transfer amount.");
            return;
        }

        if (sender.getBalance() < amount) {
            System.out.println("Insufficient funds in sender's account.");
            return;
        }

        sender.withdraw(amount);
        receiver.deposit(amount);
        sender.addTransaction("Transfer", amount, "Sent to " + toAcc);
        receiver.addTransaction("Transfer", amount, "Received from " + fromAcc);
        System.out.println("Transfer successful.");
    }
}