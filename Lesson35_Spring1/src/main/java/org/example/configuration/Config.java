package org.example.configuration;

import org.example.domain.Couple;
import org.example.domain.Horse;
import org.example.domain.Rider;
import org.example.impl.RaceServiceImpl;
import org.example.service.RaceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class Config {

    @Bean
    public Horse horse1() {
        Horse horse = new Horse();
        horse.setAge(8);
        horse.setName("horse1");
        return horse;
    }

    @Bean
    public Horse horse2() {
        Horse horse = new Horse();
        horse.setAge(7);
        horse.setName("horse2");
        return horse;
    }

    @Bean
    public Horse horse3() {
        Horse horse = new Horse();
        horse.setAge(10);
        horse.setName("horse3");
        return horse;
    }

    @Bean
    public Rider rider1() {
        Rider rider = new Rider();
        rider.setName("rider1");
        rider.setAge(21);
        return rider;
    }

    @Bean
    public Rider rider2() {
        Rider rider = new Rider();
        rider.setName("rider2");
        rider.setAge(20);
        return rider;
    }

    @Bean
    public Rider rider3() {
        Rider rider = new Rider();
        rider.setName("rider2");
        rider.setAge(19);
        return rider;
    }

    @Bean
    public Couple couple1() {
        Couple couple = new Couple();
        couple.setHorse(horse1());
        couple.setRider(rider1());
        return couple;
    }

    @Bean
    public Couple couple2() {
        Couple couple = new Couple();
        couple.setHorse(horse2());
        couple.setRider(rider2());
        return couple;
    }

    @Bean
    public Couple couple3() {
        Couple couple = new Couple();
        couple.setHorse(horse3());
        couple.setRider(rider3());
        return couple;
    }

    @Bean
    public RaceService raceService() {
        RaceServiceImpl raceService = new RaceServiceImpl();
        List<Couple> coupleList = new ArrayList<>();
        coupleList.add(couple1());
        coupleList.add(couple2());
        coupleList.add(couple3());
        raceService.setCoupleList(coupleList);
        return raceService;
    }
}

