# 🏦 Banking App (Java Console Application)
A simple Java console-based banking application that simulates real-world banking operations using Object-Oriented Programming (OOP) principles.

## 🔧 Features
- Create Savings and Current accounts
- Deposit and withdraw funds
- Check account balance and view account info
- Transfer funds between accounts
- View detailed transaction history with timestamps
- Console-based user interface using Java Scanner

## 🧠 OOP Concepts Demonstrated
- Encapsulation: Fields are protected and accessed via methods
- Inheritance: SavingsAccount and CurrentAccount inherit from Account
- Abstraction: Account is an abstract class with shared logic
- Polymorphism: Different account types implement withdrawal rules differently

## 📁 Project Structure
```
├── Account.java            # Abstract class for common account behavior
├── SavingsAccount.java     # Subclass with minimum balance logic
├── CurrentAccount.java     # Subclass with overdraft logic
├── Transaction.java        # Tracks all account transactions
├── BankSystem.java         # Manages all accounts and handles transfers
└── Main.java               # User menu and main application entry point
```
## ▶️ How to Run
*Compile all Java files:*
```
javac *.java
```
*Run the application:*
```
java Main
```
## 📌 Requirements
- Java 8 or later
- Terminal or command prompt to run the program

## 📜 License
This project is open-source and free to use for educational purposes.

## by Asish
