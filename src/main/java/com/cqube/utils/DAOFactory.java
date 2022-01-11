package com.cqube.utils;

import java.sql.Connection;

import com.cqube.dao.AuthorRepositoryDAOImpl;
import com.cqube.dao.BookRepositoryDAOImpl;
import com.cqube.idao.IAuthorRepositoryDAO;
import com.cqube.idao.IBookRepositoryDAO;

public class DAOFactory {

	public static IAuthorRepositoryDAO getAuthorDAOImpl(Connection connection) {
		return new AuthorRepositoryDAOImpl(connection);
	}
	
	public static IBookRepositoryDAO getBookDAOImpl(Connection connection) {
		return new BookRepositoryDAOImpl(connection);
	}
}