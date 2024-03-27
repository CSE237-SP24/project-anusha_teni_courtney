# base-project
## Bank Account Management System

## Introduction

This Bank Account Management System is designed to provide a simple simulation of a banking environment. It enables customers to create bank accounts, both checking and savings that are password protected, and manage their finances by depositing and withdrawing funds. For savings accounts, customers can also view their annual interest rate and the calculated interest on their balance.

## Features and User Stories

### Completed in This Iteration:

- **Account Creation**: Customers can now create a bank account, which can be either a checking or a savings account, each with a unique account number. (Anusha/Teni)
- **Deposit Funds**: Functionality to deposit money into accounts has been provided. This allows customers to increase their account balances by the specified amounts.
- **Withdraw Funds**: Customers can withdraw money from their accounts, given that they have sufficient funds available. (Courtney)
- **Interest Calculation**: Savings account holders can view the annual interest rate applicable to their accounts and calculate the interest based on their current balance. (Anusha)

### Planned for Next Iteration:

- Implementing funds transfer between accounts. (Courtney)
- Introducing monthly statements that summarize account activity. (Anusha)
- Adding joint account features allowing multiple users to manage a single account. (Anusha)
- The user should be able to open a credit card, and the an investment account (Teni)

## Current Limitations

- Transfers between accounts are not yet implemented, which is a high-priority feature for the next iteration.
- The withdrawal functionality does not currently handle scenarios where an overdraft might occur.
- Interest calculations are annual, and more frequent compounding options will be considered for future releases.
- There are some redundancies within the branches account-types and account-creation that will be merged/handled for the future iterations.

Is there anything that you implemented but doesn't currently work? 
  Teni- Not currently 
  Courtney - Not that I know of!
  Anusha - Not that I know of
  
What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!) 
There are a script.sh files in the account-creation and account-types branch. Scripts still need some work

### Future Automation of Script:

## Future Installation and Usage

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
