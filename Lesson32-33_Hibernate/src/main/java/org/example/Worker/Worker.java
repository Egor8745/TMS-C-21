package org.example.Worker;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Task.TaskForWorker;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor

public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private TypeUsers typeUsers;
    @Temporal(TemporalType.DATE)
    private Date DateOfBirth;
    private String gender;

    @OneToMany(mappedBy = "worker")
    private List<TaskForWorker> task;


    public Worker(String name, TypeUsers typeUsers, Date dateOfBirth, String gender, List<TaskForWorker> task) {

        this.name = name;
        this.typeUsers = typeUsers;
        DateOfBirth = dateOfBirth;
        this.gender = gender;
        this.task = task;
    }
}
