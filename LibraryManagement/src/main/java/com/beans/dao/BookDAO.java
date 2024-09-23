package com.beans.dao;

import com.beans.model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.beans.util.HibernateUtil;

import java.util.List;

public class BookDAO {
    public void save(Book book) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Book", Book.class).list();
        }
    }

    // Add more methods as needed
}
