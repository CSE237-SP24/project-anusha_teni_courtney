package bankapp;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        double rate = mainMenu.processInterestSRate(accountType);

        mainMenu.processingAccountDetails(userName, password, accountType, rate);

        // Deposit
        mainMenu.depositPrompt();
        double amountD = mainMenu.getValidDepositInput();
        mainMenu.processingDepositSelection(amountD);

        // Withdraw
        mainMenu.withdrawPrompt();
        double amountW = mainMenu.getValidWithdrawalInput();
        mainMenu.processingWithdrawalSelection(amountW);
        
     // Account updates
        mainMenu.promptForAccountUpdate();

        //credit card
        mainMenu.creditCardPrompt();
        mainMenu.getValidCCInput();
        //mainMenu.processingCC();

        mainMenu.displayTransactionHistory();

        //low balance threshold
        mainMenu.setLowBalanceThreshold();
        
        // Prompt for transferring funds
        mainMenu.promptForTransfer();
        

        scanner.close();
    }

    public Menu(Scanner scanner, Supplier<LocalDateTime> dateTimeSupplier) {
        this.in = scanner;
        this.dateTimeSupplier = dateTimeSupplier;
        this.account = new BankAccount();
        this.transactionHistory = new ArrayList<Transaction>();
    }

    public void displayAccountCreationPrompt() {
        System.out.println("Welcome to Penguin Bank. To create an account enter your first and last name: ");
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
        char aType = in.nextLine().charAt(0);
        while (aType != 'C' && aType != 'S') {
            System.out.println("Make sure to enter a C or S");
            aType = in.nextLine().charAt(0);
            System.out.println(aType + " !");

        }
        return aType;
    }

    public double processInterestSRate(char accountType) {
        if (accountType == 'S') {
            account.setRandomSavingsInterestRate();
            return account.getInterestSRate();
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
    
    public void promptForAccountUpdate() {
        System.out.println("Would you like to update your account details? (yes/no)");
        String response = in.nextLine().trim().toLowerCase();

        if (response.equals("yes")) {
            updateAccountDetails();
        } else {
            System.out.println("No updates made.");
        }
    }

    private void updateAccountDetails() {
        System.out.println("Select option to update: 1 for Username, 2 for Password");
        int choice = in.nextInt();
        in.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter new username:");
                String newUsername = in.nextLine();
                account.setUserName(newUsername);
                System.out.println("Username updated successfully to " + newUsername);
                break;
            case 2:
                System.out.println("Enter new password:");
                String newPassword = in.nextLine();
                account.setPassword(newPassword);
                System.out.println("Password updated successfully.");
                break;
            default:
                System.out.println("Invalid option selected.");
                break;
        }
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
    public void setLowBalanceThreshold() {
        System.out.println("Enter the low balance threshold for the account:");
        double threshold = in.nextDouble();
        account.setLowBalanceThreshold(threshold);
        System.out.println("Low balance threshold set successfully.");
    }
    //credit card
    public void creditCardPrompt() {
        System.out.println("Would you like to open a Credit Card? (yes/no)");
    }

    public void getValidCCInput() {
        char yesno = in.nextLine().charAt(0);
        if(yesno == 'Y'){
            System.out.println("Your monthly interest rate will range from 10 to 18%, depending on your balance.");
            System.out.println("Your credit limit will be 80% of your account balance.");
            processingCC();
        }
        
    }

    public void processingCC(){
        System.out.println("Calculating Interest Rate...");
        account.setCCInterestRate();
        int r = account.getCCInterestRate();
        System.out.println("Rate is " + r + "%.");
        double availCC = 0.8 * account.getBalance(); 
        System.out.println("Monthly Credit Limit is $" + availCC);
    }

    public void promptForTransfer() {
        System.out.println("Would you like to transfer money to another account? (yes/no)");
        
        if (in.hasNextLine()) {
            in.nextLine();
        }

        String response = in.nextLine().trim().toLowerCase();
        System.out.println("You entered: " + response);

        if (response.equals("yes")) {
            System.out.print("Enter the amount to transfer: ");
            while (!in.hasNextDouble()) { // Ensure the input is a double
                System.out.println("Please enter a valid amount.");
                in.next(); 
            }
            double amount = in.nextDouble();
            in.nextLine();

            System.out.print("Enter the username of the account you want to transfer to: ");
            String targetUserName = in.nextLine().trim();
            System.out.println("Transferring to: " + targetUserName);

            Random rand = new Random();
            int result = rand.nextInt(5) + 1; // Generates a number between 1 and 5

            if (result <= 3) {
                // Simulate success for 1, 2, 3
                if (this.account.getBalance() >= amount) {
                    this.account.setBalance(this.account.getBalance() - amount); // Deduct amount from this account
                    
                    BankAccount targetAccount = new BankAccount();
                    targetAccount.setBalance(targetAccount.getBalance() + amount); // Add amount to target account
                    System.out.println("Successfully transferred $" + amount + " to " + targetUserName + ".");
                    transactionHistory.add(new Transaction("Transfer", amount, dateTimeSupplier.get()));
                } else {
                    System.out.println("Transfer failed: Insufficient funds.");
                }
            } else { 
                // Simulate failure for 4, 5
                System.out.println("Transfer failed: Incorrect account username provided.");
            }
        } 
        else {
            System.out.println("Transfer cancelled.");
        }
    }


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
