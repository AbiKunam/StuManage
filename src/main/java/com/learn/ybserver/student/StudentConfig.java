package com.learn.ybserver.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student jake = new Student("Jake", LocalDate.of(1995, Month.JUNE,22),"Jake@gmail.com");
            Student Dany = new Student("Dany", LocalDate.of(2000, Month.OCTOBER,23),"Dany@gmail.com");

            studentRepository.saveAll(List.of(jake,Dany));
        };
    }
}
