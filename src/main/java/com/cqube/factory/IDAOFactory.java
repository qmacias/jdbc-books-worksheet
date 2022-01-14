package com.cqube.factory;

import java.sql.Connection;

import com.cqube.factory.common.IGenericFactory;
import com.cqube.persistence.IAuthorRepositoryDAO;
import com.cqube.persistence.IBookRepositoryDAO;

public interface IDAOFactory extends IGenericFactory {
	public IAuthorRepositoryDAO getAuthorDAOImpl(Connection connection);
	public IBookRepositoryDAO getBookDAOImpl(Connection connection);
}
