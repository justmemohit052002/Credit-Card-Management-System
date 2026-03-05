package com.orm;

import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.orm.dao.BillDao;
import com.orm.dao.CreditCardDao;
import com.orm.dao.CustomerDao;
import com.orm.dao.TransactionDao;
import com.orm.entity.Customer;
import com.orm.entity.CreditCard;
import com.orm.entity.Transaction;
import com.orm.entity.Bill;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("config.xml");

        CustomerDao customerDao = context.getBean("customerDao", CustomerDao.class);
        CreditCardDao cardDao = context.getBean("creditCardDao", CreditCardDao.class);
        TransactionDao transactionDao = context.getBean("transactionDao", TransactionDao.class);
        BillDao billDao = context.getBean("billDao", BillDao.class);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Credit Card Management System =====");
            System.out.println("1. Register Customer");
            System.out.println("2. Apply Credit Card");
            System.out.println("3. Perform Transaction");
            System.out.println("4. Generate Bill");
            System.out.println("5. View Customer Details");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            // 1 Register Customer
            case 1:

                Customer customer = new Customer();

                System.out.print("Enter Name: ");
                customer.setName(sc.nextLine());

                System.out.print("Enter Email: ");
                customer.setEmail(sc.nextLine());

                System.out.print("Enter Mobile: ");
                customer.setMobile(sc.nextLine());

                System.out.print("Enter Address: ");
                customer.setAddress(sc.nextLine());

                customerDao.saveCustomer(customer);

                System.out.println("Customer registered successfully.");
                break;


            // 2 Apply Credit Card
            case 2:

                System.out.print("Enter Customer ID: ");
                int custId = sc.nextInt();

                Customer cust = customerDao.getCustomerById(custId);

                if (cust == null) {
                    System.out.println("Customer not found.");
                    break;
                }

                CreditCard card = new CreditCard();

                System.out.print("Enter Card Number: ");
                card.setCard_number(sc.nextLong());

                System.out.print("Enter Credit Limit: ");
                double limit = sc.nextDouble();

                card.setCredit_limit(limit);
                card.setAvailable_limit(limit);
                card.setCustomer(cust);

                cardDao.saveCard(card);

                System.out.println("Credit card issued successfully.");
                break;


            // 3 Perform Transaction
            case 3:

                System.out.print("Enter Card ID: ");
                int cardId = sc.nextInt();
                sc.nextLine();

                CreditCard creditCard = cardDao.getCardById(cardId);

                if (creditCard == null) {
                    System.out.println("Card not found.");
                    break;
                }

                System.out.print("Enter Transaction Amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();

                if (amount > creditCard.getAvailable_limit()) {

                    System.out.println("Transaction declined! Credit limit exceeded.");
                    break;

                }

                Transaction transaction = new Transaction();

                System.out.print("Enter Merchant Name: ");
                transaction.setMerchant(sc.nextLine());

                transaction.setAmount(amount);
                transaction.setDate(LocalDate.now());
                transaction.setCreditCard(creditCard);

                transactionDao.saveTransaction(transaction);

                creditCard.setAvailable_limit(
                        creditCard.getAvailable_limit() - amount
                );

                cardDao.updateCard(creditCard);

                System.out.println("Transaction successful.");
                break;


            // 4 Generate Bill
            case 4:

                System.out.print("Enter Card ID: ");
                int billCardId = sc.nextInt();

                CreditCard billCard = cardDao.getCardById(billCardId);

                if (billCard == null) {
                    System.out.println("Card not found.");
                    break;
                }

                Bill bill = new Bill();

                System.out.print("Enter Total Amount: ");
                bill.setTotal_amount(sc.nextDouble());

                bill.setBill_date(LocalDate.now());
                bill.setDue_date(LocalDate.now().plusDays(15));
                bill.setCreditCard(billCard);

                billDao.saveBill(bill);

                System.out.println("Bill generated successfully.");
                break;


            // 5 View Customer Details
            case 5:

                System.out.print("Enter Customer ID: ");
                int id = sc.nextInt();

                Customer customerData = customerDao.getCustomerById(id);

                if (customerData == null) {

                    System.out.println("Customer not found.");
                    break;

                }

                System.out.println("\n===== Customer Details =====");
                System.out.println("Customer ID: " + customerData.getCustomer_id());
                System.out.println("Name: " + customerData.getName());
                System.out.println("Email: " + customerData.getEmail());
                System.out.println("Mobile: " + customerData.getMobile());
                System.out.println("Address: " + customerData.getAddress());

                System.out.println("\n----- Credit Cards -----");

                if (customerData.getCards() != null && !customerData.getCards().isEmpty()) {

                    customerData.getCards().forEach(crd -> {

                        System.out.println("\nCard ID: " + crd.getCard_id());
                        System.out.println("Card Number: " + crd.getCard_number());
                        System.out.println("Credit Limit: " + crd.getCredit_limit());
                        System.out.println("Available Limit: " + crd.getAvailable_limit());

                        System.out.println("---- Transactions ----");

                        if (crd.getTransactions() != null) {

                            crd.getTransactions().forEach(tr -> {

                                System.out.println("Transaction ID: " + tr.getTransaction_id());
                                System.out.println("Amount: " + tr.getAmount());
                                System.out.println("Merchant: " + tr.getMerchant());
                                System.out.println("Date: " + tr.getDate());

                            });

                        }

                        System.out.println("---- Bills ----");

                        if (crd.getBills() != null) {

                            crd.getBills().forEach(bl -> {

                                System.out.println("Bill ID: " + bl.getBill_id());
                                System.out.println("Total Amount: " + bl.getTotal_amount());
                                System.out.println("Bill Date: " + bl.getBill_date());
                                System.out.println("Due Date: " + bl.getDue_date());

                            });

                        }

                    });

                } else {

                    System.out.println("No credit cards found.");

                }

                break;


            case 6:

                System.out.println("Exiting system...");
                sc.close();
                System.exit(0);


            default:

                System.out.println("Invalid choice. Try again.");

            }

        }

    }

}