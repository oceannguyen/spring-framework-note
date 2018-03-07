package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beans.Book;

@Repository("bookDAO_new")
public class BookDAOImpl_Annotation implements BookDAO {

	private final DataSource dataSource;

	@Autowired
	public BookDAOImpl_Annotation(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public int addBook(Book book) {
		int rows = 0;
		String INSERT_BOOK = "insert into book values(?,?,?,?,?,?)";
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(INSERT_BOOK);
			ps.setString(1, book.getBookName());
			ps.setLong(2, book.getISBN());
			ps.setString(3, book.getPublication());
			ps.setInt(4, book.getPrice());
			ps.setString(5, book.getDescription());
			ps.setString(6, book.getAuthor());
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

}
