package com.beans;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Library_Map1 {
	private Map<String, List<Book>> books;

	public Map<String, List<Book>> getBooks() {
		return books;
	}

	public void setBooks(Map<String, List<Book>> books) {
		this.books = books;
	}
	
	public void displayBooks() {
		Set<Entry<String, List<Book>>> entries = books.entrySet();
		for(Entry<String, List<Book>> entry: entries) {
			System.out.println("> " + entry.getKey());
			for(Book book: entry.getValue()) {
				System.out.println(book);
			}
		}
	}
}
