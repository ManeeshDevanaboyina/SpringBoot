package com.SpringClasses.DMS.ServiceLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringClasses.Transaction.DAO.PersonDao;
import com.SpringClasses.Transaction.model.Person;

@Service
public class PersonServiceLayer {

	@Autowired
	private PersonDao personDso;
	
	

	
	public Person createPersonDetails(Person person){
		return personDso.save(person);
	}
	
	//findAllById= select * from tbl_person where person_id in (1,2,3,4,5,6)
	
	
	
	
}
