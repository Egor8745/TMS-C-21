package org.example.Task;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Worker.Worker;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor

public class TaskForWorker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    @Version
    Integer version;
    @Enumerated(EnumType.STRING)
    private StatusTask statusTask;

    @ManyToOne
    private Worker worker;

    public TaskForWorker(String title, String description, StatusTask statusTask) {
        this.title = title;
        this.description = description;
        this.statusTask = statusTask;

    }
}
