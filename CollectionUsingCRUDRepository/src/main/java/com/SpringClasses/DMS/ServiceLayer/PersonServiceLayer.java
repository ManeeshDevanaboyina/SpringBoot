package com.SpringClasses.DMS.ServiceLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringClasses.DMS.DSO.PersonDso;
import com.SpringClasses.DMS.Database.Person;

@Service
public class PersonServiceLayer {

	@Autowired
	private PersonDso personDso;
	
	public Iterable<Person> getPersonDetails(List<Integer> personId){
		return personDso.findAllById(personId);
		
	
	}
	
	public Iterable<Person> createPersonDetails(List<Person> Person){
		return personDso.saveAll(Person);
	}
	
	//findAllById= select * from tbl_person where person_id in (1,2,3,4,5,6)
	
	
	
	
}
