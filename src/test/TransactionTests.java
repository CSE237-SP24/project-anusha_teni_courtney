package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import bankapp.BankAccount;
import bankapp.Menu;
import bankapp.Transaction;

class TransactionTests {
    
    @Test
    void testTConstructor() {
        LocalDateTime beforeCreation = LocalDateTime.now();
        String type = "Deposit";
        double amount = 100.0;

        Transaction transaction = new Transaction(type, amount);
        LocalDateTime afterCreation = LocalDateTime.now();

        assertEquals(type, transaction.getType());
        assertEquals(amount, transaction.getAmount(), 0.01); 
        assertFalse(transaction.getTimestamp().isBefore(beforeCreation));
        assertFalse(transaction.getTimestamp().isAfter(afterCreation));
    }

    @Test
    void testGetType() {
        String type = "Withdraw";
        double amount = 50.0;
        Transaction transaction = new Transaction(type, amount);

        assertEquals(type, transaction.getType());
    }

    @Test
    void testGetAmount() {
        String type = "Deposit";
        double amount = 50.0;
        Transaction transaction = new Transaction(type, amount);

        assertEquals(amount, transaction.getAmount(), 0.01);
    }

    @Test
    void testGetTimestamp() {
        LocalDateTime beforeCreation = LocalDateTime.now();
        Transaction transaction = new Transaction("Deposit", 50.0);
        LocalDateTime afterCreation = LocalDateTime.now();

        assertFalse(transaction.getTimestamp().isBefore(beforeCreation));
        assertFalse(transaction.getTimestamp().isAfter(afterCreation));
    }
}