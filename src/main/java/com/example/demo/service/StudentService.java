package com.example.demo.service;

import com.example.demo.database.StudentRepository;
import com.example.demo.model.CustomException;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService implements ServicesBehavior{

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void requestAddStudent(Student student) throws CustomException {
        Optional<Student> studentByEmail = this.studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()){
            throw new CustomException(new IllegalStateException("Email taken"), HttpStatus.BAD_REQUEST.value());
        }
        this.studentRepository.save(student);
    }

    @Override
    public Student findStudentByName(String name) throws CustomException {
        Optional<Student> student = this.studentRepository.findStudentByName(name);
        if(student.isEmpty()){
            throw new CustomException(new IllegalStateException("Student doesn't exist"), HttpStatus.BAD_REQUEST.value());
        }
        return student.get();
    }

    @Override
    public Student requestRemoveStudentByName(String name) throws CustomException {
        Optional<Student> student = studentRepository.findStudentByName(name);
        System.out.println(student.get());
        if(student.isEmpty()){
            throw new CustomException(new NoSuchElementException("Student doesn't exist"), HttpStatus.BAD_REQUEST.value());
        }
        studentRepository.removeStudentByName(name);
        return student.get();
    }

    @Override
    public Student requestRemoveStudentByID(Integer id) throws CustomException {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()){
            throw new CustomException(new NoSuchElementException("Student doesn't exist"), HttpStatus.BAD_REQUEST.value());
        }
        studentRepository.removeStudentByID(id);
        return student.get();
    }

    @Override
    public List<Student> requestGetAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student requestStudentByID(Integer id) throws CustomException {
        Optional<Student> result = studentRepository.findById(id);
        if(result.isEmpty()){
            throw new CustomException(new IllegalStateException("No record found"), HttpStatus.BAD_REQUEST.value());
        }
        return result.get();
    }
}
