package com.dao;

import com.beans.Book;

public interface BookDAO {
	public int addBook(Book book);

	public int updateBook(long ISBN, int price);
	
	public boolean deleteBook(long ISBN);
	
	public Book searchBook(long ISBN);
}
