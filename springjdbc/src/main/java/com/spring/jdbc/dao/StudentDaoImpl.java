package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

// This class implements all the methods defined in the StudentDao interface
@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Student student) {
        String query = "INSERT INTO student(id, name, city) VALUES(?, ?, ?)";
        int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return r;
    }
    
    @Override
	public int change(Student student) {
String query ="update student set name=?, city=? where id =?";
int r = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
System.out.println("Update query fired...");
return r;
		//this will return number of affected rows
	}
    
	@Override
	public int delete(Student student) {
		String query = "delete from student where id=?";
		int id=student.getId();
		int res = this.jdbcTemplate.update(query, student.getId());
		System.out.println("Object with id : "+id+" is deleted");
		return res;
	}

	//selecting student data
	@Override
	public Student getStudent(int studentId) {
		String query="select * from student where id=?";
		RowMapper<Student> rowMapper= new RowMapperImpl();//RowMapper is an interface so we created its object with the help of RowMapperImpl class
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		return student;
	}
	
	
	//for select all the data
	@Override
	public List<Student> getAllStudent() {
		String query="select * from student";
		List<Student> student = this.jdbcTemplate.query(query, new RowMapperImpl());
		return student;
	}

	
	
	
    // Getter for JdbcTemplate
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }


// Setter for JdbcTemplate (ensure name matches Spring configuration)
//    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


	



	
}
