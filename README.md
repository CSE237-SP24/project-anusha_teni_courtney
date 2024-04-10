# base-project

Iteration 2 

## Description
The A-Bank Application is a simple banking system designed to manage user accounts, including deposit and withdrawal transactions. It allows users to create an account with a username and password, choose between savings and checking account types, and manage their balance through deposits and withdrawals. The application also tracks and displays transaction history.

## Features
- **Account Creation**: Users can create an account by providing a username, password, and selecting an account type (savings or checking).
- **Balance Management**: Users can deposit or withdraw funds from their account.
- **Interest Rate**: Savings accounts are assigned a random interest rate between 4% and 7% upon creation.
- **Transaction History**: Every deposit and withdrawal transaction is recorded and can be displayed to the user.

## Code Structure
- `BankAccount.java`: Defines the bank account model, including balance, account type, interest rate, and transaction history.
- `Menu.java`: Handles user interactions, allowing them to create accounts, deposit and withdraw funds, and view transaction history.
- `Transaction.java`: Represents a transaction, including type (deposit or withdrawal), amount, and timestamp.

## Test Functionality
- `BankAccountTests.java`: Tests the functionality of the `BankAccount` class, including constructors, deposits, and withdrawals.
- `MenuTests.java`: Tests the `Menu` class's ability to process deposits, withdrawals, and display transaction history.
- `TransactionTests.java`: Verifies the creation of transactions and their properties.

## Completed User Stories This Iteration
- Combined all previous functions for entire team from last iteration, added additional interest and account type functionality to reflect our new file structure. - Teni
- Add transfer functionality - Anusha
- Write test cases for combined files - Anusha/Courtney
- User can choose between a savings or checking account.

## User Stories for Next Iteration
- Enable account-to-account transfers between users. - Anusha
- Finish opening up a credit card, and the tests, help teammates if they're stuck on a story. - Teni

## Currently Unimplemented or Non-Working Features
- **Interest Calculation and Application**: While the application sets a random interest rate for savings accounts, it does not currently calculate or apply interest over time. This feature is planned for the next iteration.
- **Account-to-Account Transfers**: The functionality to transfer funds between accounts has not been implemented yet but is a goal for future development.

## What commands are needed to compile and run your code from the command line
There is a script.sh file in the development branch that needs to be implemented for the code to execute through this file
