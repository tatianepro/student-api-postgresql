package com.github.tatianepro.studentapi.service.impl;

import com.github.tatianepro.studentapi.entity.Student;
import com.github.tatianepro.studentapi.repository.StudentRepository;
import com.github.tatianepro.studentapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getStudents() {
        return repository.findAll();
    }

    @Override
    public Student saveStudent(Student newStudent) {
        Optional<Student> studentOptional = repository.findStudentByEmail(newStudent.getEmail());
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("email already exists");
        }
        return repository.save(newStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        boolean exists = repository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("id not found");
        }
        repository.deleteById(id);
    }
}
