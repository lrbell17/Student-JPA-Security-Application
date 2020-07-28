package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudapp.StudentRepo;
import com.entity.Student;

@Service
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private StudentRepo studentRepo;
	
	
	@Override
	public void addStudent(Student stu) {
		
		studentRepo.save(stu);
		
	}

	// accounts for nulls
	public Student findByIdOptional(int id) {
		Optional<Student> opStu = studentRepo.findById(id);
		return opStu.isPresent() ? opStu.get() : null;
	}
	
	// CRUD Operations
	@Override
	public List<Student> findAll() {
		List<Student> list = new ArrayList<Student>();
		studentRepo.findAll().iterator().forEachRemaining(list::add);
		return list;
	}


	@Override
	public Student findStudent(int id) {
		
		return studentRepo.findByStuId(id);
	}


	@Override
	public Student findStudentByUsername(String name) {
	
		return studentRepo.findByUsername(name);
	}


	@Override
	public Student updateStudent(Student student) {
		Student stuFromDB = studentRepo.findByStuId(student.getStuId());
		stuFromDB.setFirstName(student.getFirstName());
		stuFromDB.setLastName(student.getLastName());
		stuFromDB.setUsername(student.getUsername());
		stuFromDB.setPassword(student.getPassword());
		stuFromDB.setGpa(student.getGpa());
		studentRepo.save(student);
		
		return stuFromDB;
	}
	

	@Override
	public void deleteStudentById(int id) {
		studentRepo.deleteByStuId(id);
		
	}

}
