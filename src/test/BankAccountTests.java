package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import bankapp.BankAccount;

class BankAccountTests {
    private BankAccount testAccount1;

    @BeforeEach
    void setUp() {
        testAccount1 = new BankAccount();
        testAccount1.setBalance(100); // Setting initial balance
    }

    @Test
    void testConstructor() {
        BankAccount testAccount = new BankAccount();
        assertEquals(0.0, testAccount.getBalance(), 0.01);
    }

    @Test
    void testSimpleWithdrawal() {
        testAccount1.withdraw(50);
        assertEquals(50.0, testAccount1.getBalance(), 0.01);
    }

    @Test
    void testWithdrawalWithInsufficientFunds() {
       Exception exception = assertThrows(IllegalArgumentException.class, () -> {
           testAccount1.withdraw(200); // Attempting to overdraw
       });
       assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    void testWithdrawalWithNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            testAccount1.withdraw(-50); // Negative withdrawal attempt
        });
        assertEquals("Withdrawal amount cannot be negative", exception.getMessage());
    }

    @Test
    void testWithdrawalZero() {
        testAccount1.withdraw(0);
        assertEquals(100.0, testAccount1.getBalance(), 0.01);
    }

    @Test
    void testWithdrawalEquivalent() {
        testAccount1.withdraw(100);
        assertEquals(0.0, testAccount1.getBalance(), 0.01);
    }

    @Test
    void testSimpleDeposit() {
        testAccount1.deposit(25);
        assertEquals(125.0, testAccount1.getBalance(), 0.01);
    }

    @Test
    void testNegativeDeposit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            testAccount1.deposit(-25);
        });
        assertEquals("Amount must be positive", exception.getMessage());
    }

    @Test
    void testMultipleDeposits() {
        testAccount1.deposit(50);
        testAccount1.deposit(100);
        assertEquals(250.0, testAccount1.getBalance(), 0.01);
    }

    @Test
    void testZeroDeposit() {
        testAccount1.deposit(0);
        assertEquals(100.0, testAccount1.getBalance(), 0.01);
    }

    @Test
    void testGetBalance() {
        assertEquals(100.0, testAccount1.getBalance(), 0.01);
    }

    @Test
    void testSetBalance() {
        testAccount1.setBalance(50);
        assertEquals(50.0, testAccount1.getBalance(), 0.01);
    }

    @Test
    void testsetCCInterestRate(){
        testAccount1.setBalance(500);
        testAccount1.setCCInterestRate();
        assertEquals(13, testAccount1.getCCInterestRate(),3);

        testAccount1.setBalance(300);
        testAccount1.setCCInterestRate();
        assertEquals(16, testAccount1.getCCInterestRate(),3);

        testAccount1.setBalance(100);
        testAccount1.setCCInterestRate();
        assertEquals(18, testAccount1.getCCInterestRate(),3);

    }
    @Test
    void testLowBalanceAlert_SetBelowThreshold() {
        testAccount1.setLowBalanceThreshold(50); 
        assertFalse(testAccount1.isLowBalanceAlert()); //not a low balance
      
        testAccount1.withdraw(60);
        assertTrue(testAccount1.isLowBalanceAlert()); //now is a low balance
    }
    @Test
    void testLowBalanceAlert_ResetAboveThreshold() {
        testAccount1.setLowBalanceThreshold(50); 
        assertFalse(testAccount1.isLowBalanceAlert()); 
        
        testAccount1.withdraw(60);
        assertTrue(testAccount1.isLowBalanceAlert()); 
        
        testAccount1.deposit(20);//add back
        assertFalse(testAccount1.isLowBalanceAlert()); //reset
    }
}
