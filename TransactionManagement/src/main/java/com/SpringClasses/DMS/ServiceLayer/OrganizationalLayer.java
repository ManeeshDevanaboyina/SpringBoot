package com.SpringClasses.DMS.ServiceLayer;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.SpringClasses.Transaction.model.Insurance;
import com.SpringClasses.Transaction.model.Person;

import jakarta.transaction.Transactional;

@Service
public class OrganizationalLayer {

	@Autowired
	private PersonServiceLayer personService;
	
	@Autowired
	private InsuranceServiceLayer insurancService;
	
	
	@Transactional
	public void onBoardEmployee(Person person, Insurance insurance) {
		
		personService.createPersonDetails(person);
		
		if(insurance.getInsuranceName().length()<4) {
			throw new RuntimeErrorException(null,"Error in insurance");
		}
		
		insurancService.createInsurance(insurance);
	}
	
	
}
