package bankapp;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;


public class Menu {

	private Scanner in;
	private BankAccount account;
        private String userName;
        private String password; 
	private char accountType;
	private double interestRate; // Annual interest rate
	private List<Transaction> transactionHistory; 
   
	
	//not tested
	public static void main(String[] args) {
	Menu mainMenu = new Menu();

	//username 
	mainMenu.displayAccountCreationPrompt(); 
	String userName = mainMenu.getValidUserName();

	//password
	mainMenu.displayPasswordCreationPrompt();
	String password = mainMenu.getValidPassword();

	//savings vs checking
	mainMenu.displayAccountTypePrompt();
	char accountType = mainMenu.getValidAccountType();
	Double rate = mainMenu.processInterestRate();

	mainMenu.processingAccountDetails(userName, password, accountType, rate);

	
	//deposit 
	mainMenu.depositPrompt();
	double amountD = mainMenu.getValidDepositInput();
	mainMenu.processingDepositSelection(amountD);

	//withdraw
	mainMenu.withdrawPrompt();
	double amountW = mainMenu.getValidWithdrawalInput();
	mainMenu.processingWithdrawalSelection(amountW);
	mainMenu.displayTransactionHistory();
		
	}
	
	//Constructor
	public Menu() {
		this.in = new Scanner(System.in);
		this.account = new BankAccount();
		this.transactionHistory = new ArrayList<Transaction>();

	        account.setUserName(userName);
	        account.setPassword(password);
		account.setAccountType(accountType);
	}

	//account creation section 
	public void displayAccountCreationPrompt() {
		System.out.println("Welcome to A-Bank. To create an account enter your first and last name: ");
	}
	public void displayPasswordCreationPrompt(){
        System.out.println("Please select a password with at least 8 characters.");
    }
	public void displayAccountTypePrompt() {
		System.out.println("Please input S for a Savings, and C for a checking account. Savings Account generate between 4 and 7% interest, while Checking Accounts generate 0 ");
	}
	public String getValidUserName() {
		String userName = in.nextLine();
		while(userName.length() < 2 ) {
			System.out.println("Make sure to enter a valid name. ");
			System.out.println("Enter your first and last name: ");
			userName = in.nextLine();
		}
		return userName;
	}
	
    public String getValidPassword(){
        String password = in.nextLine();
		while(password.length() < 8 ) {
			System.out.println("Make sure to enter a password with at least 8 characters.");
			password = in.nextLine();
		}
		return password;
    }
	public char getValidAccountType(){
        char x = in.next().charAt(0);
		//may want to update differentiation of rates later
		return x;
    }
	public double processInterestRate(char accountType){
		if(accountType == 'S'){
			account.setInterestRate();
			return account.getInterestRate();
		}
		return 0.0;
	}

	//Account information
	public void processingAccountDetails(String u, String p, char t, double i) {
		System.out.println("Your account is initialized with name: " 
        + u + " password: " + p + " and type " + t + " interest rate " + i);
	}	

	
	//account deposit section
	public void depositPrompt() {
		System.out.println("How much money do you want to deposit?");
	}
	
	//Code that gets user input
	public double getValidDepositInput() {
		double amount = in.nextDouble();
		while(amount < 0) {
			System.out.println("Invalid value!");
			System.out.println("How much money do you want to deposit?");
			amount = in.nextDouble();
		}
		return amount;
	}
	
	//-tested
	public void processingDepositSelection(double amount) {
		account.deposit(amount);
		transactionHistory.add(new Transaction("Deposit", amount));
		System.out.println("Your balance is now: " + account.getBalance());
	}

	//Withdrawls
	public void processingWithdrawalSelection(double amount) {
		account.withdraw(amount);
		transactionHistory.add(new Transaction("Withdrawl", amount));
		System.out.println("Your balance is now: " + account.getBalance());
	}

	public void withdrawPrompt() {
		System.out.println("How much money do you want to withdraw?");
	}
	
	public double getValidWithdrawalInput() {
		double amount = in.nextDouble();
		while(amount < 0) {
			System.out.println("How much money do you want to withdraw?");
			amount = in.nextDouble();
		}
		return amount;
	}

	public void transferTo(BankAccount targetAccount, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive.");
        }
        
        if (this.balance >= amount) 
        {
            this.balance -= amount; // Deduct the transfer amount from current account
            targetAccount.balance += amount; // Add the transfer amount to the target account
  
            this.recordTransaction("Transferred out: $" + amount);
            targetAccount.recordTransaction("Transferred in: $" + amount);
        } 
        else {
            throw new IllegalArgumentException("Insufficient funds for transfer.");
        }
    }

	public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction.getType() + " of $" + transaction.getAmount() + " on " + transaction.getTimestamp());
        }
    }

	public String getTransactionHistoryAsString() { //for testing
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction History:\n");
        for (Transaction transaction : transactionHistory) {
            sb.append(transaction.getType())
              .append(" of $")
              .append(transaction.getAmount())
              .append(" on ")
              .append(LocalDateTime.now())
              .append("\n");
        }
        return sb.toString();
    }
	public BankAccount getAccount() {
		return account;
	}
}
