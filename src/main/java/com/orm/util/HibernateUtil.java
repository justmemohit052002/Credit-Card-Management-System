package com.orm.util;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {

            ApplicationContext context =
                    new ClassPathXmlApplicationContext("config.xml");

            sessionFactory = context.getBean("factory", SessionFactory.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}