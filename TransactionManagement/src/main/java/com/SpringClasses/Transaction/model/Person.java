package com.SpringClasses.Transaction.model;

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
	
	
	
	public Person(String firstName, String lastName) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
	
	}
	
	


	public Person() {
		super();
	}


	
	public Integer getPersonId() {
		return personId;
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
	
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName +  "]";
	}
	
	
	
	
	
	
}
