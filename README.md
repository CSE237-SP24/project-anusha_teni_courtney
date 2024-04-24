# Bank Account Management System
## Iteration 3

BankApp is an application designed to simulate various banking operations such as account creation, fund transfers, deposit and withdrawal transactions, and credit card management. This application provides a user-friendly interface via the console, allowing users to interact with their virtual bank account.

## Features

- **Account Creation**: Users can create a bank account by providing their name, password, and selecting an account type (Checking or Savings).
- **Deposit and Withdrawal**: Users can deposit and withdraw funds. Each transaction is recorded with its details.
- **Fund Transfers**: Users can transfer funds between accounts. The application includes a simulation of transfer success based on random outcomes.
- **Credit Card Management**: Users can request a credit card which calculates a monthly interest rate and credit limit based on the account balance.
- **View Transaction History**: Users can view a detailed list of all transactions, including deposits, withdrawals, and transfers.
- **Set Low Balance Alert**: Users can set a low balance threshold that triggers an alert when the account balance goes below a specified amount.
- **Account Updates**: Users can update their account details such as username and password.

## Code Structure
- `BankAccount.java`: Defines the bank account model, including balance, account type, interest rate, and transaction history.
- `Menu.java`: Handles user interactions, allowing them to create accounts, deposit and withdraw funds, and view transaction history.
- `Transaction.java`: Represents a transaction with a type (deposit, withdrawal, transfer), amount, and timestamp

## Test Functionality
- `BankAccountTests.java`: Tests the functionality of the `BankAccount` class, including constructors, deposits, and withdrawals.
- `MenuTests.java`: Tests the `Menu` class's ability to process deposits, withdrawals, and display transaction history.
- `TransactionTests.java`: Verifies the creation of transactions and their properties.

## Compilation and Execution Instructions

Before running the application, ensure Java is installed on your system. You can verify this by running `java -version` in your command line interface.

### Steps to Compile and Run the Application:

1. **Clone the Repository**:
   If you have Git installed, you can clone the repository using:
   ```sh
   git clone [repository-url]
   cd [repository-name]
   ```

2. **Compile the Java Files**:
   Navigate to the source directory (assuming it is the root), and compile the Java files using:
   ```sh
   javac bankapp/Menu.java bankapp/BankAccount.java bankapp/Transaction.java (for the Transaction class for example)
   ```

3. **Run the Application**:
   After compiling, you can run the application by executing:
   ```sh
   java bankapp.Menu
   ```
## Conclusion

BankApp provides a simulation of a banking system, allowing users to engage with various financial operations through a simple console interface. This application is ideal for educational purposes or as a base for more complex banking software development projects.






## Iteration 2 Information: 

## Description
The Bank Application is designed to manage user accounts effectively. It allows users to create an account, perform deposits and withdrawals, view transaction history, and transfer funds between accounts. The application also assigns an interest rate to savings accounts.

## Features
- **Account Creation**: Users can create an account by providing a username, password, and selecting an account type (savings or checking).
- **Balance Management**: Users can deposit or withdraw funds from their account.
- **Interest Rate**: Savings accounts are assigned a random interest rate between 4% and 7% upon creation.
- **Transaction History**: Every deposit and withdrawal transaction is recorded and can be displayed to the user.
- **Fund Transfers:** Users can transfer funds between accounts within the system.

## Code Structure
- `BankAccount.java`: Defines the bank account model, including balance, account type, interest rate, and transaction history.
- `Menu.java`: Handles user interactions, allowing them to create accounts, deposit and withdraw funds, and view transaction history.
- `Transaction.java`: Represents a transaction with a type (deposit, withdrawal, transfer), amount, and timestamp

## Test Functionality
- `BankAccountTests.java`: Tests the functionality of the `BankAccount` class, including constructors, deposits, and withdrawals.
- `MenuTests.java`: Tests the `Menu` class's ability to process deposits, withdrawals, and display transaction history.
- `TransactionTests.java`: Verifies the creation of transactions and their properties.

## Completed User Stories This Iteration
- Combined all previous functions for entire team from last iteration, added additional interest and account type functionality to reflect our new file structure. - Teni
- Add transfer functionality - Anusha
- Write test cases for combined files - Anusha/Courtney
- Fund Transfers: Added the ability for users to transfer funds between accounts. - Anusha

## User Stories for Next Iteration
- Finish opening up a credit card, and the tests, help teammates if they're stuck on a story. - Teni
- Updating the script.sh files for execution - Courtney
- Transfering funds between users - Anusha

## Currently Unimplemented Features
- **Interest Application**: Currently, the system assigns an interest rate to savings accounts but does not automatically apply calculated interest to the account balance.
- **Transfer Functionality**: While the transfer feature is implemented and functional, edge cases and error handling could be further refined.
- Need to make sure transaction history always works correctly
- Need to erify that interest rate generator is truly random

## Is there anything that you implemented but doesn't currently work? 
  - Teni- Not currently
  - Courtney - Not that I know of!
  - Anusha - Not that I know of

## What commands are needed to compile and run your code from the command line
There is a script.sh file in the development branch that needs to be implemented for the code to execute through this file

## Future Automation of Script:

### Future Installation and Usage

Navigate to the project's source directory and compile the Java files using:

```bash
javac bankapp/*.java
```

### Future Execution:

To run the system, use the following command from the same directory:

```bash
java bankapp.Main
```

### Future Running of Script:

Make the script executable and run it:

```bash
chmod +x run.sh
./run.sh
```




## Iteration 1 Information:

### Completed in This Iteration:

- **Account Creation**: Customers can now create a bank account, which can be either a checking or a savings account, each with a unique account number. (Anusha/Teni)
- **Deposit Funds**: Functionality to deposit money into accounts has been provided. This allows customers to increase their account balances by the specified amounts. (starter code + Courtney)
-  **Transaction History**: Customers can see the type and amount of the transactions they have made. (Courtney)
- **Withdraw Funds**: Customers can withdraw money from their accounts, given that they have sufficient funds available. (Courtney)
- **Interest Calculation**: Savings account holders can view the annual interest rate applicable to their accounts and calculate the interest based on their current balance. (Anusha)

### Planned for Next Iteration:

- Implementing funds transfer between accounts. (Courtney)
- Introducing monthly statements that summarize account activity. (Anusha)
- Adding joint account features allowing multiple users to manage a single account. (Anusha)
- The user should be able to open a credit card, and the an investment account (Teni)

### Current Limitations

- Transfers between accounts are not yet implemented, which is a high-priority feature for the next iteration.
- The withdrawal functionality does not currently handle scenarios where an overdraft might occur.
- Interest calculations are annual, and more frequent compounding options will be considered for future releases.
- There are some redundancies within the branches account-types and account-creation that will be merged/handled for the future iterations.
