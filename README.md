# 💳 Credit Card Management System


📌 Project Overview

 The Credit Card Management System is a console-based Java application developed using Spring Framework, Hibernate ORM, and MySQL. The project simulates how a banking system manages credit card services such as customer registration, issuing credit cards, performing transactions, and generating bills.
               
The main goal of this project is to demonstrate backend development concepts like Object Relational Mapping (ORM), transaction management, and database operations using Spring and Hibernate.
               
The system allows users to register customers, apply for credit cards, perform transactions using the credit card, generate bills, and view customer details. All the information is stored and managed in a MySQL database.


     🛠 Technologies Used

     Technology	Purpose
     Java	Core programming language
     Spring Framework	Dependency Injection and Transaction Management
     Hibernate ORM	Mapping Java objects to database tables
     MySQL	Database to store application data
     JDBC	Database connectivity     
     Maven	Dependency management



🧱 System Architecture

     The project follows a layered architecture, 
     which separates the application into different
     layers for better organization and maintainability.
     
     User (Console)
          │
          ▼
     App.java
          │
          ▼
     DAO Layer
     (CustomerDao, CreditCardDao, TransactionDao, BillDao)
          │
          ▼
     Entity Layer
     (Customer, CreditCard, Transaction, Bill)
          │
          ▼
     Hibernate ORM
          │
          ▼
     MySQL Database
     
     Each layer has a specific responsibility,
     which makes the system easier to understand and maintain.






📂 Project File Architecture

     The project is organized into packages that 
     separate different functionalities of the application.
     
     Credit_Card_Management_System
     │
     ├── src/main/java
     │
     │   ├── com.orm
     │   │     └── App.java
     │
     │   ├── com.orm.dao
     │   │     ├── CustomerDao.java
     │   │     ├── CreditCardDao.java
     │   │     ├── TransactionDao.java
     │   │     └── BillDao.java
     │
     │   ├── com.orm.entity
     │   │     ├── Customer.java
     │   │     ├── CreditCard.java
     │   │     ├── Transaction.java
     │   │     └── Bill.java
     │
     │   └── config.xml






📄 File Explanation
     
1️⃣ App.java
     
     Location:
     
     com.orm
     
     This is the main class of the application.
     
     Responsibilities:
     
     Starts the program
     
     Loads the Spring configuration file
     
     Displays the menu to the user
     
     Accepts user input
     
     Calls DAO classes to perform operations
     
     Example menu:
     
     ===== Credit Card Management System =====
     
     1 Register Customer
     2 Apply Credit Card
     3 Perform Transaction
     4 Generate Bill
     5 View Customer Details
     6 Exit
     
2️⃣ Entity Layer
     
     Location:
     
     com.orm.entity
     
     This layer contains entity classes, which represent database tables.
     Hibernate automatically maps these classes to MySQL tables.
     
     Customer.java
     
     Represents the Customer table.
     
     Stores customer details such as:
     
     customerId
     
     name
     
     email
     
     mobile
     
     address
     
     A customer can have multiple credit cards.
     
     CreditCard.java
     
     Represents the CreditCard table.
     
     Stores credit card details such as:
     
     cardId
     
     cardNumber
     
     creditLimit
     
     availableLimit
     
     customer
     
     Each credit card belongs to one customer.
     
     Transaction.java
     
     Represents the Transaction table.
     
     Stores transaction information such as:
     
     transactionId
     
     amount
     
     transactionDate
     
     creditCard
     
     Each transaction is linked to a credit card.
     
     Bill.java
     
     Represents the Bill table.
     
     Stores billing information such as:
     
     billId
     
     totalAmount
     
     dueDate
     
     creditCard
     
     Bills are generated based on credit card transactions.
     
3️⃣ DAO Layer
     
     Location:
     
     com.orm.dao
     
     DAO stands for Data Access Object.
     
     This layer handles all database operations using Hibernate.
     Each entity has a corresponding DAO class.
     
     
- CustomerDao.java
     
     Responsibilities:
     
     Save new customer
     
     Retrieve customer details from the database
     
- CreditCardDao.java
     
     Responsibilities:
     
     Apply for a credit card
     
     Store credit card details
     
     Link credit card with customer
     
     TransactionDao.java
     
- Responsibilities:
     
     Perform credit card transactions
     
     Store transaction records
     
     Update available credit limit
     
     
- BillDao.java
     
     Responsibilities:
     
     Generate bill
     
     Calculate total transaction amount
     
     Store billing details


⚙️ Configuration File
     config.xml
     
     This file contains the Spring and Hibernate configuration.
     
     Responsibilities include:
     
     Database Connection
     
     
     Connects the application to MySQL.
     
     -- jdbc:mysql://localhost:3306/credit_card_management_db



🔗 Entity Relationships
     Customer
        │
        │ One-To-Many
        ▼
     CreditCard
        │
        │ One-To-Many
        ▼
     Transaction
     
     CreditCard
        │
        │ One-To-Many
        ▼
     Bill
     
     This structure allows the system to manage relationships between customers, credit cards,      transactions, and bills.
