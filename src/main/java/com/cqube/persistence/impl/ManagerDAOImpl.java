package com.cqube.persistence.impl;

import com.cqube.persistence.IAuthorRepositoryDAO;
import com.cqube.persistence.IBookRepositoryDAO;
import com.cqube.persistence.commons.ConnectionProvider;
import com.cqube.persistence.commons.IManagerDAO;
import com.cqube.utils.DAOException;
import com.cqube.utils.DAOFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class ManagerDAOImpl implements IManagerDAO {

    private final Connection connection;
    private IAuthorRepositoryDAO auhtorRepository = null;
    private IBookRepositoryDAO bookRepository = null;

    public ManagerDAOImpl() throws DAOException {
        try {
			this.connection = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			throw new DAOException("Error en SQL", e);
		}
    }
    
    @Override
    public IAuthorRepositoryDAO getAuthorDAO() {
        if (auhtorRepository == null) {
            auhtorRepository = DAOFactory.getAuthorDAOImpl(connection);
        }
        return auhtorRepository;
    }

    @Override
    public IBookRepositoryDAO getBookDAO() {
        if (bookRepository == null) {
            bookRepository = DAOFactory.getBookDAOImpl(connection);
        }
        return bookRepository;
    }

}
