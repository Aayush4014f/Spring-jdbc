package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entities.Student;

//it will contain all the methods that will perform operations with database
public interface StudentDao {
public int insert(Student student);
public int change(Student student);
public int delete(Student student);

public Student getStudent(int studentId);
public List<Student> getAllStudent();
}
