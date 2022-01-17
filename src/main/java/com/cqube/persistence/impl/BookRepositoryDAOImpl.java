package com.cqube.persistence.impl;

import java.util.List;

import com.cqube.model.Book;
import com.cqube.persistence.IBookRepositoryDAO;
import com.cqube.utils.DAOException;
import com.cqube.utils.DAOUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookRepositoryDAOImpl implements IBookRepositoryDAO {
    
    private Connection connection;
    private static final String INSERT = "INSERT INTO books(title, isbn) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE books SET title=?, isbn=? WHERE id=?";
    private static final String DELETE = "DELETE FROM books WHERE id=?";
    private static final String GETALL = "SELECT books.* FROM books";
    private static final String GETONE = GETALL + " WHERE id=?";
    private static final String GETTLE = GETALL + " WHERE title=?";
    private static final String GETBOK = GETALL + " JOIN book_author ON book_author.book = books.id WHERE book_author.author=?";

    public BookRepositoryDAOImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
	public int insert(Book b) throws DAOException, SQLException {
    	connection.setAutoCommit(false);
    	PreparedStatement statement = null;
        ResultSet result = null;
        try {
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, b.getTitle());
            statement.setString(2, b.getIsbn());
            int rows = statement.executeUpdate();
            connection.commit();
            if (rows == 0) {
                throw new DAOException("The record may not have been saved");
            }
            result = statement.getGeneratedKeys();
            if (result.next()) {
                b.setId(result.getLong(1));
            } else {
                throw new DAOException("Cannot assign an id to this record");
            }
            return rows;
        } catch (SQLException e) {
        	connection.rollback();
            throw new DAOException("SQL Error", e);
        } finally {
            DAOUtils.closeResultSet(result);
            DAOUtils.closePreparedStatement(statement);
        }
	}

	@Override
	public int update(Book b) throws DAOException, SQLException {
		connection.setAutoCommit(false);
		PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, b.getTitle());
            statement.setString(2, b.getIsbn());
            statement.setLong(3, b.getId());
            int rows = statement.executeUpdate();
            connection.commit();
            if (rows == 0) {
                throw new DAOException("The record may not have been updated");
            }
            return rows;
        } catch (SQLException e) {
        	connection.rollback();
            throw new DAOException("SQL Error", e);
        } finally {
            DAOUtils.closePreparedStatement(statement);
        }
	}

	@Override
	public int delete(Book b) throws DAOException, SQLException {
		connection.setAutoCommit(false);
		PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setLong(1, b.getId());
            int rows = statement.executeUpdate();
            connection.commit();
            if (rows == 0) {
                throw new DAOException("The record may not have been deleted");
            }
            return rows;
        } catch (SQLException e) {
        	connection.rollback();
            throw new DAOException("SQL Error", e);
        } finally {
            DAOUtils.closePreparedStatement(statement);
        }
	}

	@Override
	public Book find(Long id) throws DAOException {
		PreparedStatement statement = null;
        ResultSet result = null;
        Book book = null;
        try {
            statement = connection.prepareStatement(GETONE);
            statement.setLong(1, id);
            result = statement.executeQuery();
            if (result.next()) {
                book = convert(result);
            } else {
                throw new DAOException("The record may not have been found");
            }
        } catch (SQLException e) {
            throw new DAOException("SQL Error", e);
        } finally {
            DAOUtils.closeResultSet(result);
            DAOUtils.closePreparedStatement(statement);
        }
        return book;
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
            DAOUtils.closeResultSet(result);
            DAOUtils.closePreparedStatement(statement);
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
            DAOUtils.closeResultSet(result);
            DAOUtils.closePreparedStatement(statement);
        }
        return books;
	}
    
    private Book convert(ResultSet result) throws SQLException {
        return new Book(result.getLong("id"), result.getString("title"), result.getString("isbn"));
    }

	@Override
	public Book findByTitle(String title) throws DAOException {
		PreparedStatement statement = null;
        ResultSet result = null;
        Book book = null;
        try {
            statement = connection.prepareStatement(GETTLE);
            statement.setString(1, title);
            result = statement.executeQuery();
            if (result.next()) {
                book = convert(result);
            } else {
                throw new DAOException("The record may not have been found");
            }
        } catch (SQLException e) {
            throw new DAOException("SQL Error", e);
        } finally {
            DAOUtils.closeResultSet(result);
            DAOUtils.closePreparedStatement(statement);
        }
        return book;
	}

}
