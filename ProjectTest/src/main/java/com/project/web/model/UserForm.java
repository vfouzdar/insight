package com.project.web.model;



import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.project.entity.User;

public class UserForm {

	private long id;

	@NotNull
    @Size(min=2, max=30)
    private String firstName;
    
    @NotNull
    @Size(min=2, max=30)
    private String lastName;

    @NotNull
    @Min(18)
    private Integer age;
    
    @NotNull
    private String address;
    
    @NotEmpty
    @Email
    private String emailId;
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "UserForm [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", address=" + address
				+ ", emailId=" + emailId + "]";
	}

    
	public void mapUser(User user){

		setFirstName(user.getFirstName());
		setLastName(user.getLastName());
		setAge(user.getAge());
		setAddress(user.getAddress());
		setEmailId(user.getEmailId());
	}

}

