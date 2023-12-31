package org.example.service;

import org.example.AppSessionFactory;
import org.example.task.StatusTask;
import org.example.task.TaskForWorker;
import org.example.worker.Worker;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.LockModeType;
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
            TaskForWorker task = session.find(TaskForWorker.class, id, LockModeType.OPTIMISTIC);
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
