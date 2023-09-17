package org.example;

import org.example.impl.RaceServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        RaceServiceImpl raceService = context.getBean(RaceServiceImpl.class);
        System.out.println("Select the couple number from the list to place a bet");
        raceService.listCouples();
        raceService.betOnCouple(new Scanner(System.in).nextInt());

        raceService.startRace();
    }
}
