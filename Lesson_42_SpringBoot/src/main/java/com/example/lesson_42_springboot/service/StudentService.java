package com.example.lesson_42_springboot.service;

import com.example.lesson_42_springboot.domain.StudentDto;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    void save(StudentDto student);

    List<StudentDto> getAll();

    StudentDto liftUp(UUID id);

    StudentDto lowerDown(UUID id);

    List<StudentDto> sortNumber();


}
