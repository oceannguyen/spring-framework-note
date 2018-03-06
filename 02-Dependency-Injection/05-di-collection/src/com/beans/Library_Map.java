package com.beans;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Library_Map {
	private Map<String, Book> books;

	public Map<String, Book> getBooks() {
		return books;
	}

	public void setBooks(Map<String, Book> books) {
		this.books = books;
	}

	public void displayBooks() {
		Set<Entry<String, Book>> entries = books.entrySet();
		for (Entry<String, Book> entry : entries) {
			System.out.println(entry.getValue());
		}
	}

}
