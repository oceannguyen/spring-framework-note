package com.beans;

import java.util.Set;

public class Library_Set {
	private Set<Book> books;

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	public void displayBooks() {
		for(Book book: books) {
			System.out.println(book);
		}
	}
}
