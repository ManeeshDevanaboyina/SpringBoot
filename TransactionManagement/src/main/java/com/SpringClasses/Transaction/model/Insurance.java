package com.SpringClasses.Transaction.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_insurance")

public class Insurance {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//Database only generate Primarykey. JPA will not do any other activity.
	@Column(name="person_id")
	private Integer personId;
	@Column(name="insurance_Name")
	private String insuranceName;
	@Column(name="Insurance_amount")
	private Integer insuranceAmount;
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getInsuranceName() {
		return insuranceName;
	}
	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	public Integer getInsuranceAmount() {
		return insuranceAmount;
	}
	public void setInsuranceAmount(Integer insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}
	public Insurance(Integer personId, String insuranceName, Integer insuranceAmount) {
		super();
		this.personId = personId;
		this.insuranceName = insuranceName;
		this.insuranceAmount = insuranceAmount;
	}
	
	
	public Insurance() {
		super();
	}
	
	@Override
	public String toString() {
		return "Insurance [personId=" + personId + ", insuranceName=" + insuranceName + ", insuranceAmount="
				+ insuranceAmount + "]";
	}
	
	
	
}
