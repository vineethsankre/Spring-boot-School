package com.example.school.repository;

import com.example.school.model.*;
import java.util.*;

public interface StudentRepository {
    ArrayList<Student> getAllStudents();

    Student getStudentById(int studentId);

    Student addStudent(Student student);

    String addMultipleStudents(List<Student> students);

    Student updateStudent(int studentId, Student student);

    void deleteStudent(int studentId);
}