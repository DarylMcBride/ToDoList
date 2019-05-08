package com.qa.boot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@NotNull
	private String fName;

	@NotNull
	private String lName;

	@NotNull
	@Email
	private String email;

	@NotNull
	private String phone;

	@NotNull
	private String password;
	
	private String username;

	public Users(Integer userId, String fName, String lName, String email, String phone, String password, String usernme) {
		this.setUserId(userId);
		this.setfName(fName);
		this.setlName(lName);
		this.setEmail(email);
		this.setPhone(phone);
		this.setPassword(password);
		this.setUsername(usernme);
	}

	public Users() {

	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		if (fName.length() > 20) {
			this.fName = "invalid";
		}
		this.fName = fName;
	}

	public String getlName() {
		if (lName.length() > 30) {
			this.lName = "invalid";
		}
		return lName;
	}

	public void setlName(String lname) {
		lName = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (!email.contains("@") || !email.contains(".co")) {
			System.out.println("invalid email");
		}
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (phone.length() > 15) {
			this.phone = "unset";
		}
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
