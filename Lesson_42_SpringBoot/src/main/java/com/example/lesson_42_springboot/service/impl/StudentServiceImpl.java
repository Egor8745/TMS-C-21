package com.example.lesson_42_springboot.service.impl;

import com.example.lesson_42_springboot.domain.StudentDto;
import com.example.lesson_42_springboot.mapper.StudentMapper;
import com.example.lesson_42_springboot.model.StudentEntity;
import com.example.lesson_42_springboot.repository.StudentRepository;
import com.example.lesson_42_springboot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


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

    @Override
    public StudentDto liftUp(UUID id) {
        StudentEntity student = repository.getById(id);
        student.setNewNumber((student.getNumber()) - 1);
        repository.save(student);
        return mapper.toStudentDto(student);

    }

    @Override
    public StudentDto lowerDown(UUID id) {
        StudentEntity byId = repository.getById(id);
        byId.setNewNumber(byId.getNumber() + 1);
        repository.save(byId);
        return mapper.toStudentDto(byId);
    }

    @Override
    public List<StudentDto> sortNumber() {
        List<StudentEntity> allByOrderByNumberAsc = repository.findAllByOrderByNumberAsc();
        return mapper.toDtoList(allByOrderByNumberAsc);
    }

}