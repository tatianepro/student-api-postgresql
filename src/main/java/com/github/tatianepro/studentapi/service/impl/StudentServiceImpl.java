package com.github.tatianepro.studentapi.service.impl;

import com.github.tatianepro.studentapi.entity.Student;
import com.github.tatianepro.studentapi.repository.StudentRepository;
import com.github.tatianepro.studentapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    @Override
    public void updateStudent(Long id, String name, String email) {
        Student studentFound = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("student with id " + id + " does not exists"));

        if(name != null && name.length() > 0 && !Objects.equals(studentFound.getName(), name)) {
            studentFound.setName(name);
        }
        if(email != null && email.length() > 0 && !Objects.equals(studentFound.getEmail(), email)) {
            Optional<Student> studentOptional = repository.findStudentByEmail(email);
            if(studentOptional.isPresent()) {
                throw new IllegalStateException("email already exists");
            }
            studentFound.setEmail(email);
        }
    }
}
