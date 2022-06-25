package com.example.demo.service;

import com.example.demo.model.CustomException;
import com.example.demo.model.Student;

import java.util.List;

public interface ServicesBehavior {

    void requestAddStudent(Student student) throws CustomException;

    List<Student> requestGetAllStudents();

    Student requestStudentByID(Integer id) throws CustomException;

    Student findStudentByName(String name) throws CustomException;

    Student requestRemoveStudentByName(String name) throws CustomException;

    Student requestRemoveStudentByID(Integer id) throws CustomException;
}
