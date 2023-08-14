package com.SpringClasses.DMS;

import java.util.Arrays;
import com.SpringClasses.DMS.Database.*;
import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.EnableAsync;

import com.SpringClasses.DMS.ServiceLayer.PersonServiceLayer;

@SpringBootApplication
@EnableAsync
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
		//findByfirstName("Manee2");
		//findByfirstNameAndLastName("kk","mm");
		//findByFirstNameLike("%Manuuuu%");
		//As said percentage need to write manually.
		//saveBookPublishers();
		//findByBookName();
		//giveDataByName();
		//retrieveBooksByName();
		//giveFewColumns();
		pageableMethod();
	}
	
	
	public void pageableMethod() {
		
		System.out.println("Pagination without sorting");
		
		
		Iterable<Person> list2=personService.findByLastName("Devana2", PageRequest.of(0, 5));
		
		System.out.println("Pagination with sorting");
		
		Iterable<Person> list3=personService.findByLastName("Devana2", PageRequest.of(0, 2,Direction.ASC,"firstName"));
		//Select * from Person where last_name="Devana2" and ROWNUMBER>=0 AND ROWNUMBER<=2 orderby firstName ASC;
		
		
		list2.forEach(System.out::println);		
		
	}
	
	public void giveDataByName() {
		Iterable<Person> list2=personService.giveDataByName("kk");
		
		for(Person person1:list2) 
			System.out.println(person1.toString());
	}

	
	public void retrieveBooksByName() {
		Iterable<Book> bookList=personService.retrieveBooksByName("Book2");
		for(Book book:bookList) {
			System.out.println(book.toString());
		}
	}
	
	public void giveFewColumns() {
		Iterable<customType> list2=personService.giveFewColumns("kk");
		
		for(customType person1:list2) 
			System.out.println(person1.toString());
	}
	
	public void findByBookName() {
		Iterable<Book> bookList=personService.findByBookName("Book2");
		for(Book book:bookList) {
			System.out.println(book.toString());
		}
	}
	
	public void findByfirstName(String firstName){
		Iterable<Person> list2=personService.findByfirstName(firstName);
		
		for(Person person1:list2) 
			System.out.println(person1.toString());
		
		
	}
	public void findByfirstNameAndLastName(String firstName,String LastName){
		Person list2=personService.findByfirstNameAndLastName(firstName,LastName);
		
		
			System.out.println(list2.toString());
		
		
	}
	
	public void findByFirstNameLike(String firstName){
		Iterable<Person> list2=personService.findByFirstNameLike(firstName);
		for(Person person1:list2) 
			System.out.println(person1.toString());
		
	}
	
	public void saveBookPublishers() {
		Publisher p1=new Publisher("Abdul Kalam");
		Publisher p2=new Publisher("Stephen Kovey");
		Publisher p3=new Publisher("Chethan Bhagat");
		Publisher p4=new Publisher("Author2");
		Publisher p5=new Publisher("Author3");
		Publisher p6=new Publisher("Nazir");
		
		Book b1=new Book("Wings of Fire",new HashSet<>(Arrays.asList(p1)));
		Book b2=new Book("SevenHabits",new HashSet<>(Arrays.asList(p2)));
		Book b3=new Book("Two States",new HashSet<>(Arrays.asList(p3)));
		
		//One to Many relationship with the Book to Publisher
		Book b4=new Book("Book2",new HashSet<>(Arrays.asList(p4,p5)));
		//One to Many relationship with the Publisher to Book
		Book b5=new Book("Book5",new HashSet<>(Arrays.asList(p6)));
		Book b6=new Book("Book6",new HashSet<>(Arrays.asList(p6)));
		
		
		
		personService.saveAllBooks(Arrays.asList(b1,b2,b3,b4,b5,b6));
		//System.out.print(personService.findAllBooks());
		
		/*for(Book books:personService.findAllBooks()) {
			System.out.println(books.toString());
		}*/
	}
	
	public List<Person>  getPersonDetails(){
		List<Person> person= Arrays.asList(
				new Person("Manee","Dna",28,"maneesh.d@gmail.com"),
				new Person("Manee2","Devana2",29,"maneesh.d1@gmail.com"),
				new Person("Manee3","Dana3",31,"maneesh.d2@gmail.com"),
				new Person("Manee4","Devana4",3,"maneesh.d3@gmail.com"),
				new Person("Manee5","Devana5",4,"maneesh.d4@gmail.com"),
				new Person("Manee6","Devana6",5,"maneesh.d5@gmail.com"),
				new Person("Manee7","Devana7",36,"maneesh.d6@gmail.com"),
				new Person("Manee8","Devana8",97,"maneesh.d7@gmail.com"),
				new Person("Manee9","Devana9",1,"maneesh.d8@gmail.com"),
				new Person("Manee10","Devana10",99,"maneesh.d9@gmail.com"),
				new Person("kk","mm",40,"maneesh.d10@gmail.com"));
		
		return person;
	}
	

}
