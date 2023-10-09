package com.example.lesson_42_springboot.impl;

import com.example.lesson_42_springboot.domain.StudentDto;
import com.example.lesson_42_springboot.mapper.StudentMapper;
import com.example.lesson_42_springboot.model.StudentEntity;
import com.example.lesson_42_springboot.repository.StudentRepository;
import com.example.lesson_42_springboot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentMapper mapper;
    private final StudentRepository repository;

    @Override
    public void save(StudentDto student) {
        StudentEntity entity = mapper.toEntity(student);
        repository.save(entity);
    }

    @Override
    public List<StudentDto> getAll() {
        List<StudentEntity> allStudent = repository.findAll();
        return mapper.toDtoList(allStudent);
    }
}

