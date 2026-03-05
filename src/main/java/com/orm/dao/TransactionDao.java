package com.orm.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.orm.entity.Transaction;

public class TransactionDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public void saveTransaction(Transaction transaction) {

        hibernateTemplate.save(transaction);

        System.out.println("Transaction saved successfully.");
    }

}