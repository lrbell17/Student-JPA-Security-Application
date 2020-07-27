package com.crudapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Student;

// needs to extend class w/ crud operations

// ---> must pass in name of entity class and data type of PK

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer>{

	public Student findByStuId(int id); // Magic!! just math w/ attribute in bean class
	
	public Student findByFirstName(String name);
	
	public void deleteByStuId(int id);
}
