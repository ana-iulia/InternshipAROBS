package com.example.musify.hibernate;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import com.example.musify.configuration.HibernateUtil;
import com.example.musify.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UserRepo {
    public void saveUser(User user) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // operation 1
            Object object = session.save(user);

            // operation 2
            session.get(User.class, (Serializable) object);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<User> getUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM User", User.class).getResultList();
        }

    }

}
