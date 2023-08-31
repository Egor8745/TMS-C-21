package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class AppSessionFactory {
    private static AppSessionFactory factory = new AppSessionFactory();
    private static SessionFactory sessionFactory;

    private AppSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/entitybase");
        configuration.setProperty("hibernate.connection.username", "myuser");
        configuration.setProperty("hibernate.connection.password", "secret");
        configuration.setProperty("hibernaate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.addAnnotatedClass(Book.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
