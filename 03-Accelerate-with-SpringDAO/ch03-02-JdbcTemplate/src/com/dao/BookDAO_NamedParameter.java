package com.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.beans.Book;

@Repository("bookDAOImpl_named")
public class BookDAO_NamedParameter implements BookDAO {

	private final NamedParameterJdbcTemplate namedTemplate;

	@Autowired
	public BookDAO_NamedParameter(NamedParameterJdbcTemplate namedTemplate) {
		super();
		this.namedTemplate = namedTemplate;
	}

	@Override
	public int addBook(Book book) {
		int rows = 0;

		String INSERT_BOOK = "insert into book  values(:bookName,:ISBN,:publication,:price, :description,:author)";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bookName", book.getBookName());
		params.put("ISBN", book.getISBN());
		params.put("publication", book.getPublication());
		params.put("price", book.getPrice());
		params.put("description", book.getDescription());
		params.put("author", book.getAuthor());
		rows = namedTemplate.update(INSERT_BOOK, params);

		return rows;
	}

	@Override
	public int updateBook(long ISBN, int price) {
		int rows = 0;

		String UPDATE_BOOK = "UPDATE book SET price=:price WHERE ISBN=:ISBN";

		Map<String, Object> params = new HashMap<>();
		params.put("price", price);
		params.put("ISBN", ISBN);

		rows = namedTemplate.update(UPDATE_BOOK, params);

		return rows;
	}

	@Override
	public boolean deleteBook(long ISBN) {
		int rows = 0;

		String DELETE_BOOK = "DELETE FROM book WHERE ISBN=:ISBN";

		Map<String, Object> params = new HashMap<>();
		params.put("ISBN", ISBN);

		rows = namedTemplate.update(DELETE_BOOK, params);

		return rows > 0;
	}

}
