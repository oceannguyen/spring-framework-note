package com.dao;

import com.beans.Book;

public interface BookDAO {
	Book getBook(long ISBN);
	
	int updateBook(long ISBN, int price);
}
