public class CurrentAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 1000.0;

    public CurrentAccount(String accountNumber, String holderName, double initialBalance) {
        super(accountNumber, holderName, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= -OVERDRAFT_LIMIT) {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount, "Withdrawn from current"));
            System.out.println("Withdrawn from " + accountNumber + ": $" + amount);
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }
}