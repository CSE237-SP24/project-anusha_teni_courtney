package bankapp;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public class Menu {

    private Scanner in;
    private BankAccount account;
    private List<Transaction> transactionHistory; 
    private Supplier<LocalDateTime> dateTimeSupplier;
	private double balance;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu mainMenu = new Menu(scanner, LocalDateTime::now);

        // Account
        mainMenu.displayAccountCreationPrompt();
        String userName = mainMenu.getValidUserName();
        mainMenu.displayPasswordCreationPrompt();
        String password = mainMenu.getValidPassword();
        mainMenu.displayAccountTypePrompt();
        char accountType = mainMenu.getValidAccountType();
        double rate = mainMenu.processInterestRate(accountType);

        mainMenu.processingAccountDetails(userName, password, accountType, rate);

        // Deposit
        mainMenu.depositPrompt();
        double amountD = mainMenu.getValidDepositInput();
        mainMenu.processingDepositSelection(amountD);

        // Withdraw
        mainMenu.withdrawPrompt();
        double amountW = mainMenu.getValidWithdrawalInput();
        mainMenu.processingWithdrawalSelection(amountW);

        mainMenu.displayTransactionHistory();

        scanner.close();
    }

    public Menu(Scanner scanner, Supplier<LocalDateTime> dateTimeSupplier) {
        this.in = scanner;
        this.dateTimeSupplier = dateTimeSupplier;
        this.account = new BankAccount();
        this.transactionHistory = new ArrayList<>();
    }

    public void displayAccountCreationPrompt() {
        System.out.println("Welcome to our Bank. To create an account enter your first and last name: ");
    }

    public void displayPasswordCreationPrompt() {
        System.out.println("Please select a password with at least 8 characters.");
    }

    public void displayAccountTypePrompt() {
        System.out.println("Please input S for a Savings, and C for a checking account. Savings Accounts generate between 4 and 7% interest, while Checking Accounts generate 0 ");
    }

    public String getValidUserName() {
        String userName = in.nextLine();
        while (userName.length() < 2) {
            System.out.println("Make sure to enter a valid name.");
            userName = in.nextLine();
        }
        return userName;
    }

    public String getValidPassword() {
        String password = in.nextLine();
        while (password.length() < 8) {
            System.out.println("Make sure to enter a password with at least 8 characters.");
            password = in.nextLine();
        }
        return password;
    }

    public char getValidAccountType() {
        char x = in.nextLine().charAt(0);
        return x;
    }

    public double processInterestRate(char accountType) {
        if (accountType == 'S') {
            account.setRandomInterestRate();
            return account.getInterestRate();
        }
        return 0.0;
    }

    public void processingAccountDetails(String u, String p, char t, double i) {
        account.setUserName(u);
        account.setPassword(p);
        account.setAccountType(t);
        System.out.println("Your account is initialized with name: " + u + " password: " + p + " and type " + t + " interest rate " + i);
    }

    public void depositPrompt() {
        System.out.println("How much money do you want to deposit?");
    }

    public double getValidDepositInput() {
        double amount = in.nextDouble();
        in.nextLine();
        while (amount < 0) {
            System.out.println("Invalid value!");
            amount = in.nextDouble();
            in.nextLine();
        }
        return amount;
    }

    public void processingDepositSelection(double amount) {
        account.deposit(amount);
        transactionHistory.add(new Transaction("Deposit", amount, dateTimeSupplier.get()));
        System.out.println("Your balance is now: " + account.getBalance());
    }

    public void withdrawPrompt() {
        System.out.println("How much money do you want to withdraw?");
    }

    public double getValidWithdrawalInput() {
        double amount = in.nextDouble();
        in.nextLine();
        while (amount < 0) {
            System.out.println("Invalid value!");
            amount = in.nextDouble();
            in.nextLine();
        }
        return amount;
    }

    public void processingWithdrawalSelection(double amount) {
        account.withdraw(amount);
        transactionHistory.add(new Transaction("Withdrawal", amount, dateTimeSupplier.get()));
        System.out.println("Your balance is now: " + account.getBalance());
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction.getType() + " of $" + transaction.getAmount() + " on " + transaction.getTimestamp());
        }
    }

    public BankAccount getAccount() {
        return account;
    }
    
    public List<Transaction> getTransactionHistory() {
        return this.transactionHistory;
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

    public String getTransactionHistoryAsString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction History:\n");
        for (Transaction transaction : this.transactionHistory) {
            sb.append(transaction.getType())
              .append(" of $")
              .append(String.format("%.2f", transaction.getAmount()))
              .append(" on ")
              .append(transaction.getTimestamp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
              .append("\n");
        }
        return sb.toString().trim();
    }
}
