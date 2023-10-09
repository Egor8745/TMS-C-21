package com.example.lesson_42_springboot.service;

import com.example.lesson_42_springboot.domain.StudentDto;

import java.util.List;

public interface StudentService {
    void save(StudentDto student);

    List<StudentDto> getAll();
}
