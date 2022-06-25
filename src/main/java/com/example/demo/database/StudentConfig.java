package com.example.demo.database;

import com.example.demo.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student jackie = new Student(
                    "jackie",
                    "jackie@hotmail.com"
            );
            Student tom = new Student(
                    "tom",
                    "tom@gmail.com"
            );
            Student mary = new Student(
                    "mary",
                    "mary@ymail.com"
            );

            repository.saveAll(List.of(
                    jackie,
                    tom,
                    mary
            ));
        };
    }
}
