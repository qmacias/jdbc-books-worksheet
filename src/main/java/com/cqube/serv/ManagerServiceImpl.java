package com.cqube.serv;

import com.cqube.iserv.IManagerService;
import com.cqube.main.ILibraryServices;
import com.cqube.utils.DAOException;
import com.cqube.utils.ServiceFactory;

public class ManagerServiceImpl implements IManagerService {

	private ILibraryServices authorService = null;
	private ILibraryServices bookService = null;
	
	@Override
	public ILibraryServices getAuthorService() throws DAOException {
		if (authorService == null) {
			authorService = ServiceFactory.getAuthorServiceImpl();
		}
		return authorService;
	}

	@Override
	public ILibraryServices getBookService() throws DAOException {
		if (bookService == null) {
			bookService = ServiceFactory.getBookServiceImpl();
		}
		return bookService;
	}

}
