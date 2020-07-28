package com.dao;

import java.util.List;

import com.entity.Student;

public interface StudentDao {

	public void addStudent(Student stu);
	
	public List<Student> findAll();
	
	public Student findStudent(int id);
	
	public Student findStudentByUsername(String name);
	
	public Student updateStudent(Student student);
	
	public void deleteStudentById(int id);
}
