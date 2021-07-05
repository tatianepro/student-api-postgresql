package com.github.tatianepro.studentapi.config;

import com.github.tatianepro.studentapi.entity.Student;
import com.github.tatianepro.studentapi.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfiguration {
    @Bean
    CommandLineRunner runner(StudentRepository repository) {
        return args -> {
            Student mariana = new Student(
                    "Mariana",
                    "mariana@gmail.com",
                    LocalDate.of(2000, Month.APRIL, 25));
            Student daniel = new Student(
                    "Daniel",
                    "daniel@yahoo.com",
                    LocalDate.of(1998, Month.DECEMBER, 02));

            repository.saveAll(List.of(mariana, daniel));
        };
    }
}
