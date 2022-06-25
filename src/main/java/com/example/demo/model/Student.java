package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Integer id;
    private String name;
    private String email;
    private LocalDate insertDate;

    public Student(@JsonProperty("name") String name, @JsonProperty("email") String email) {
        this.insertDate = LocalDate.now();
        this.name = name;
        this.email = email;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getInsertDate() {
        return insertDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", insertDate=" + insertDate +
                '}';
    }
}
