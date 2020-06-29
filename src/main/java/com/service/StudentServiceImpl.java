package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.StudentDao;
import com.entity.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	
	@Override
	public void addStudent(Student stu) {
		
		studentDao.addStudent(stu);
		
	}


	@Override
	public List<Student> findAll() {
		
		return studentDao.findAll();
	}


	@Override
	public Student findStudent(int id) {
		
		return studentDao.findStudent(id);
	}


	@Override
	public Student findStudentByName(String name) {
		// TODO Auto-generated method stub
		return studentDao.findStudentByName(name);
	}


	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.updateStudent(student);
	}


	@Override
	public void deleteStudentById(int id) {
		
		studentDao.deleteStudentById(id);
		
	}


	
}
