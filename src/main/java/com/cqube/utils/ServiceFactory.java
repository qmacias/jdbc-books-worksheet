package com.cqube.utils;

import com.cqube.main.ILibraryServices;
import com.cqube.serv.AuthorRepositoryServiceImpl;
import com.cqube.serv.BookRepositoryServiceImpl;

public class ServiceFactory {

	public static ILibraryServices getAuthorServiceImpl() throws DAOException {
		return new AuthorRepositoryServiceImpl();
	}
	
	public static ILibraryServices getBookServiceImpl() throws DAOException {
		return new BookRepositoryServiceImpl();
	}

}
