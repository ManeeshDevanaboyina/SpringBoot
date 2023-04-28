package com.SpringClasses.DMS;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.SpringClasses.DMS.Database.Person;
import com.SpringClasses.DMS.ServiceLayer.PersonServiceLayer;

@SpringBootApplication
public class CollectionUsingCrudRepositoryApplication implements CommandLineRunner{

	
	@Autowired
	private PersonServiceLayer personService;
	public static void main(String[] args) {
		SpringApplication.run(CollectionUsingCrudRepositoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Iterable<Person> list=personService.createPersonDetails(getPersonDetails());
	
		
		
	}
	public List<Person>  getPersonDetails(){
		List<Person> person= Arrays.asList(
				new Person("Manee","Devana",20,"maneesh.d@gmail.com"),
				new Person("Manee2","Devana2",21,"maneesh.d1@gmail.com"),
				new Person("Manee3","Devana3",22,"maneesh.d2@gmail.com"),
				new Person("Manee4","Devana4",23,"maneesh.d3@gmail.com"),
				new Person("Manee5","Devana5",24,"maneesh.d4@gmail.com"),
				new Person("Manee6","Devana6",25,"maneesh.d5@gmail.com"),
				new Person("Manee7","Devana7",26,"maneesh.d6@gmail.com"),
				new Person("Manee8","Devana8",27,"maneesh.d7@gmail.com"),
				new Person("Manee9","Devana9",28,"maneesh.d8@gmail.com"),
				new Person("Manee10","Devana10",29,"maneesh.d9@gmail.com"),
				new Person("Manee11","Devana11",30,"maneesh.d10@gmail.com"));
		
		return person;
	}
	

}
