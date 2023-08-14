package com.SpringClasses.DMS.Database;


public class customType {
	
	private String firstName;
	private String lastName;
	public customType(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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
		return "customType [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	
	

}
