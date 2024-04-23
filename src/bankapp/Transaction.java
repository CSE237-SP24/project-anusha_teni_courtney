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

    //    public void transferTo(BankAccount targetAccount, double amount) {
//        if (amount <= 0) {
//            throw new IllegalArgumentException("Transfer amount must be positive.");
//        }
//
//        if (this.balance >= amount) 
//        {
//            this.balance -= amount; // Deduct the transfer amount from current account
//            targetAccount.balance += amount; // Add the transfer amount to the target account
//
//            this.recordTransaction("Transferred out: $" + amount);
//            targetAccount.recordTransaction("Transferred in: $" + amount);
//        } 
//        else {
//            throw new IllegalArgumentException("Insufficient funds for transfer.");
//        }
//    }
}
