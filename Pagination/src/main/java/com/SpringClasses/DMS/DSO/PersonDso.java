package com.SpringClasses.DMS.DSO;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SpringClasses.DMS.Database.Person;
import com.SpringClasses.DMS.Database.customType;

@Repository
public interface PersonDso extends JpaRepository<Person,Integer> {
	
	//In this example we will see saveAll and findAllById
	
	//saveAll(Iterable<any Java Object>)
	
	//FindAllById(Iterable<PK>)
	
	//Derived methods
		
		public List<Person> findByfirstName(String firstName);
		//select * from tbl_person where first_name=firstName
		public Person findByFirstNameAndLastName(String firstName,String lastName);
		//select * from tbl_person where first_name=firstName AND last_name=lastName
		public List<Person> findByLastNameOrFirstName(String lastName,String firstName);
		//select * from tbl_person where last_name=lastName OR first_name=firstName
		public List<Person> findByAgeBetween(Integer age1, Integer age2);
		//select * from tbl_person where Age BETWEEN age1 AND age2
		public List<Person> findByAgeLessThan(Integer age);
		//select * from tbl_person where age<age
		public List<Person> findByLastNameOrderByCreatedDateDesc(String LastName);
		//select * from tbl_person where last_name=LastName order by createdDate Desc
		public List<Person> findByFirstNameLike(String firstName);
		//select * from tbl_person where first_name LIKE '%firstName%'
		//Developer need to write percentage symbol manually
		public List<Person> findByCreatedDateBetween(Date startDate,Date endDate);
		
		
		//Named Query Section
		//Abstract method at DAO Layer and implementation at Model Layer.
		public  List<Person> giveDataByName(String firstName);
		
		public  List<customType> giveFewColumns(String firstName);
		
		
		// Query and Native query took screen shot
		
		//Pagination
		
		public List<Person> findByLastName(String lastName,Pageable pageable);//Abstract method
		
		//JPA repo will write implementation for pagination
		//Developer need to set offsetand Size values only

}
