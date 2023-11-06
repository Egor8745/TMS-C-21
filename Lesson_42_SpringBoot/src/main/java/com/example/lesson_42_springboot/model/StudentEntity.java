package com.example.lesson_42_springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

import java.util.Random;
import java.util.UUID;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String name;
    private String surname;
    private Integer age;
    private Integer number;

    public StudentEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        this.number = randomNumber;
    }

    public void setNewNumber(Integer number) {
        this.number = number;
    }

    public StudentEntity(UUID id, String name, String surname, Integer age, Integer number) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
    }
}
