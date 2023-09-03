package org.example.Task;

import org.example.AppSessionFactory;
import org.example.Worker.Worker;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TaskService {
    public void saveTask(TaskForWorker task) {
        try (Session session = AppSessionFactory.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(task);
            transaction.commit();
        }
    }

    public TaskForWorker getTask(Integer id) {
        try (Session session = AppSessionFactory.getSession()) {
            Transaction transaction = session.beginTransaction();
            TaskForWorker task = session.find(TaskForWorker.class, id);
            transaction.commit();
            return task;
        }
    }

    public List<TaskForWorker> getTaskWorker(Worker worker) {
        try (Session session = AppSessionFactory.getSession()) {
            Transaction transaction = session.beginTransaction();
            List<TaskForWorker> tasks = worker.getTask();
            transaction.commit();
            return tasks;
        }
    }

    public void changeStatusTask(TaskForWorker task, StatusTask status) {
        try (Session session = AppSessionFactory.getSession()) {
            Transaction transaction = session.beginTransaction();
            task.setStatusTask(status);
            transaction.commit();
        }
    }

}
