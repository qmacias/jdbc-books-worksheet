package com.cqube.persistence.impl;

import com.cqube.persistence.commons.ILibraryService;
import com.cqube.persistence.commons.IManagerService;
import com.cqube.utils.DAOException;
import com.cqube.utils.ServiceFactory;

public class ManagerServiceImpl implements IManagerService {

	private ILibraryService authorService = null;
	private ILibraryService bookService = null;
	
	@Override
	public ILibraryService getAuthorService() throws DAOException {
		if (authorService == null) {
			authorService = ServiceFactory.getAuthorServiceImpl();
		}
		return authorService;
	}

	@Override
	public ILibraryService getBookService() throws DAOException {
		if (bookService == null) {
			bookService = ServiceFactory.getBookServiceImpl();
		}
		return bookService;
	}

}
