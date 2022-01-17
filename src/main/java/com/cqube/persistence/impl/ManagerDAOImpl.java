package com.cqube.persistence.impl;

import com.cqube.factory.IDAOFactory;
import com.cqube.factory.impl.DAOFactoryImpl;
import com.cqube.persistence.IAuthorRepositoryDAO;
import com.cqube.persistence.IBookRepositoryDAO;
import com.cqube.persistence.IRelatioshipRepositoryDAO;
import com.cqube.persistence.common.IManagerDAO;

import java.sql.Connection;

public class ManagerDAOImpl implements IManagerDAO {

	private Connection connection;
	private IDAOFactory daoFactory;
    private IAuthorRepositoryDAO auhtorRepository = null;
    private IBookRepositoryDAO bookRepository = null;
    private IRelatioshipRepositoryDAO relationshipRepository = null;

    public ManagerDAOImpl(Connection connection) {
    	this.connection = connection;
    	this.daoFactory = new DAOFactoryImpl();
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

	@Override
	public IRelatioshipRepositoryDAO getRelationshipDAO() {
		if (relationshipRepository == null) {
			relationshipRepository = daoFactory.getRelationshipDAOImpl(connection);
		}
		return relationshipRepository;
	}

}
