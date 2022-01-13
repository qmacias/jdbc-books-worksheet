package com.cqube.utils;

import java.sql.Connection;

import com.cqube.persistence.IAuthorRepositoryDAO;
import com.cqube.persistence.IBookRepositoryDAO;
import com.cqube.persistence.impl.AuthorRepositoryDAOImpl;
import com.cqube.persistence.impl.BookRepositoryDAOImpl;

public class DAOFactory {

	public static IAuthorRepositoryDAO getAuthorDAOImpl(Connection connection) {
		return new AuthorRepositoryDAOImpl(connection);
	}
	
	public static IBookRepositoryDAO getBookDAOImpl(Connection connection) {
		return new BookRepositoryDAOImpl(connection);
	}
}
