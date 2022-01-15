package com.cqube.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cqube.model.Author;
import com.cqube.persistence.IAuthorRepositoryDAO;
import com.cqube.utils.DAOException;
import com.cqube.utils.DAOUtils;

public class AuthorRepositoryDAOImpl implements IAuthorRepositoryDAO {

    private final Connection connection;
    private static final String INSERT = "INSERT INTO authors(name) VALUES (?)";
    private static final String UPDATE = "UPDATE authors SET name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM authors WHERE id=?";
    private static final String GETALL = "SELECT authors.* FROM authors";
    private static final String GETONE = GETALL + " WHERE id=?";
    private static final String GETAUT = GETALL + " JOIN book_author ON book_author.author = authors.id WHERE book_author.book=?";

    public AuthorRepositoryDAOImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
	public int insert(Author a) throws DAOException, SQLException {
    	connection.setAutoCommit(false);
    	PreparedStatement statement = null;
        ResultSet result = null;
        try {
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, a.getName());
            int rows = statement.executeUpdate();
            connection.commit();
            if (rows == 0) {
                throw new DAOException("The record may not have been saved");
            }
            result = statement.getGeneratedKeys();
            if (result.next()) {
                a.setId(result.getLong(1));
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
	public int update(Author a) throws DAOException {
		PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, a.getName());
            statement.setLong(2, a.getId());
            int rows = statement.executeUpdate();
            if (rows == 0) {
                throw new DAOException("The record may not have been updated");
            }
            return rows;
        } catch (SQLException e) {
            throw new DAOException("SQL Error", e);
        } finally {
            DAOUtils.closePreparedStatement(statement);
        }
	}

	@Override
	public int delete(Author a) throws DAOException {
		PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setLong(1, a.getId());
            int rows = statement.executeUpdate();
            if (rows == 0) {
                throw new DAOException("The record may not have been deleted");
            }
            return rows;
        } catch (SQLException e) {
            throw new DAOException("SQL Error", e);
        } finally {
            DAOUtils.closePreparedStatement(statement);
        }
	}

	@Override
	public Author find(Long id) throws DAOException {
		PreparedStatement statement = null;
        ResultSet result = null;
        Author author = null;
        try {
            statement = connection.prepareStatement(GETONE);
            statement.setLong(1, id);
            result = statement.executeQuery();
            if (result.next()) {
                author = convert(result);
            } else {
                throw new DAOException("The record may not have been found");
            }
        } catch (SQLException e) {
            throw new DAOException("SQL Error", e);
        } finally {
            DAOUtils.closeResultSet(result);
            DAOUtils.closePreparedStatement(statement);
        }
        return author;
	}
	
	@Override
    public List<Author> findAll() throws DAOException {
        PreparedStatement statement = null;
        ResultSet result = null;
        List<Author> authors = new ArrayList<Author>();
        try {
            statement = connection.prepareStatement(GETALL);
            result = statement.executeQuery();
            while (result.next()) {
                authors.add(convert(result));
            }
        } catch (SQLException e) {
        	throw new DAOException("SQL Error", e);
        } finally {
            DAOUtils.closeResultSet(result);
            DAOUtils.closePreparedStatement(statement);
        }
        return authors;
    }

    @Override
	public List<Author> findAllByBook(Long book) throws DAOException {
    	 PreparedStatement statement = null;
         ResultSet result = null;
         List<Author> authors = new ArrayList<Author>();
         try {
             statement = connection.prepareStatement(GETAUT);
             statement.setLong(1, book);
             result = statement.executeQuery();
             while (result.next()) {
                 authors.add(convert(result));
             }
         } catch (SQLException e) {
        	 throw new DAOException("SQL Error", e);
         } finally {
             DAOUtils.closeResultSet(result);
             DAOUtils.closePreparedStatement(statement);
         }
         return authors;
	}
	
    private Author convert(ResultSet result) throws SQLException {
        return new Author(result.getLong("id"), result.getString("name"));
    }

}
