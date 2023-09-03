package org.example.Worker;

import org.example.AppSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class WorkerService {
    public void saveWorker(Worker worker) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(worker);
        transaction.commit();
        session.close();
    }

    public void deleteWorker(Worker worker) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(worker);
        transaction.commit();
        session.close();
    }

    public void updateWorker(Worker worker) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(worker);
        transaction.commit();
        session.close();
    }

    public Worker getWorker(Integer id) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        Worker worker = session.find(Worker.class, id);
        transaction.commit();
        session.close();
        return worker;
    }


}
