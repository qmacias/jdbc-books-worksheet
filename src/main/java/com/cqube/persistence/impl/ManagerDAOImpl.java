package com.cqube.persistence.impl;

import com.cqube.persistence.IAuthorRepositoryDAO;
import com.cqube.persistence.IBookRepositoryDAO;
import com.cqube.persistence.IRelatioshipRepositoryDAO;
import com.cqube.persistence.common.IManagerDAO;
import com.cqube.utils.DAOFactory;

import java.sql.Connection;

public class ManagerDAOImpl implements IManagerDAO {

	private Connection connection;
    private IAuthorRepositoryDAO auhtorRepository = null;
    private IBookRepositoryDAO bookRepository = null;
    private IRelatioshipRepositoryDAO relationshipRepository = null;

    public ManagerDAOImpl(Connection connection) {
    	this.connection = connection;
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

	@Override
	public IRelatioshipRepositoryDAO getRelationshipDAO() {
		if (relationshipRepository == null) {
			relationshipRepository = DAOFactory.getRelationshipDAOImpl(connection);
		}
		return relationshipRepository;
	}

}
