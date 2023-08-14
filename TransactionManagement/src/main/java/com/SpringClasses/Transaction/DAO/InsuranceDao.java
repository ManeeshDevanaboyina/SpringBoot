package com.SpringClasses.Transaction.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.SpringClasses.Transaction.model.Insurance;
import com.SpringClasses.Transaction.model.Person;

@Repository
public interface InsuranceDao extends CrudRepository<Insurance,Integer> {
	
	//In this example we will see saveAll and findAllById
	
	//saveAll(Iterable<any Java Object>)
	
	//FindAllById(Iterable<PK>)

	
}
