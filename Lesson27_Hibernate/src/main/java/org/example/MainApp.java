package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

import static org.example.Genre.SCIENCE;

public class MainApp {
    public static void main(String[] args) {
        Session session = AppSessionFactory.getSession();
        Book book = Book.builder().id(1).date(new Date()).availability(true).title("title").genre(SCIENCE).build();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
    }
}
