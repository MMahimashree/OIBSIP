# OIBSIP Java Development - Task 3
# ATM Interface

## Objective

The objective of this project is to develop a console-based ATM Interface using Java and Object-Oriented Programming concepts.

## Features

- User ID and PIN authentication
- Maximum of 3 incorrect login attempts
- Transaction History
- Withdraw money
- Deposit money
- Transfer money between accounts
- Check account balance
- Insufficient balance validation
- Transaction storage using ArrayList
- Quit option

## Technologies Used

- Java
- Object-Oriented Programming
- ArrayList
- HashMap
- Scanner
- LocalDateTime

## Classes

- `ATM.java` - Handles ATM operations and user interaction
- `Account.java` - Manages account details, balance, and transactions
- `Transaction.java` - Stores transaction information
- `Bank.java` - Manages bank accounts
- `Main.java` - Starts the ATM application

## Test Credentials

### Account 1
- User ID: `user1001`
- PIN: `1234`
- Initial Balance: Rs.10000

### Account 2
- User ID: `user1002`
- PIN: `5678`
- Initial Balance: Rs.5000

## How to Run

1. Open the project in IntelliJ IDEA.
2. Navigate to `src`.
3. Compile the Java files.
4. Run `Main.java`.
5. Enter the User ID and PIN.
6. Select an operation from the ATM menu.

## Project Structure

```text
Java-Task3-ATMInterface
├── README.md
├── screenshots
│   ├── 01_login_menu.png
│   ├── 02_transactions.png
│   ├── 03_transaction_history.png
│   └── 04_three_wrong_attempts.png
└── src
    ├── ATM.java
    ├── Account.java
    ├── Transaction.java
    ├── Bank.java
    └── Main.java