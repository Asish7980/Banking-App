import java.time.LocalDateTime;

public class Transaction {
     private final String type;
    private final double amount;
    private final String description;
    private final LocalDateTime timestamp;
    public Transaction(String type, double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

     @Override
    public String toString() {
        return "[" + timestamp + "] " + type + ": $" + amount + " - " + description;
    }
}