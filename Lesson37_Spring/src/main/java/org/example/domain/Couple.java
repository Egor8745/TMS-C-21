package org.example.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@ToString
@Component
public class Couple {
    private Integer number;
    private Rider rider;
    private Horse horse;
    private double speed;

    public Couple() {
        this.speed = (int) (Math.random() * 100);
    }
}
