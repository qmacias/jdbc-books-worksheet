package com.cqube.dao;

import com.cqube.idao.IAuthorRepositoryDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cqube.model.Author;
import com.cqube.utils.DAOException;
import com.cqube.utils.DAOUtils;

public class AuthorRepositoryDAOImpl implements IAuthorRepositoryDAO {

    private final Connection connection;
    private static final String GETALL = "SELECT authors.* FROM authors";
    private static final String GETAUT = GETALL + " JOIN book_author ON book_author.author = authors.id WHERE book_author.book=?";

    public AuthorRepositoryDAOImpl(Connection connection) {
        this.connection = connection;
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
            throw new DAOException("Error en SQL", e);
        } finally {
            DAOUtils.close(result);
            DAOUtils.close(statement);
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
             throw new DAOException("Error en SQL", e);
         } finally {
             DAOUtils.close(result);
             DAOUtils.close(statement);
         }
         return authors;
	}
    
    private Author convert(ResultSet result) throws SQLException {
        return new Author(result.getLong("id"), result.getString("name"));
    }

}
