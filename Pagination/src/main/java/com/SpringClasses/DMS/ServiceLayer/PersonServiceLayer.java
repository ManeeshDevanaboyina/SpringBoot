package com.SpringClasses.DMS.ServiceLayer;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.SpringClasses.DMS.DSO.BookDSO;
import com.SpringClasses.DMS.DSO.PersonDso;
import com.SpringClasses.DMS.Database.Book;
import com.SpringClasses.DMS.Database.Person;
import com.SpringClasses.DMS.Database.customType;

@Service
public class PersonServiceLayer {

	@Autowired
	private PersonDso personDso;
	
	@Autowired
	private BookDSO bookDso;
	
	public Iterable<Book> findByBookName(String book1){
		return bookDso.findByBookName(book1);
	}
	
	public Iterable<Book> findAllBooks(){
		return bookDso.findAll();
	}
	
	public Iterable<Book> saveAllBooks(Iterable<Book> bookList){
		return bookDso.saveAll(bookList);
	}
	
	public Iterable<Person> getPersonDetails(List<Integer> personId){
		return personDso.findAllById(personId);
		//findAllById= select * from tbl_person where person_id in (1,2,3,4,5,6)
	
	}
	
	public Iterable<Person> createPersonDetails(List<Person> Person){
		return personDso.saveAll(Person);
		
	}
	
	public List<Person> findByfirstName(String firstName){
		return personDso.findByfirstName(firstName);
	}
	
	public Person findByfirstNameAndLastName(String firstName,String lastName) {
		return personDso.findByFirstNameAndLastName(firstName,lastName);
		
	}
	
	public List<Person> findBylastNameOrfirstName(String lastName,String firstName){
		return personDso.findByLastNameOrFirstName(lastName,firstName);
		
	}

	public List<Person> findByAgeBetween(Integer age1, Integer age2){
		return personDso.findByAgeBetween(age1,age2);
		
	}

	public List<Person> findByAgeLessThan(Integer age){
		return personDso.findByAgeLessThan(age);
	}

	public List<Person> findByLastNameOrderByCreatedDateDesc(String LastName){
		return personDso.findByLastNameOrderByCreatedDateDesc(LastName);
		
	}
	
	public List<Person> findByFirstNameLike(String firstName){
		return personDso.findByFirstNameLike(firstName);
		
	}
	
	public List<Person> giveDataByName(String firstName){
		return personDso.giveDataByName(firstName);
	}
	
	public Iterable<Book> retrieveBooksByName(String bookName){
		return bookDso.retrieveBooksByName(bookName);
	}
	
	public List<customType> giveFewColumns(String firstName){
		return personDso.giveFewColumns(firstName);
	}
	
	public List<Person> findByLastName(String lastName,PageRequest pageable){
		return personDso.findByLastName(lastName, pageable);
	}
	
	
	
	
	
	
	
}
