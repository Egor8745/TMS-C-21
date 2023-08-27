package org.example;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "table_name")
public class Book {
    @Id
    private Integer id;
    private String title;
    private boolean availability;
    @Temporal(TemporalType.DATE)
    private Date date = new Date();
    @Enumerated(EnumType.STRING)
    private Genre genre;
}
