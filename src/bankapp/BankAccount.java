package bankapp;

import java.util.*;

public class BankAccount {
	
    public double balance;
    private String userName; 
    private String password;
    private List<String> transactionHistory;
    private double interestRate; // Annual interest rate
    private char accountType;
	
	//Constructors - not tested
	public BankAccount() {
        this.userName = "";
        this.password = "";
	    this.balance = 0;
        this.accountType = 'C'; 
	}
	
	public void setUserName(String u){
        this.userName = u; 
    }
    public void setPassword(String p){
        this.password = p; 
    }
    public void setBalance(int b){
        this.balance = b; 
    }
    public void setInterestRate(){
        Random rand = new Random();
        int max=7,min=4;
        this.interestRate = rand.nextInt(max - min + 1) + min;
    }
    public void setAccountType(char x){
        this.accountType = x; 
    }
    public String getUserName(){
        return this.userName; 
    }
    public String getPassword(){
        return this.password; 
    }
    public double getBalance() {
	    return this.balance;
    }
    public double getInterestRate() {
        return this.interestRate;
    }
    public char getAccountType(){
        return this.accountType; 
    }
    public List<String> getTransactionHistory(){
        return transactionHistory;
    }

    //functions
    public double calculateAnnualInterest() {
        return balance * interestRate / 100;
    }
    public boolean validatePassword(String inputPassword){
        return inputPassword.equals(this.password);
    }
    public void recordTransaction(String transactionDetail){
        transactionHistory.add(transactionDetail);
    }

    
    public void deposit(double amount) {
        while(amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.balance += amount;
	}
    public void withdraw(double amount){
        while(amount < 0){
            throw new IllegalArgumentException("Withdrawal amount cannot be negative");
        }
        if(balance >=amount){
            balance -= amount; 
        }
        else {
            throw new IllegalArgumentException("Insufficient funds");
        }

    }
    


    
}
