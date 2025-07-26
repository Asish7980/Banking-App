public class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 500.0;

    public SavingsAccount(String accountNumber, String holderName, double initialBalance) {
        super(accountNumber, holderName, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= MIN_BALANCE) {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount, "Withdrawn from savings"));
            System.out.println("Withdrawn from " + accountNumber + ": $" + amount);
        } else {
            System.out.println("Insufficient balance or below minimum required balance.");
        }
    }
}