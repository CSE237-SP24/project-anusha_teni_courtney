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
		m.processingUserSelection(50);
		
		BankAccount account = m.getAccount();
		assertEquals(50, account.getBalance(), 0.01);
	}
	@Test
    void testProcessingUserSelection_Deposit() {
        Menu m = new Menu();

        m.processingUserSelection(100);
		BankAccount account = m.getAccount();
   
        assertEquals(100, account.getBalance(), 0.01);

        //see if transaction history shows the deposit
        assertEquals(1, m.getTransactionHistory().size()); //only 1 transaction --> sz=1
        Transaction transaction = m.getTransactionHistory().get(0); //get 1st in list so from 0
        assertEquals("Deposit", transaction.getType()); //is deposit 
        assertEquals(100, transaction.getAmount(), 0.01); //confirming amt above
    }

	@Test
    void testDisplayTransactionHistory() {
        Menu m = new Menu();
        m.processingUserSelection(50); // deposit 
        m.processingUserSelection(-30); // withdrawal --> merge

        String expectedOutput = "Transaction History:\n" +
                "Deposit of $50.00 on " + LocalDate.now() + "\n" +
                "Withdrawal of $30.00 on " + LocalDate.now() + "\n";

        // for the transaction history string
        String actualOutput = m.getTransactionHistoryAsString().trim(); //trim for whitespace/leading chars

        assertEquals(expectedOutput, actualOutput);
    }

}
