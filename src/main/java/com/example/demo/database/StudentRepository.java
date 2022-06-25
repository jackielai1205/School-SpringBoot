package com.example.demo.database;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s.email FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

    @Query("SELECT s FROM Student s WHERE s.name = ?1")
    Optional<Student> findStudentByName(String name);

    @Modifying
    @Query("DELETE FROM Student s WHERE s.name = ?1")
    void removeStudentByName(String name);

    @Modifying
    @Query("DELETE FROM Student s WHERE s.id = ?1")
    void removeStudentByID(Integer id);
}
