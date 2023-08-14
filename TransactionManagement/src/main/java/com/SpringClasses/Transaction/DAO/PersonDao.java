package com.SpringClasses.Transaction.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SpringClasses.Transaction.model.Person;

@Repository
public interface PersonDao extends CrudRepository<Person,Integer> {
	
	//In this example we will see saveAll and findAllById
	
	//saveAll(Iterable<any Java Object>)
	
	//FindAllById(Iterable<PK>)

	
	

}
