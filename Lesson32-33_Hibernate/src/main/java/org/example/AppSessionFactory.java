package org.example;

import org.example.task.TaskForWorker;
import org.example.worker.Worker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;


public class AppSessionFactory {
    private static AppSessionFactory factory = new AppSessionFactory();
    private static SessionFactory sessionFactory;

    private AppSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        configuration.setProperty("hibernate.connection.username", "myuser");
        configuration.setProperty(AvailableSettings.PASS, "secret");
        configuration.setProperty("hibernaate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty(AvailableSettings.HBM2DDL_AUTO, "create-drop");
        configuration.setProperty(AvailableSettings.SHOW_SQL, "true");

        configuration.addAnnotatedClass(Worker.class);
        configuration.addAnnotatedClass(TaskForWorker.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
