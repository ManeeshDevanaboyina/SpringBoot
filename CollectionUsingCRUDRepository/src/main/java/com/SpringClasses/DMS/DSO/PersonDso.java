package com.SpringClasses.DMS.DSO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SpringClasses.DMS.Database.Person;

@Repository
public interface PersonDso extends CrudRepository<Person,Integer> {
	
	//In this example we will see saveAll and findAllById
	
	//saveAll(Iterable<any Java Object>)
	
	//FindAllById(Iterable<PK>)

}
