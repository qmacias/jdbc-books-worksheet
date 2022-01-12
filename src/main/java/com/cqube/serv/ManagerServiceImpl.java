package com.cqube.serv;

import com.cqube.iserv.ILibraryService;
import com.cqube.iserv.IManagerService;
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
