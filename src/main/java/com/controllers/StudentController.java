package com.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Student;
import com.service.FileWriterService;
import com.service.StudentService;


@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired 
	FileWriterService fileWriterService;
	
	@GetMapping("/register")
	public String showRegister(ModelMap model) {
		
		Student stu = new Student();
		model.addAttribute("student", stu);
		return "register";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@GetMapping("/welcome")
	public String getWelcome(ModelMap model) {
		
		Student stu = new Student(0, "", "", "", "", 0.0);

		model.put("student", stu);
		
		return "welcome";
	}
	
	@PostMapping("/welcome")
	public String showWelcome(Student stu, ModelMap model) {
		
		// Check for duplicate ID's
		List<Student> stuList = studentService.findAll();
		for (Student student : stuList) {
			if (student.getStuId() == stu.getStuId()) {
				model.put("errorMessage", "This student ID already exists");
				return("register");
			}
		}
		
		model.put("student", stu);
		
		studentService.addStudent(stu);
		
		return "welcome";
	}
	
	
	// Find All:
	@GetMapping("/findall")
	public String showStudents(ModelMap model) {
		
		model.put("students", studentService.findAll());
		return "findall";
	}
	
	// Find By Student ID:
	@GetMapping("/findbyid")
	public String findById() {
		
		return "findbyid";
	}
	
	@PostMapping("/findbyid")
	public String findUserById(ModelMap model, @RequestParam int id) {
		Student stu = studentService.findStudent(id);
		model.put("student", stu);
		return "welcome";
		
	}
	
	// Find Student by name:
	@GetMapping("/findbyname")
	public String findByName() {
		return "findbyname";
	}
	
	@PostMapping("/findbyname")
	public String findUserByName(ModelMap model, @RequestParam String name) {
		Student stu = studentService.findStudentByName(name);
		model.put("student", stu);
		return "welcome";
	}
	
	// Update:
	@GetMapping("/update")
	public String update(@RequestParam int id, ModelMap model) {
		
		model.put("id", id);
		
		return "update";
	}
	
	@PostMapping("/update")
	public String updateUser(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String username, @RequestParam String password, @RequestParam double gpa, ModelMap model) {
		
		Student student = new Student(id, username, password, firstName, lastName, gpa);
		
		model.put("student", student);
		try {
			studentService.updateStudent(student);
			model.put("successMessage", "Student updated successfully!");
		} catch (Exception e) {
			model.put("errorMessage", "Unable to update user!");
			e.printStackTrace();
		}

		model.put("students", studentService.findAll());
		return "findall";
	}
	
	//Delete:
	@GetMapping("/delete")
	public String deleteUser(@RequestParam int id, ModelMap model) {
		
		try {
			studentService.deleteStudentById(id);
			model.put("successMessage", "Student deleted successfully!");
		} catch (Exception e) {
			model.put("errorMessage", "Unable to delete user!");
			e.printStackTrace();
		}
	
		model.put("students", studentService.findAll());
		return "findall";
	}
	
	// Saving table to a .txt file
	@GetMapping("/filesave")
	public String sentToFileSave(ModelMap model) {
		
		return "savefile";
	}
	
	@PostMapping("/filesave")
	public String saveFile(@RequestParam String filename, ModelMap model) {

		String[] file = filename.split("\\.");

		if (file.length == 2 && file[1].equals("txt")) {
			
			try {
				
				fileWriterService.writeFile(filename);
				model.put("successMessage", "File: " + filename  + " saved sucessfully");
				return "findall";
				
			} catch (IOException e) {
				model.put("errorMessage", "There was an error saving the file");
				return "saveFile";
			}
			
		}
		
		else {
			model.put("errorMessage", "Invalid file name");
			return "savefile";
		}
		
	
	}
	
}
