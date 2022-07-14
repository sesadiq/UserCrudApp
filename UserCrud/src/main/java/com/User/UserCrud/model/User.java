package com.User.UserCrud.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;





@Entity
@Table(name="users")

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message="First Name should not be empty")
	@Column(name="first_name")
	private String firstName;
	
	@NotEmpty(message="Last Name should not be empty")
	@Column(name="last_name")
	private String lastName;
	
	
	@Column(name="dob")
	@Temporal(TemporalType.DATE)
	@Past
	private Date dob;
	
	@NotEmpty(message = "Email should be unique!")
	@Column(name="email", unique = true)
	@Email(message ="Enter a valid email Address")
	private String emailId;
	
	
	
	public User() {
		super();
	}
	
	public User(long id, String firstName, String lastName,  Date dob, String emailId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.emailId = emailId;
	}
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	 	
	
	
	
	
	
}
 