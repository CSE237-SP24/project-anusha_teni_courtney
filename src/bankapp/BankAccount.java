package bankapp;

import java.util.*;

public class BankAccount {
    public double balance;
    private String userName; 
    private String password;
    private List<String> transactionHistory;
    private double interestSRate; // Annual interest rate
    private int interestCCRate;
    private char accountType;

    public BankAccount() {
        this.userName = "";
        this.password = "";
        this.balance = 0;
        this.accountType = 'C';
        this.transactionHistory = new ArrayList<>();
    }
    
    // Setters
    public void setUserName(String u) {
        this.userName = u; 
    }

    public void setPassword(String p) {
        this.password = p; 
    }

    public void setBalance(double b) {
        this.balance = b; 
    }

    // Randomly sets the Savings Account interest rate between 4% and 7%
    public void setRandomSavingsInterestRate() {
        Random rand = new Random();
        int max = 7, min = 4;
        this.interestSRate = rand.nextInt(max - min + 1) + min;
    }

    public void setAccountType(char x) {
        this.accountType = x; 
    }

    public void setCCInterestRate() {
        Random rand = new Random();
        int rate = 0; 
        if(account.balance > 500){
            rate = rand.nextInt(13 - 10 + 1) + 10;
        }
        else if(account.balance > 300){
            rate = rand.nextInt(16 - 13 + 1) + 13;
        }
        else{
            rate = rand.nextInt(18 - 16 + 1) + 16;
        }
        this.interestCCRate = rate;
    }
    // Getters
    public String getUserName() {
        return this.userName; 
    }

    public String getPassword() {
        return this.password; 
    }

    public double getBalance() {
        return this.balance;
    }

    public double getInterestSRate() {
        return this.interestSRate;
    }

    public int getCCInterestRate(){
        return this.interestCCRate;
    }
    public char getAccountType() {
        return this.accountType; 
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public double calculateAnnualInterest() {
        return balance * interestRate / 100;
    }

    public boolean validatePassword(String inputPassword) {
        return inputPassword.equals(this.password);
    }

    public void recordTransaction(String transactionDetail) {
        transactionHistory.add(transactionDetail);
    }

    public void deposit(double amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.balance += amount;
        recordTransaction("Deposited: $" + amount);
    }

    public void withdraw(double amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount cannot be negative");
        }
        if(balance >= amount) {
            balance -= amount;
            recordTransaction("Withdrew: $" + amount);
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }
}
