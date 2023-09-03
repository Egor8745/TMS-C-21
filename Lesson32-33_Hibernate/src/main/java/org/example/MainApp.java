package org.example;

import org.example.Task.StatusTask;
import org.example.Task.TaskForWorker;
import org.example.Task.TaskService;
import org.example.Worker.TypeUsers;
import org.example.Worker.Worker;
import org.example.Worker.WorkerService;

import java.util.Date;
import java.util.List;


public class MainApp {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        WorkerService workerService = new WorkerService();

        TaskForWorker task1 = new TaskForWorker("Urgently", "annual report", StatusTask.NEW);
        TaskForWorker task2 = new TaskForWorker("Urgently", "report", StatusTask.IN_PROGRESS);
        TaskForWorker task3 = new TaskForWorker("Very important", "preparation for the weekend", StatusTask.DONE);
        taskService.saveTask(task1);
        taskService.saveTask(task2);
        taskService.saveTask(task3);
        Worker worker1 = new Worker("Alex", TypeUsers.USER, new Date(96, 9, 21), "man", List.of(task1, task2, task3));

        TaskForWorker task4 = new TaskForWorker("Very important", "check Alex annual report", StatusTask.NEW);
        TaskForWorker task5 = new TaskForWorker("Urgently", "report", StatusTask.IN_PROGRESS);
        TaskForWorker task6 = new TaskForWorker("Very important", "preparation for the weekend", StatusTask.IN_PROGRESS);
        taskService.saveTask(task4);
        taskService.saveTask(task5);
        taskService.saveTask(task6);
        Worker worker2 = new Worker("Diana", TypeUsers.ADMIN, new Date(93, 5, 22), "woman", List.of(task4, task5, task6));

        workerService.saveWorker(worker1);
        workerService.saveWorker(worker2);

        taskService.changeStatusTask(task1,StatusTask.IN_PROGRESS);

        workerService.deleteWorker(worker1);

    }
}
