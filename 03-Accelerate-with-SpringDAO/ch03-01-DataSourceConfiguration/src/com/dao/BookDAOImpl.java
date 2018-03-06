package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.beans.Book;

public class BookDAOImpl implements BookDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public int addBook(Book book) {
		int rows = 0;
		String INSERT_BOOK = "INSERT INTO book VALUES(?,?,?,?,?,?)";
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
