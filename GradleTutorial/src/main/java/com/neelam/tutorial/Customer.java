package com.neelam.tutorial;

import org.springframework.stereotype.Component;

public class Customer {
	private Long id;
	private String firstName, lastName;

	public Customer() {
		this.id = 1L;
		this.firstName = "firstName";
		this.lastName = "lastName";
	}

	public Customer(long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
	}

	// getters & setters omitted for brevity
}