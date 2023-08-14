package com.SpringClasses.DMS.Database;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_book")

//Implementation of Derived Query giveDataByName

//Named query section

@NamedQueries(value= {
		//Implementation Layer
		//Named Query1
		@NamedQuery(name="Book.retrieveBooksByName",
				query="select b from Book b join b.publishers p where b.bookName=?1"),
})
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="book_id")
	private int bookId;
	
	@Column(name="book_name")
	private String bookName;
	
	
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY) 
	
	/*Here the tables follows Many-Many relationship so we use ManytoMany annotation and keyword CASCADE is used because 
	 * cascading nothing but updating in general so as soon as we made any changes(Update,Delete,Insert,Retrieval) the remaining tables get updated
	 * now FetchType is basically two types one is LAZY and another is EAGER. LAZY is nothing but if we ask for one particular table data only that 
	 * specific table is given if we use eager entire tables data is given. */

	@JoinTable(name="book_publisher",
				joinColumns= @JoinColumn(name="bookId",referencedColumnName="book_id"),
				inverseJoinColumns=@JoinColumn(name="pubId",referencedColumnName="pub_id"))
	
	/*Here we use JoinTable Entity creates a Mapping table called book_publisher for joining 2 tables publisher and book table joining columns based and creating a new table based on book_id and 
	 * pub_id. we can use the same annotation in the publisher class and thus that would be considered as parent this one as child.*/
	
	//With this application we are creating book table, publisher table, book_publisher table.
	
	private Set<Publisher> publishers;



	public int getBookId() {
		return bookId;
	}



	public void setBookId(int bookId) {
		this.bookId = bookId;
	}



	public String getBookName() {
		return bookName;
	}



	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public Set<Publisher> getPublishers() {
		return publishers;
	}



	public void setPublishers(Set<Publisher> publishers) {
		this.publishers = publishers;
	}



	public Book(String bookName, Set<Publisher> publishers) {
		super();
		this.bookName = bookName;
		this.publishers = publishers;
	}



	public Book() {
		super();
	}



	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", publishers=" + publishers + "]";
	}



	
	
	
}
