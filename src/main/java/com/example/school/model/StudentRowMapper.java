package com.example.school.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.school.service.*;
import com.example.school.model.*;

import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<Student>{
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException{
        return Student(
            rs.getInt("studentId"),
            rs.getString("studentName"),
            rs.getString("gender"),
            rs.getString("standard")
        );
    }

}
