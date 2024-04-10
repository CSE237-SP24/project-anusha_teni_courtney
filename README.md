# base-project

Iteration 2 

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
- - `Transaction.java`: Represents a transaction with a type (deposit, withdrawal, transfer), amount, and timestamp

## Test Functionality
- `BankAccountTests.java`: Tests the functionality of the `BankAccount` class, including constructors, deposits, and withdrawals.
- `MenuTests.java`: Tests the `Menu` class's ability to process deposits, withdrawals, and display transaction history.
- `TransactionTests.java`: Verifies the creation of transactions and their properties.

## Completed User Stories This Iteration
- Combined all previous functions for entire team from last iteration, added additional interest and account type functionality to reflect our new file structure. - Teni
- Add transfer functionality - Anusha
- Write test cases for combined files - Anusha/Courtney
- User can choose between a savings or checking account.
- Fund Transfers: Added the ability for users to transfer funds between accounts.

## User Stories for Next Iteration
- Finish opening up a credit card, and the tests, help teammates if they're stuck on a story. - Teni
- 

## Currently Unimplemented or Non-Working Features
- **Interest Application**: Currently, the system assigns an interest rate to savings accounts but does not automatically apply calculated interest to the account balance.
- **Transfer Functionality**: While the transfer feature is implemented and functional, edge cases and error handling could be further refined.

## What commands are needed to compile and run your code from the command line
There is a script.sh file in the development branch that needs to be implemented for the code to execute through this file

This README provides an overview and guide on how to interact with the A-Bank Application. It details the current iteration's accomplishments and outlines goals for future development.
