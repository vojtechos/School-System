package com.example.schoolsystemfx.repository;

import com.example.schoolsystemfx.model.Student;

import java.util.List;

public interface StudentRepository {

    void write(List<Student> studentList);

    List<Student> read();
}
