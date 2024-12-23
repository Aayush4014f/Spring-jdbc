package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Starting my program");
    	
    	
    	//this context object we use when we are taking beans from xml file
//    	ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");

    	
    	
    	//this context object we use when we are taking beans from java class and annotations
    	ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
    	 StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
    	 Student student = new Student();
    	 
    	 
    	 //** for Adding objects into db
//    	 student.setId(496);
//    	 student.setName("Venkat raman");
//    	 student.setCity("Kerela");
//    	 int res = studentDao.insert(st udent);    	 
//    	 System.out.println("student added..."+res);
    	 
    	 
    	 
    //** for updating objects into db
//    	 student.setId(111);
//    	 student.setName("Sheela ki jawani");
//    	 student.setCity("dubai");
//    	 
//    	 int res = studentDao.change(student);
//    	 
//    	 System.out.println("student data updated..."+res);
    	 
    	 
//    	  for deleting objects into db
//    	 student.setId(111);
//    	 student.setName("Sheela ki jawani");
//    	 student.setCity("dubai");
//    	 int res = studentDao.delete(student);
//    	 System.out.println("student data removed..."+res);
    	
    	 
    	 //for retreiving single row
//    	 student =studentDao.getStudent(101);
//    	 System.out.println(student);
    	 
    	 
    	 //for retreiving Multiple rows
    	 List<Student> students=studentDao.getAllStudent();
    	 for(Student s :students) {
    		 System.out.println(s);
    	 }
    	
    	
    	
    	
      
    }
}
