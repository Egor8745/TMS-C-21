package com.example.lesson_42_springboot.mapper;

import com.example.lesson_42_springboot.domain.StudentDto;
import com.example.lesson_42_springboot.model.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "surname", source = "surname")
    StudentEntity toEntity(StudentDto dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "surname", source = "surname")
    StudentDto toStudentDto(StudentEntity entity);

    List<StudentDto> toDtoList(List<StudentEntity> entity);
}
