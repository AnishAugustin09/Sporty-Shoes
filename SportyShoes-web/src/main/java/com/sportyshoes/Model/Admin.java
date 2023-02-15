package com.sportyshoes.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*This is the java POJO class but when you enter @Entity annotation it change to
Database entity class*/
@Entity 
@Table(name="Admin")
public class Admin {

	@Id
	private String emailId;
	@Column
	private String password;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}

	public Admin() {
		super();
	}
	
	
}
