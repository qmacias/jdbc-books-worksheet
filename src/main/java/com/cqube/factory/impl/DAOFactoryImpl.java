package com.cqube.factory.impl;

import java.sql.Connection;

import com.cqube.factory.IDAOFactory;
import com.cqube.persistence.IAuthorRepositoryDAO;
import com.cqube.persistence.IBookRepositoryDAO;
import com.cqube.persistence.IRelatioshipRepositoryDAO;
import com.cqube.persistence.impl.AuthorRepositoryDAOImpl;
import com.cqube.persistence.impl.BookRepositoryDAOImpl;
import com.cqube.persistence.impl.RelationshipRepositoryDAOImpl;

public class DAOFactoryImpl implements IDAOFactory {

	@Override
	public IAuthorRepositoryDAO getAuthorDAOImpl(Connection connection) {
		return new AuthorRepositoryDAOImpl(connection);
	}
	
	@Override
	public IBookRepositoryDAO getBookDAOImpl(Connection connection) {
		return new BookRepositoryDAOImpl(connection);
	}

	@Override
	public IRelatioshipRepositoryDAO getRelationshipDAOImpl(Connection connection) {
		return new RelationshipRepositoryDAOImpl(connection);
	}
	
}
