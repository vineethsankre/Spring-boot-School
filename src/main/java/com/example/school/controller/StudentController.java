package com.example.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.school.model.Student;
import com.example.school.service.StudentH2Service;

@RestController
public class StudentController {
    @Autowired
    StudentH2Service studentH2Service;

    @GetMapping("/students")
    public ArrayList<Student> getAllStudents() {
        return studentH2Service.getAllStudents();
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return studentH2Service.addStudent(student);
    }

    @PostMapping("/students/bulk")
    public String addMultipleStudents(@RequestBody List<Student> students) {
        return studentH2Service.addMultipleStudents(students);
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable("studentId") int studentId) {
        return studentH2Service.getStudentById(studentId);
    }

    @PutMapping("/students/{studentId}")
    public Student updateStudent(@PathVariable int studentId, @RequestBody Student student) {
        return studentH2Service.updateStudent(studentId, student);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable int studentId) {
        studentH2Service.deleteStudent(studentId);
    }
}
