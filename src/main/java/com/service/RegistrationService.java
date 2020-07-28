package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import com.entity.Student;
import com.entity.UserRegistration;

@Service
public class RegistrationService {

	@Autowired 
	JdbcUserDetailsManager jdbcUserDetailsManager;
	
	@Autowired
	StudentService studentService;
	
	// save uname, password, and role into DB
	public void addUser(Student stu) {
		
		String uName = stu.getUsername();
		String pass = "{noop}" + stu.getPassword();
		
		UserRegistration userRegistration = new UserRegistration(uName, pass);
		
		// authorities to be granted
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
				authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
				
		User user = new User(userRegistration.getUsername(), userRegistration.getPassword(), authorities);
		jdbcUserDetailsManager.createUser(user);
	}
		
	public void removeUser(int id) {

		
		Student student = studentService.findStudent(id);
		String username = student.getUsername();
		jdbcUserDetailsManager.deleteUser(username);;
	}
	
	// update username and password
	public void updateUser(Student student) {
		
		removeUser(student.getStuId());
		addUser(student);
		
	}
	
	// Get role of current user (USER/ADMIN)
	public String getRole() {
		
		SecurityContext context = SecurityContextHolder.getContext();
		
		Authentication authentication = context.getAuthentication();
		
		for (GrantedAuthority auth : authentication.getAuthorities()) {
			
			if (auth.getAuthority().equals("ROLE_ADMIN")) {
				return "ADMIN";
			}
			
		}
		
		return "USER";
	}
	
}



