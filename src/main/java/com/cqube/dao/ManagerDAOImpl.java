package com.cqube.dao;

import com.cqube.idao.IAuthorRepositoryDAO;
import com.cqube.idao.IBookRepositoryDAO;
import com.cqube.idao.IManagerDAO;
import com.cqube.jdbc.ConnectionProvider;
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
