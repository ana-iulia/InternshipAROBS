package com.example.musify.hibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

//    public List<User> getUsers() {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//           // Query query = session.createNamedQuery("findAllUsers", User.class);
//            return session.createNamedQuery("findAllUsers", User.class).getResultList();
//        }
//
//    }


    public List<User> getUsers() {
        Transaction transaction = null;
        List<User> users = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            users = session.createNamedQuery("findAllUsers", User.class).getResultList();
            for (User a: users);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.getMessage();
        } finally {
            HibernateUtil.shutdown();
        }
        return users;
    }

}
