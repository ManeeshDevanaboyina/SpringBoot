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
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_publisher")
public class Publisher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pub_id")
	private int pubId;
	
	@Column(name="publisher_name")
	private String publisherName;
	
	
	//Below we are using mappedBy inorder to use similar kind of relationship which we used in Book.java for Mapping the tables.
	//We dont need to use below annotations since we used them already in the Book.java. So we are using "MappedBy".
	
	/*@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY) 
		@JoinTable(name="book_publisher",
				joinColumns= @JoinColumn(name="bookId",referencedColumnName="book_id"),
				inverseJoinColumns=@JoinColumn(name="pubId",referencedColumnName="pub_id"))*/
	@ManyToMany(mappedBy="publishers")
	private Set<Book> books;

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	

	public int getPubId() {
		return pubId;
	}

	public void setPubId(int pubId) {
		this.pubId = pubId;
	}

	public Publisher(String publisherName, Set<Book> books) {
		super();
		this.publisherName = publisherName;
		this.books = books;
	}
	
	

	public Publisher(String publisherName) {
		super();
		this.publisherName = publisherName;
	}

	public Publisher() {
		super();
	}

	@Override
	public String toString() {
		return "Publisher [pubId=" + pubId + ", publisherName=" + publisherName + ", books=" + books + "]";
	}
	
	

}
