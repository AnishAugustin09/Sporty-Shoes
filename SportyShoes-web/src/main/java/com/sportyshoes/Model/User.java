package com.sportyshoes.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private int id;
	@Column(name="name")
	private String Name;
	@Column(name="Email")
	private String email;
	@Column
	private String Gender;
	@Column
	private String Address;
	public User(int id, String name, String email, String gender, String address) {
		super();
		this.id = id;
		Name = name;
		this.email = email;
		Gender = gender;
		Address = address;
	}
	public User() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", Name=" + Name + ", email=" + email + ", Gender=" + Gender + ", Address=" + Address
				+ "]";
	}
	
	
}

