package com.orm.dao;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.orm.entity.Customer;
import com.orm.entity.CreditCard;

public class CustomerDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public void saveCustomer(Customer customer) {

        hibernateTemplate.save(customer);

        System.out.println("Customer registered successfully.");
    }

    @Transactional(readOnly = true)
    public Customer getCustomerById(int id) {

        Customer customer = hibernateTemplate.get(Customer.class, id);

        if (customer != null) {

            // initialize cards
            Hibernate.initialize(customer.getCards());

            customer.getCards().forEach(card -> {

                // initialize transactions
                Hibernate.initialize(card.getTransactions());

                // initialize bills
                Hibernate.initialize(card.getBills());

            });

        }

        return customer;
    }

    @Transactional
    public void updateCustomer(Customer customer) {

        hibernateTemplate.update(customer);

        System.out.println("Customer updated successfully.");
    }

    @Transactional
    public void deleteCustomer(int id) {

        Customer c = hibernateTemplate.get(Customer.class, id);

        if (c != null) {

            hibernateTemplate.delete(c);

            System.out.println("Customer deleted successfully.");

        } else {

            System.out.println("Customer not found.");

        }

    }
}