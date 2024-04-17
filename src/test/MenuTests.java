package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.function.Supplier;

import bankapp.Menu;
import bankapp.Transaction;

class MenuTests {
    private Menu menu;
    private LocalDateTime testDateTime;

    @BeforeEach
    void setUp() {
        // User input
        String inputData = "John Doe\nstrongpassword123\nS\n50\n30\n";
        Scanner scanner = new Scanner(inputData);
        testDateTime = LocalDateTime.of(2022, 4, 8, 12, 0);
        Supplier<LocalDateTime> dateTimeSupplier = () -> testDateTime;

        menu = new Menu(scanner, dateTimeSupplier);
    }

    @Test
    void testUserDeposit() {
        menu.processingDepositSelection(50);
        assertEquals(50, menu.getAccount().getBalance(), 0.01);
    }
    
    @Test
    void testProcessingUserSelection_Deposit() {
        menu.processingDepositSelection(100);
        assertEquals(100, menu.getAccount().getBalance(), 0.01);
        assertEquals(1, menu.getTransactionHistory().size());
        Transaction transaction = menu.getTransactionHistory().get(0);
        assertEquals("Deposit", transaction.getType());
        assertEquals(100, transaction.getAmount(), 0.01);
        assertEquals(testDateTime, transaction.getTimestamp());
    }
    
    @Test
    void testProcessingWithdrawal() {
        menu.processingDepositSelection(100); // Initial deposit for withdrawal
        menu.processingWithdrawalSelection(50);
        assertEquals(50, menu.getAccount().getBalance(), 0.01);
        assertEquals(2, menu.getTransactionHistory().size());
        Transaction lastTransaction = menu.getTransactionHistory().get(1);
        assertEquals("Withdrawal", lastTransaction.getType());
        assertEquals(50, lastTransaction.getAmount(), 0.01);
        assertEquals(testDateTime, lastTransaction.getTimestamp());
    }

//    @Test
//    void testTransferFunctionality() {
//        double transferAmount = 50.0;
//
//        sourceAccount.transferTo(targetAccount, transferAmount);
//
//        // Check if the transfer was successful
//        assertEquals(150.0, sourceAccount.getBalance(), "Source balance should be reduced by the transfer amount.");
//        assertEquals(150.0, targetAccount.getBalance(), "Target balance should be increased by the transfer amount.");
//
//        // Check if transactions are recorded correctly
//        assertFalse(sourceAccount.getTransactionHistory().isEmpty(), "Source should have recorded the transaction.");
//        assertFalse(targetAccount.getTransactionHistory().isEmpty(), "Target should have recorded the transaction.");
//
//        // Check the transaction details
//        String sourceTransactionDetail = sourceAccount.getTransactionHistory().get(sourceAccount.getTransactionHistory().size() - 1);
//        String targetTransactionDetail = targetAccount.getTransactionHistory().get(targetAccount.getTransactionHistory().size() - 1);
//
//        assertTrue(sourceTransactionDetail.contains("Transferred out: $" + transferAmount), "Source transaction details should indicate money was transferred out.");
//        assertTrue(targetTransactionDetail.contains("Transferred in: $" + transferAmount), "Target transaction details should indicate money was transferred in.");
//    }

    @Test
    void testDisplayTransactionHistory() {
        menu.processingDepositSelection(50);
        menu.processingWithdrawalSelection(30);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = testDateTime.format(formatter);
        
        String expectedOutput = "Transaction History:\n"
            + "Deposit of $50.00 on " + formattedDate + "\n"
            + "Withdrawal of $30.00 on " + formattedDate;
        
        String actualOutput = menu.getTransactionHistoryAsString();
        
        assertEquals(expectedOutput, actualOutput);
    }
}
