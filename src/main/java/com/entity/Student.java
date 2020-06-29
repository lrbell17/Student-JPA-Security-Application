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
	
	@Column(name="STU_NAME") // optional annotation --> changes column name in DB
	private String stuName;
	
	private String stuAddress;
	
	
	public Student() {
		
	}
	
	public Student(int stuId, String stuName, String stuAddress) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuAddress = stuAddress;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuAddress() {
		return stuAddress;
	}

	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuAddress=" + stuAddress + "]";
	}
	
	
}
