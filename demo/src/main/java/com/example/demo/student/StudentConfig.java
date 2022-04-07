package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student student = new Student(
                    1L,
                    "Mariam",
                    "mariam@gmail.com",
                    LocalDate.of(2000, Month.FEBRUARY, 5)
            );

            repository.saveAll((List.of(student)));
        };
    }
}
