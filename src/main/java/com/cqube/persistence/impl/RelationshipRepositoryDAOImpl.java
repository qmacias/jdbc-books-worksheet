package com.cqube.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cqube.model.Relationship;
import com.cqube.model.Relationship.PrimaryKey;
import com.cqube.persistence.IRelatioshipRepositoryDAO;
import com.cqube.utils.DAOException;
import com.cqube.utils.DAOUtils;

public class RelationshipRepositoryDAOImpl implements IRelatioshipRepositoryDAO {

	private final Connection connection;
    private static final String INSERT = "INSERT INTO book_author(book, author) VALUES(?, ?)";
    private static final String UPDATE = "UPDATE book_author SET book=?, author=?";
    private static final String DELETE = "DELETE FROM book_author WHERE book? AND author=?";
    private static final String GETALL = "SELECT book_author.* FROM book_author";
    private static final String GETONE = GETALL + " WHERE book=? AND author=?";
    private static final String GETAUT = GETALL + " WHERE author=?";
    private static final String GETBOK = GETALL + " WHERE book=?";

    public RelationshipRepositoryDAOImpl(Connection connection) {
        this.connection = connection;
    }
    
	@Override
	public int insert(Relationship r) throws DAOException, SQLException {
		connection.setAutoCommit(false);
    	PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT);
            statement.setLong(1, r.getId().getBook());
            statement.setLong(2, r.getId().getAuthor());
            int rows = statement.executeUpdate();
            connection.commit();
            if (rows == 0) {
                throw new DAOException("The record may not have been saved");
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
	public int update(Relationship r) throws DAOException {
		PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setLong(1, r.getId().getBook());
            statement.setLong(2, r.getId().getAuthor());
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
	public int delete(Relationship r) throws DAOException {
		PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setLong(1, r.getId().getBook());
            statement.setLong(2, r.getId().getAuthor());
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
	public Relationship find(PrimaryKey id) throws DAOException {
		PreparedStatement statement = null;
        ResultSet result = null;
        Relationship relation = null;
        try {
            statement = connection.prepareStatement(GETONE);
            statement.setLong(1, id.getBook());
            statement.setLong(2, id.getAuthor());
            result = statement.executeQuery();
            if (result.next()) {
                relation = convert(result);
            } else {
                throw new DAOException("The record may not have been found");
            }
        } catch (SQLException e) {
            throw new DAOException("SQL Error", e);
        } finally {
            DAOUtils.closeResultSet(result);
            DAOUtils.closePreparedStatement(statement);
        }
        return relation;
	}

	@Override
	public List<Relationship> findAll() throws DAOException {
		PreparedStatement statement = null;
        ResultSet result = null;
        List<Relationship> relation = new ArrayList<Relationship>();
        try {
            statement = connection.prepareStatement(GETALL);
            result = statement.executeQuery();
            while (result.next()) {
                relation.add(convert(result));
            }
        } catch (SQLException e) {
        	throw new DAOException("SQL Error", e);
        } finally {
            DAOUtils.closeResultSet(result);
            DAOUtils.closePreparedStatement(statement);
        }
        return relation;
	}

	@Override
	public List<Relationship> findAllAuthorsByBook(Long book) throws DAOException {
		PreparedStatement statement = null;
        ResultSet result = null;
        List<Relationship> authors = new ArrayList<Relationship>();
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

	@Override
	public List<Relationship> findAllBooksByAuthor(Long author) throws DAOException {
		PreparedStatement statement = null;
        ResultSet result = null;
        List<Relationship> books = new ArrayList<Relationship>();
        try {
            statement = connection.prepareStatement(GETBOK);
            statement.setLong(1, author);
            result = statement.executeQuery();
            while (result.next()) {
                books.add(convert(result));
            }
        } catch (SQLException e) {
       	 throw new DAOException("SQL Error", e);
        } finally {
            DAOUtils.closeResultSet(result);
            DAOUtils.closePreparedStatement(statement);
        }
        return books;
	}
	
	private Relationship convert(ResultSet result) throws SQLException {
		return new Relationship(result.getLong("book"), result.getLong("author"));
	}

}
