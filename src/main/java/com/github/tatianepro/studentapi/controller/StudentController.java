package com.github.tatianepro.studentapi.controller;

import com.github.tatianepro.studentapi.entity.Student;
import com.github.tatianepro.studentapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getStudents() {
        return service.getStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student newStudent) {
        return service.saveStudent(newStudent);
    }

}
