package com.example.demo.database;

import com.example.demo.model.Order;
import com.example.demo.model.Student;
import com.example.demo.model.StudentProperty;


import java.util.List;

public class StudentDatabase implements DatabaseBehavior{

    @Override
    public void insertStudent(Student student) {

    }

    @Override
    public List<Student> selectAllStudents() {
        return null;
    }

    @Override
    public Student queryStudentByID(Integer id) {
        return null;
    }

    @Override
    public boolean deleteStudentByID(Integer id) {
        return false;
    }

    @Override
    public List<Student> queryStudentWithOrder(StudentProperty studentProperty, Order order) {
        return null;
    }
}
