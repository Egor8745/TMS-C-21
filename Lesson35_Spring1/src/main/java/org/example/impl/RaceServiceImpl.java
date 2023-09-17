package org.example.impl;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.Couple;
import org.example.service.RaceService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@Data

public class RaceServiceImpl implements RaceService {
    private List<Couple> coupleList;
    private Integer coupleNumber;

    @Override
    public void listCouples() {
        System.out.println(coupleList.toString());
    }

    @Override
    public void betOnCouple(Integer id) {
        this.coupleNumber = id;
        System.out.println("your bet has been accepted");
    }

    @Override
    public void startRace() {
        double[] t = new double[coupleList.size()];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < coupleList.size(); j++) {
                t[j] = ((int) (coupleList.get(j).getSpeed()));
                System.out.println(coupleList.get(j) + " has finished " + i + " round in " + t[j]);
            }
        }
        double minTime = Arrays.stream(t).min().getAsDouble();
        int winCouple = Arrays.binarySearch(t, minTime);
        System.out.println(winCouple);
        System.out.println(coupleList.get(winCouple) + "win");

        if (this.coupleNumber == coupleList.get(winCouple).getNumber()) {
            System.out.println("You win");
        } else {
            System.out.println("You lose");
        }

    }
}
