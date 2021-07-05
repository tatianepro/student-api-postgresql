package com.github.tatianepro.studentapi.controller;

import com.github.tatianepro.studentapi.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @GetMapping
    public List<Student> getStudents() {
        return List.of(
                new Student(null,
                        "Mariana",
                        "mariana@gmail.com",
                        LocalDate.of(2000, Month.APRIL, 25),
                        21),
                new Student(null,
                        "Daniel",
                        "daniel@yahoo.com",
                        LocalDate.of(1998, Month.DECEMBER, 02),
                        23)
        );
    }

}
