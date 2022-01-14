package com.cqube.persistence.impl;

import com.cqube.connection.ConnectionProvider;
import com.cqube.factory.IDAOFactory;
import com.cqube.factory.impl.DAOFactoryImpl;
import com.cqube.persistence.IAuthorRepositoryDAO;
import com.cqube.persistence.IBookRepositoryDAO;
import com.cqube.persistence.common.IManagerDAO;
import com.cqube.utils.DAOException;

import java.sql.Connection;
import java.sql.SQLException;

public class ManagerDAOImpl implements IManagerDAO {

	private IDAOFactory daoFactory;
    private final Connection connection;
    private IAuthorRepositoryDAO auhtorRepository = null;
    private IBookRepositoryDAO bookRepository = null;

    public ManagerDAOImpl() throws DAOException {
        try {
        	this.daoFactory = new DAOFactoryImpl();
			this.connection = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			throw new DAOException("Error en SQL", e);
		}
    }
    
    @Override
    public IAuthorRepositoryDAO getAuthorDAO() {
        if (auhtorRepository == null) {
            auhtorRepository = daoFactory.getAuthorDAOImpl(connection);
        }
        return auhtorRepository;
    }

    @Override
    public IBookRepositoryDAO getBookDAO() {
        if (bookRepository == null) {
            bookRepository = daoFactory.getBookDAOImpl(connection);
        }
        return bookRepository;
    }

}
