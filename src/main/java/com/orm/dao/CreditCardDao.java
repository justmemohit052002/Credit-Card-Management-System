package com.orm.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.orm.entity.CreditCard;

public class CreditCardDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public void saveCard(CreditCard card) {
        hibernateTemplate.save(card);
        System.out.println("Credit card issued successfully.");
    }

    public CreditCard getCardById(int id) {
        return hibernateTemplate.get(CreditCard.class, id);
    }

    @Transactional
    public void updateCard(CreditCard card) {
        hibernateTemplate.update(card);
    }
}