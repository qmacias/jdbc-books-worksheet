package com.cqube.utils;

import com.cqube.persistence.commons.ILibraryService;
import com.cqube.persistence.impl.AuthorRepositoryServiceImpl;
import com.cqube.persistence.impl.BookRepositoryServiceImpl;

public class ServiceFactory {

	public static ILibraryService getAuthorServiceImpl() throws DAOException {
		return new AuthorRepositoryServiceImpl();
	}
	
	public static ILibraryService getBookServiceImpl() throws DAOException {
		return new BookRepositoryServiceImpl();
	}

}
