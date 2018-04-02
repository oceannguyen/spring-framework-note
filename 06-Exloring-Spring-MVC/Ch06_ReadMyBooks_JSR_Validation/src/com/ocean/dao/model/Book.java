package com.ocean.dao.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Book {
	
	@NotEmpty
	@Size(min = 2, max = 30)
	private String bookName;
	
	@Min(150)
	private long ISBN;
	
	@NotEmpty
	@Size(min = 2, max = 30)
	private String publication;
	
	@NotNull
	private int price;
	
	@NotEmpty
	@Size(min = 10, max = 40)
	private String description;
	
	@NotEmpty
	private String author;

	public Book() {
		super();
	}

	public Book(String bookName, long iSBN, String publication, int price, String description, String author) {
		super();
		this.bookName = bookName;
		ISBN = iSBN;
		this.publication = publication;
		this.price = price;
		this.description = description;
		this.author = author;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
