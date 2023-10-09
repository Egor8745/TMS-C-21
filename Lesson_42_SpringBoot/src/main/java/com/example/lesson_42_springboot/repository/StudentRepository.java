package com.example.lesson_42_springboot.repository;

import com.example.lesson_42_springboot.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {
}
