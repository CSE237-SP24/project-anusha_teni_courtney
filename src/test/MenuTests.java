package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bankapp.BankAccount;
import bankapp.Menu;

class MenuTests {

	@Test
	void testUserDeposit() {
        Menu m = new Menu();
        //user has provided value input of 50
        m.processingDepositSelection(50);
        
        BankAccount account = m.getAccount();
        assertEquals(50, account.getBalance(), 0.01);
    }
    
    @Test
    void testProcessingUserSelection_Deposit() {
        Menu m = new Menu();
        
        //user has provided value input of 100
        m.processingDepositSelection(100);
        BankAccount account = m.getAccount();
        
        assertEquals(100, account.getBalance(), 0.01);
        
        //see if transaction history shows the deposit
        assertEquals(1, m.getTransactionHistory().size()); //only 1 transaction --> sz=1
        var transaction = m.getTransactionHistory().get(0); //get 1st in list so from 0
        assertEquals("Deposit", transaction.getType()); //is deposit 
        assertEquals(100, transaction.getAmount(), 0.01); //confirming amt above
    }
    
    @Test
    void testProcessingWithdrawal() {
        Menu m = new Menu();
        m.processingDepositSelection(100);
        m.processingWithdrawalSelection(50); // Withdraw 50 from account
        
        BankAccount account = m.getAccount();
        assertEquals(50, account.getBalance(), 0.01, "Balance after withdrawal should be 50");
        
        // Check that the withdrawal is recorded in the transaction history
        assertEquals(2, m.getTransactionHistory().size(), "There should be two transactions in history");
        Transaction lastTransaction = m.getTransactionHistory().get(1);
        assertEquals("Withdrawl", lastTransaction.getType(), "The last transaction should be a withdrawal");
        assertEquals(50, lastTransaction.getAmount(), 0.01, "The amount of the last transaction should be 50");
    }

    @Test
    void testTransferFunctionality() {
        double transferAmount = 50.0;

        sourceAccount.transferTo(targetAccount, transferAmount);

        // Check if the transfer was successful
        assertEquals(150.0, sourceAccount.getBalance(), "Source balance should be reduced by the transfer amount.");
        assertEquals(150.0, targetAccount.getBalance(), "Target balance should be increased by the transfer amount.");

        // Check if transactions are recorded correctly
        assertFalse(sourceAccount.getTransactionHistory().isEmpty(), "Source should have recorded the transaction.");
        assertFalse(targetAccount.getTransactionHistory().isEmpty(), "Target should have recorded the transaction.");

        // Check the transaction details
        String sourceTransactionDetail = sourceAccount.getTransactionHistory().get(sourceAccount.getTransactionHistory().size() - 1);
        String targetTransactionDetail = targetAccount.getTransactionHistory().get(targetAccount.getTransactionHistory().size() - 1);

        assertTrue(sourceTransactionDetail.contains("Transferred out: $" + transferAmount), "Source transaction details should indicate money was transferred out.");
        assertTrue(targetTransactionDetail.contains("Transferred in: $" + transferAmount), "Target transaction details should indicate money was transferred in.");
    }

	@Test
    void testDisplayTransactionHistory() {
        Menu m = new Menu();
        //user has decided to deposit 50
        m.processingDepositSelection(50);
        //user has decided to withdraw 30
        m.processingWithdrawalSelection(30);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String todayDate = LocalDateTime.now().format(formatter);
        
        String expectedOutput = "Transaction History:\n" +
                                "Deposit of $50.0 on " + todayDate + "\n" +
                                "Withdrawal of $30.0 on " + todayDate;
        
        // for transaction history
        String actualOutput = m.getTransactionHistoryAsString().trim();
        
        assertTrue(actualOutput.contains("Deposit of $50.0"));
        assertTrue(actualOutput.contains("Withdrawal of $30.0"));
    }

}
