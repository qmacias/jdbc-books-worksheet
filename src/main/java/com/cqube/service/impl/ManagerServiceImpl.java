package com.cqube.service.impl;

import com.cqube.factory.IServiceFactory;
import com.cqube.factory.impl.ServiceFactoryImpl;
import com.cqube.persistence.common.IManagerDAO;
import com.cqube.service.IAuthorRepositoryService;
import com.cqube.service.IBookRepositoryService;
import com.cqube.service.common.IManagerService;
import com.cqube.utils.DAOException;

public class ManagerServiceImpl implements IManagerService {

	private IManagerDAO manager;
	private IServiceFactory serviceFactory;
	private IAuthorRepositoryService authorService = null;
	private IBookRepositoryService bookService = null;

	public ManagerServiceImpl(IManagerDAO manager) {
		this.manager = manager;
		this.serviceFactory = new ServiceFactoryImpl();
	}

	@Override
	public IAuthorRepositoryService getAuthorService() throws DAOException {
		if (authorService == null) {
			authorService = serviceFactory.getAuthorServiceImpl(manager);
		}
		return authorService;
	}

	@Override
	public IBookRepositoryService getBookService() throws DAOException {
		if (bookService == null) {
			bookService = serviceFactory.getBookServiceImpl(manager);
		}
		return bookService;
	}

}
