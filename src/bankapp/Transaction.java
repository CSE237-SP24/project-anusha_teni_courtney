package bankapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String type;
    private double amount;
    private LocalDateTime timestamp;

    // Constructors
    public Transaction(String type, double amount) {
        this.type = type; // "Deposit" or "Withdraw"
        this.amount = amount;
        this.timestamp = LocalDateTime.now(); // Set to current time
    }

    public Transaction(String type, double amount, LocalDateTime timestamp) {
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}