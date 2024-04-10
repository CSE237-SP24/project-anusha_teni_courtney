package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bankapp.BankAccount;

class BankAccountTests {
    private BankAccount testAccount1; // Setup Objects

	@BeforeEach //for pre init objs
    void ogBank() {
        testAccount1 = new BankAccount(100);//starting w 100 here
    }
    //construct tests
	@Test
    void testConstructor() {
        BankAccount testAccount = new BankAccount();
        assertEquals(0.0, testAccount.getBalance(), 0.01);
    }

    @Test
    void testConstructorFilled() {
        BankAccount testAccount = new BankAccount(100);
        assertEquals(100.0, testAccount.getBalance(), 0.01);
    }
    @Test
    void testSimpleWithdrawal() {
		//2. Call the method being tested
        testAccount1.withdraw(50);
		//3. Use assertions to verify results
        assertEquals(50.0, testAccount1.getBalance(), 0.01);
    }
    @Test
    void testWithdrawalWithInsufficientFunds() {
       try {
            testAccount1.withdraw(200); //overdraw
            fail("Expected IllegalArgumentException with message 'Not enough money' was not thrown");
        } catch (IllegalArgumentException e) {
			  assertEquals("Not enough money", e.getMessage()); //if caught
        }
    }
	@Test
    void testWithdrawalWithNegativeAmount() {
        try {
            testAccount1.withdraw(-50); // try to withdraw a negative amount
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Withdrawal amount cannot be negative", e.getMessage());
        }
    }
    @Test
    void testWithdrawalZero() {
        try {
            testAccount1.withdraw(0); // withdraw nothing
            assertEquals(100.0, testAccount1.getBalance(), 0.01); //no change
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException was thrown");
        }
    }

    @Test
    void testWithdrawalEquivalent() {
        try {
            testAccount1.withdraw(100); // withdraw equal amt
            assertEquals(0.0, testAccount1.getBalance(), 0.01); // balance should be zero
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException was thrown");
        }
    //deposit tests
	@Test
	void testSimpleDeposit() {
		//1. Setup Objects
		
		BankAccount testAccount = new BankAccount();
		
		//2. Call the method being tested
		testAccount.deposit(25);
		
		//3. Use assertions to verify results
		assertEquals(25.0, testAccount.getBalance(), 0.01);	
	}
	
	@Test
	void testNegativeDeposit() {
    // 1. Setup Objects    
    BankAccount testAccount = new BankAccount();
    
    // 2. Call the method being tested
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        testAccount.deposit(-25);
    });
    
    // 3. Use assertions to verify results
    String expectedMessage = "Amount must be positive";
    String actualMessage = exception.getMessage();
    
    assertTrue(actualMessage.contains(expectedMessage), "Exception message should be about positive amount requirement");
}

	@Test
    void testMultipleDeposits() {
        BankAccount testAccount = new BankAccount();
        testAccount.deposit(50);
        testAccount.deposit(100);
        assertEquals(150.0, testAccount.getBalance(), 0.01);
    }
	@Test
    void testZeroDeposit() {
        BankAccount testAccount = new BankAccount();
        testAccount.deposit(0);
        assertEquals(0.0, testAccount.getBalance(), 0.01);
    }
    //getters and setters tests
	@Test
    void testGetBalance() {
        BankAccount testAccount = new BankAccount(50); //alr there
        assertEquals(50.0, testAccount.getBalance(), 0.01);
    }

    @Test
    void testSetBalance() {
        BankAccount testAccount = new BankAccount();
        testAccount.setBalance(50); //setting
        assertEquals(50.0, testAccount.getBalance(), 0.01);
    }

}
