package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.project.service.UserService;
import com.project.web.model.UserForm;
import com.project.web.model.UserLoginForm;

@Entity

@Table(name = "PROJECTTESTUSER", schema ="BISAMPLE" )
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String firstName;

	private String lastName;

	private Integer age;
	
	private String address;

	private String emailId;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void mapUserForm(UserForm userForm){

		setFirstName(userForm.getFirstName());
		setLastName(userForm.getLastName());
		setAge(userForm.getAge());
		setAddress(userForm.getAddress());
		setEmailId(userForm.getEmailId());
		setId(userForm.getId());
		
	}
	
	public void mapUserLoginForm(UserLoginForm userLoginForm){

		setFirstName(userLoginForm.getFirstName());
		//setLastName(userForm.getLastName());
		//setAge(userForm.getAge());
		//setAddress(userForm.getAddress());
		setEmailId(userLoginForm.getEmailId());
		
	}


}
