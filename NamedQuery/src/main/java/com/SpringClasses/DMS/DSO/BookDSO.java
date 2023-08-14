package com.SpringClasses.DMS.DSO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SpringClasses.DMS.Database.Book;

@Repository
public interface BookDSO extends CrudRepository<Book,Integer> {
	
	public Iterable<Book> findByBookName(String book1); //Derived Query
	public Iterable<Book> retrieveBooksByName(String bookName); //Named Query

}
