package com.github.tatianepro.studentapi.service.impl;

import com.github.tatianepro.studentapi.entity.Student;
import com.github.tatianepro.studentapi.service.StudentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
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
