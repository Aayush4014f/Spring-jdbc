package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class RowMapperImpl implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();//this object we will return
		student.setId(rs.getInt(1));//here 1 is column number of id
		student.setName(rs.getString(2));//here 2 is column number of name
		student.setCity(rs.getString(3));//here 3 is column number of city
		
		
		return student;
	}

}
