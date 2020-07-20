package com.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Student;

@Service
public class FileWriterService {

	@Autowired
	StudentService studentService;
	
	public void writeFile(String fileName) throws IOException {
		
		File file = new File(fileName);
		FileWriter out= new FileWriter(file, false);
		BufferedWriter writer =  new BufferedWriter(out); 
		
		// Get list of students
		List<Student> stuList = studentService.findAll();
		
		// add to file
		for (Student stu : stuList) {
			writer.write(stu.toString() + "\n");
		}
		
		writer.close();

	}
	
	
}
