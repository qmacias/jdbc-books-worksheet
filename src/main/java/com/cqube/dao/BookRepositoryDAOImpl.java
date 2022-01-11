package com.cqube.dao;

import java.util.List;

import com.cqube.model.Book;
import com.cqube.utils.DAOException;
import com.cqube.utils.DAOUtils;
import com.cqube.idao.IBookRepositoryDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookRepositoryDAOImpl implements IBookRepositoryDAO {
    
    private final Connection connection;
    private static final String GETALL = "SELECT books.* FROM books";
    private static final String GETBOK = GETALL + " JOIN book_author ON book_author.book = books.id WHERE book_author.author=?";

    public BookRepositoryDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Book> findAll() throws DAOException {
        PreparedStatement statement = null;
        ResultSet result = null;
        List<Book> books = new ArrayList<Book>();
        try {
            statement = connection.prepareStatement(GETALL);
            result = statement.executeQuery();
            while (result.next()) {
                books.add(convert(result));
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL", e);
        } finally {
            DAOUtils.close(result);
            DAOUtils.close(statement);
        }
        return books;
    }
    
    @Override
	public List<Book> findAllByAuthor(Long author) throws DAOException {
    	PreparedStatement statement = null;
        ResultSet result = null;
        List<Book> books = new ArrayList<Book>();
        try {
            statement = connection.prepareStatement(GETBOK);
            statement.setLong(1, author);
            result = statement.executeQuery();
            while (result.next()) {
                books.add(convert(result));
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL", e);
        } finally {
            DAOUtils.close(result);
            DAOUtils.close(statement);
        }
        return books;
	}
    
    private Book convert(ResultSet result) throws SQLException {
        return new Book(result.getLong("id"), result.getString("title"), result.getString("isbn"));
    }

}
