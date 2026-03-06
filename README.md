# 💳 Credit Card Management System

![Java](https://img.shields.io/badge/Java-Backend-blue)
![Spring](https://img.shields.io/badge/Spring-Framework-green)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM-orange)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)

---

# 📌 Project Overview

The **Credit Card Management System** is a console-based Java application built using **Spring Framework, Hibernate ORM, and MySQL**.  
The project simulates how a banking system manages credit card services such as:

- Customer registration
- Issuing credit cards
- Performing transactions
- Generating bills
- Viewing customer details

This project demonstrates important backend development concepts like:

- Object Relational Mapping (ORM)
- Transaction management
- Database operations using Hibernate
- Layered architecture

All information is stored and managed in a **MySQL database**.

---

# 🚀 Features

✔ Register new customers  
✔ Apply for credit cards  
✔ Perform credit card transactions  
✔ Automatically update available credit limit  
✔ Generate bills based on transactions  
✔ View customer details  

---

# 🛠 Technologies Used

| Technology | Purpose |
|-------------|-------------|
| **Java** | Core programming language |
| **Spring Framework** | Dependency Injection & Transaction Management |
| **Hibernate ORM** | Mapping Java objects to database tables |
| **MySQL** | Database to store application data |
| **JDBC** | Database connectivity |
| **Maven** | Dependency management |

---

# 🧱 System Architecture

The project follows a **Layered Architecture**.

```
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
```

Each layer has a specific responsibility which makes the system easier to understand and maintain.

---

# 📂 Project Structure

```
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
```

---

# 📄 File Explanation

## 1️⃣ App.java

**Location:**  
`com.orm`

This is the **main class of the application**.

### Responsibilities

- Starts the application
- Loads the Spring configuration file
- Displays the console menu
- Accepts user input
- Calls DAO classes to perform operations

### Example Menu

```
===== Credit Card Management System =====

1 Register Customer
2 Apply Credit Card
3 Perform Transaction
4 Generate Bill
5 View Customer Details
6 Exit
```

---

# 🧩 Entity Layer

**Location:**  
`com.orm.entity`

This layer contains entity classes that represent database tables.

Hibernate automatically maps these classes to MySQL tables.

---

## 👤 Customer.java

Represents the **Customer table**.

Stores:

- `customerId`
- `name`
- `email`
- `mobile`
- `address`

Relationship:

```
One Customer → Many Credit Cards
```

---

## 💳 CreditCard.java

Represents the **CreditCard table**.

Stores:

- `cardId`
- `cardNumber`
- `creditLimit`
- `availableLimit`
- `customer`

Relationship:

```
One Credit Card → One Customer
```

---

## 💰 Transaction.java

Represents the **Transaction table**.

Stores:

- `transactionId`
- `amount`
- `transactionDate`
- `creditCard`

Relationship:

```
One Credit Card → Many Transactions
```

---

## 🧾 Bill.java

Represents the **Bill table**.

Stores:

- `billId`
- `totalAmount`
- `dueDate`
- `creditCard`

Bills are generated based on **credit card transactions**.

---

# 🗂 DAO Layer

**Location:**  
`com.orm.dao`

DAO stands for **Data Access Object**.

This layer handles database operations using **Hibernate**.

Each entity has a corresponding DAO class.

---

## 📌 CustomerDao.java

Responsibilities:

- Save new customer
- Retrieve customer details from the database

---

## 📌 CreditCardDao.java

Responsibilities:

- Apply for a credit card
- Store credit card details
- Link credit card with customer

---

## 📌 TransactionDao.java

Responsibilities:

- Perform credit card transactions
- Store transaction records
- Update available credit limit

---

## 📌 BillDao.java

Responsibilities:

- Generate bill
- Calculate total transaction amount
- Store billing details

---

# ⚙️ Configuration File

## config.xml

This file contains **Spring and Hibernate configuration**.

### Responsibilities

- Database connection
- Hibernate session configuration
- Transaction management

Example connection:

```
jdbc:mysql://localhost:3306/credit_card_management_db
```

---

# 🔗 Entity Relationships

```
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
```

This structure manages relationships between:

- Customers
- Credit cards
- Transactions
- Bills

---

# 📊 Database Tables

The application automatically creates these tables using **Hibernate ORM**:

- `customer`
- `credit_card`
- `transaction`
- `bill`

---

# 🎯 Learning Outcomes

Through this project you can understand:

- Spring Framework basics
- Hibernate ORM mapping
- DAO design pattern
- Layered architecture
- Database operations with MySQL
- Transaction management

---

# 👨‍💻 Author

**Mohit Chouhan**

 
