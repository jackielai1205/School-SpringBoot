package com.example.demo.database;

import com.example.demo.model.Order;
import com.example.demo.model.Student;
import com.example.demo.model.StudentProperty;

import java.util.List;

public interface DatabaseBehavior {

    public void insertStudent(Student student);

    public List<Student> selectAllStudents();

    public Student queryStudentByID(Integer id);

    public boolean deleteStudentByID(Integer id);

    public List<Student> queryStudentWithOrder(StudentProperty studentProperty, Order order);
}
