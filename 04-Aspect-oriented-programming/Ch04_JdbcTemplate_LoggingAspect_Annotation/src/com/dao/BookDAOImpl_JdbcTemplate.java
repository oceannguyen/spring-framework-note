package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.beans.Book;

@Repository("bookDAOImpl_jdbcTemplate")
public class BookDAOImpl_JdbcTemplate implements BookDAO {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public BookDAOImpl_JdbcTemplate(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addBook(Book book) {
		int rows = 0;
		String INSERT_BOOK = "INSERT INTO book  VALUES(?,?,?,?,?,?)";
		rows = jdbcTemplate.update(INSERT_BOOK, 
				book.getBookName(), 
				book.getISBN(), 
				book.getPublication(),
				book.getPrice(), 
				book.getDescription(), 
				book.getAuthor());
		return rows;
	}

	@Override
	public int updateBook(long ISBN, int price) {
		int rows = 0; 
        String UPDATE_BOOK = "UPDATE book SET price=? WHERE  ISBN=?"; 
        rows = jdbcTemplate.update(UPDATE_BOOK, price,ISBN); 
        return rows; 
	}

	@Override
	public boolean deleteBook(long ISBN) {
		int rows = 0;
		String DELETE_BOOK = "DELETE FROM book WHERE ISBN=?";
		rows = jdbcTemplate.update(DELETE_BOOK, ISBN);
		
		return rows > 0;
	}

}
