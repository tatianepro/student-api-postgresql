package com.github.tatianepro.studentapi.service;

import com.github.tatianepro.studentapi.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    Student saveStudent(Student newStudent);

    void deleteStudent(Long id);

    void updateStudent(Long id, String name, String email);
}
