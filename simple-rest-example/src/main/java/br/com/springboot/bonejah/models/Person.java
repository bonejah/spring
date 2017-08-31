package br.com.springboot.bonejah.models;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 3342177217432717637L;
	private Long id;
	private String firstName;
	private String lastName;
	private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
