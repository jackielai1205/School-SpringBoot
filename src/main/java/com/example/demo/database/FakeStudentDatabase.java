package com.example.demo.database;


import com.example.demo.model.Order;
import com.example.demo.model.Student;
import com.example.demo.model.StudentProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class FakeStudentDatabase implements DatabaseBehavior{

    public List<Student> list;

    @Autowired
    FakeStudentDatabase(){
        list = new ArrayList<>();
        list.add(new Student("Ishihara", "kawai@gmail.com"));
        list.add(new Student("Enna", "Enna@hotmail.com"));
        list.add(new Student("Mumei", "Mumei@yahoo.com.hk"));
    }

    @Override
    public void insertStudent(Student student) {
        list.add(student);
    }

    @Override
    public List<Student> selectAllStudents() {
        return list;
    }

    @Override
    public Student queryStudentByID(Integer id) {
        for(Student student : list){
            if(student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }

    @Override
    public boolean deleteStudentByID(Integer id) {
        for(int x = 0; x < this.list.size(); x++){
            Student student = this.list.get(x);
            if(student.getId().equals(id)){
                list.remove(x);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Student> queryStudentWithOrder(StudentProperty studentProperty, Order order) {
        Student[] clonedList = new Student[list.size()];
        list.toArray(clonedList);
        Student temp;
        switch (studentProperty){
            case ID:
                for(int x = 0; x < clonedList.length; x++){
                    for(int y = x + 1; y < clonedList.length; y++){
                        if(order.equals(Order.ASC)){
                            if(clonedList[x].getId() > clonedList[y].getId()){
                                temp = clonedList[x];
                                clonedList[x] = clonedList[y];
                                clonedList[y] = temp;
                            }
                        }else if (order.equals(Order.DESC)){
                            if(clonedList[x].getId() < clonedList[y].getId()){
                                temp = clonedList[x];
                                clonedList[x] = clonedList[y];
                                clonedList[y] = temp;
                            }
                        }
                    }
                }
        }
        return Arrays.asList(clonedList);
    }
}
