package com.beans;

public class Book {
	private String isbn;
	private String bookName;
	private int price;
	private String publication;

	public Book() {
		super();
	}

	public Book(String isbn, String bookName, int price, String publication) {
		super();
		this.isbn = isbn;
		this.bookName = bookName;
		this.price = price;
		this.publication = publication;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", bookName=" + bookName + ", price=" + price + ", publication=" + publication
				+ "]";
	}

}
