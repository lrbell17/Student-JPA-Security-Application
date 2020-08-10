package com.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Student;
import com.service.EncryptDecryptService;
import com.service.FileWriterService;
import com.service.RegistrationService;
import com.service.StudentService;


@Controller
public class StudentController {

	// Services ------------------------------
	@Autowired
	private StudentService studentService;
	
	@Autowired 
	private FileWriterService fileWriterService;
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private EncryptDecryptService encryptDecryptService;


	// Mapping ----------------------------------
	@GetMapping("/register")
	public String showRegister(ModelMap model) {

		model.addAttribute("student", new Student());
		return "register";
	}
	
	
	@GetMapping("/")
	public String showDefault(ModelMap model) {
		model.put("role", registrationService.getRole());
		model.put("students", studentService.findAll());
		return "findall";
	}
	
	@GetMapping("/login")
    public String login(ModelMap model, String error, String logout) {
        if (error != null)
            model.put("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.put("msg", "You have been logged out successfully.");

        return "login";
    }
	
	@GetMapping("/welcome")
	public String getWelcome(ModelMap model) {
		
		Student stu = new Student(0, "", null, "", "", 0.0);

		model.put("student", stu);
		
		return "welcome";
	}
	
	@PostMapping("/welcome")
	public String showWelcome(Student stu, ModelMap model) {

		boolean match = false;
		for (Student s : studentService.findAll()) {
			if (s.getUsername().equals(stu.getUsername())) {
				match = true;
			}
		}
		if (match || stu.getUsername().equals("admin")) {
			model.put("errorMsg", "This username already exists, try again!");
			return "register";
		}
		
		// Encrypt Password:
		String encryptedPassword = encryptDecryptService.encryptString(stu.getPassword());
		stu.setPassword(encryptedPassword);

		// add to student to Student and Registration Databases
		registrationService.addUser(stu);
		studentService.addStudent(stu);
		
		model.put("student", stu);
		
		return "welcome";
	}
	
	
	// Find All:
	@GetMapping("/findall")
	public String showStudents(ModelMap model) {
		
		model.put("role", registrationService.getRole());
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
		
		// handling invalid id
		if (stu == null) {
			model.put("errorMsg", "Couldn't find a student with this id");
			return "findbyid";
		}
		
		model.put("role", registrationService.getRole());
		model.put("student", stu);
		return "welcome";
		
	}
	
	// Find Student by name:
	@GetMapping("/findbyuname")
	public String findByName() {
		return "findbyname";
	}
	
	@PostMapping("/findbyuname")
	public String findUserByUsername(ModelMap model, @RequestParam String uname) {
		Student stu = studentService.findStudentByUsername(uname);
		
		// handling invalid username
		if (stu == null) {
			model.put("errorMsg", "Couldn't find a student with this id");
			return "findbyname";
		}
		
		model.put("role", registrationService.getRole());
		model.put("student", stu);
		return "welcome";
	}
	
	// Update:
	@GetMapping("/update")
	public String update(@RequestParam int id, ModelMap model) {
		
		model.put("id", id);
		
		Student oldStudent = studentService.findStudent(id);
		
		model.put("oldStudent", oldStudent);
		
		return "update";
	}
	
	@PostMapping("/update")
	public String updateUser(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String username, @RequestParam String password, @RequestParam double gpa, ModelMap model) {
		
		// Encrypt Password
		String encryptedPassword = encryptDecryptService.encryptString(password);
		
		Student student = new Student(id, username, encryptedPassword, firstName, lastName, gpa);
		
		model.put("student", student);
		try {
			registrationService.updateUser(student); // update Registration DB
			studentService.updateStudent(student); // update Student DB
		
			model.put("successMessage", "Student updated successfully!");
		} catch (Exception e) {
			model.put("errorMessage", "Unable to update user!");
			e.printStackTrace();
		}

		model.put("role", registrationService.getRole());
		model.put("students", studentService.findAll());
		return "findall";
	}
	
	//Delete:
	@GetMapping("/delete")
	public String deleteUser(@RequestParam int id, ModelMap model) {
		
		try {
			registrationService.removeUser(id); // remove from Registration DB
			studentService.deleteStudentById(id); // remove from student DB
			
			model.put("successMessage", "Student deleted successfully!");
		} catch (Exception e) {
			model.put("errorMessage", "Unable to delete user!");
			e.printStackTrace();
		}
	
		model.put("role", registrationService.getRole());
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

		// Check for correct format
		if (file.length == 2 && file[1].equals("txt")) {
			
			try {
				
				fileWriterService.writeFile(filename);
				model.put("role", registrationService.getRole());
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
	
	// Error page:
	public String showError() {
		return "error";
	}
	
}
