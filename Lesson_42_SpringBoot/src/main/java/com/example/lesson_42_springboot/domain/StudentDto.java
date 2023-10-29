package com.example.lesson_42_springboot.domain;

import java.util.UUID;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class StudentDto {
    private UUID id;
    private String name;
    private String surname;
    private Integer age;
    private Integer number;

    public StudentDto() {
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

        this.number = number;
    }

    public StudentDto(UUID id, String name, String surname, Integer age, Integer number) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
    }
}