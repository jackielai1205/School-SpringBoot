package com.example.demo.controller;


import com.example.demo.model.*;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    //Get Data
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return service.requestGetAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudentByID(@PathVariable Integer id) throws CustomException {
        return service.requestStudentByID(id);
    }

    @GetMapping("/student/{name}")
    public Student getStudentByName(@PathVariable String name) throws CustomException {
        return service.findStudentByName(name);
    }

    @PostMapping("/students")
    public void addNewStudent(@RequestBody Student student) throws CustomException {
        service.requestAddStudent(student);
    }

    //Remove Data
    @DeleteMapping("/student/name/{name}")
    public Student removeStudentByName(@PathVariable String name) throws CustomException {
        return service.requestRemoveStudentByName(name);
    }

    @DeleteMapping("/student/id/{id}")
    public Student removeStudentByID(@PathVariable Integer id) throws CustomException {
        return service.requestRemoveStudentByID(id);
    }

    @ExceptionHandler({CustomException.class})
    public ResponseEntity<Object> exceptionHandle(CustomException exception){
      return new ResponseEntity<Object>(new ErrorResponse(exception, exception.getHttpStatus()), new HttpHeaders(),exception.getHttpStatus());
    }
}
