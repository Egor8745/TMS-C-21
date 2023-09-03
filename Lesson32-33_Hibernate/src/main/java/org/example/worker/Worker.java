package org.example.worker;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.task.TaskForWorker;

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
    private Date dateOfBirth;
    private String gender;

    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
    private List<TaskForWorker> task;


    public Worker(String name, TypeUsers typeUsers, Date dateOfBirth, String gender, List<TaskForWorker> task) {

        this.name = name;
        this.typeUsers = typeUsers;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.task = task;
    }
    @PrePersist
    public void prePersist() {
        System.out.println("Call prePersist");
    }

    @PostPersist
    public void postPersist() {
        System.out.println("Call postPersist");
    }
}
