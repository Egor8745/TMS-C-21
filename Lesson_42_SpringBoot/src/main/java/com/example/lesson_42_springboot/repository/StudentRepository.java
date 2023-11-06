package com.example.lesson_42_springboot.repository;

import com.example.lesson_42_springboot.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentEntity, UUID>, JpaSpecificationExecutor<StudentEntity> {
    List<StudentEntity> findAllByOrderByNumberAsc();

    StudentEntity getById(UUID id);

}
