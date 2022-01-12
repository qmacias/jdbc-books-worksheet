package com.cqube.utils;

import com.cqube.iserv.ILibraryService;
import com.cqube.serv.AuthorRepositoryServiceImpl;
import com.cqube.serv.BookRepositoryServiceImpl;

public class ServiceFactory {

	public static ILibraryService getAuthorServiceImpl() throws DAOException {
		return new AuthorRepositoryServiceImpl();
	}
	
	public static ILibraryService getBookServiceImpl() throws DAOException {
		return new BookRepositoryServiceImpl();
	}

}
