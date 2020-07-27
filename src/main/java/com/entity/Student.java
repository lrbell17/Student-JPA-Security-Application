package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STU_DATA")
public class Student {

	
	
	@Id // treated as primary key
	private int stuId;
	
	@Column
	private String password;
	
	@Column
	private String firstName;
	
	@Column 
	private String lastName;
	
	@Column
	private double gpa;
	
	
	public Student() {
		
	}


	public Student(int stuId, String password, String firstName, String lastName, double gpa) {
		super();
		this.stuId = stuId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gpa = gpa;
	}


	public int getStuId() {
		return stuId;
	}


	public void setStuId(int stuId) {
		this.stuId = stuId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public double getGpa() {
		return gpa;
	}


	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	
	
	
	
	
}
