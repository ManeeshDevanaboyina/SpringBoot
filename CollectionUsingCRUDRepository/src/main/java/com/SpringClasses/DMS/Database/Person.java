package com.SpringClasses.DMS.Database;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema="tbl_person")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//Database only generate Primarykey. JPA will not do any other activity.
	@Column(name="person_id")
	private Integer personId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="age")
	private Integer age;
	@Column(name="createdDate")
	private Date createdDate;
	@Column(name="email")
	private String email;
	public Integer getPersonId() {
		return personId;
	}
	
	
	public Person(String firstName, String lastName, Integer age, String email) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
	}
	
	


	public Person() {
		super();
	}


	public void setPersonId(Integer personId) {
		this.personId = personId;
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", createdDate=" + createdDate + ", email=" + email + "]";
	}
	
	
	
	
	
	
}
