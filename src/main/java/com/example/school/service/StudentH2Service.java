package com.example.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.school.model.*;
import com.example.school.repository.StudentRepository;

@Service
public class StudentH2Service implements StudentRepository {
    @Autowired
    JdbcTemplate db;

    @Override
    public ArrayList<Student> addStudent() {
        List<Student> studentList = db.query("SELECT * FROM STUDENT", new StudentRowMapper());
        ArrayList<Student> students = new ArrayList<>(studentList);
        return students;
    }

    @Override
    public Student getStudentById(int studentId) {
        try {
            Student student = db.queryForObject("SELECT * FROM STUDENT WHERE studentId = ?", new StudentRowMapper(),
                    studentId);
            return student;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Student addStudent(Student student){
        db.update("INSERT INTO STUDENT(studentName, gender, standard) values (?,?,?)", student.getStudentName(), student.getGender(), student.getStandard());
        Student savedStudent = db.queryForObject("SELECT * FROM STUDENT WHERE studentName = ? and gender = ? and standard = ?", new StudentRowMapper(), student.getStudentName(), student.getGender(), student.getStandard());
        return savedStudent;

    }

}
