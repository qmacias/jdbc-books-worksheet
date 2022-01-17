package com.cqube.factory;

import java.sql.Connection;

import com.cqube.factory.common.IGenericFactory;
import com.cqube.persistence.IAuthorRepositoryDAO;
import com.cqube.persistence.IBookRepositoryDAO;
import com.cqube.persistence.IRelatioshipRepositoryDAO;

public interface IDAOFactory extends IGenericFactory {
	public IAuthorRepositoryDAO getAuthorDAOImpl(Connection connection);
	public IBookRepositoryDAO getBookDAOImpl(Connection connection);
	public IRelatioshipRepositoryDAO getRelationshipDAOImpl(Connection connection);
}
