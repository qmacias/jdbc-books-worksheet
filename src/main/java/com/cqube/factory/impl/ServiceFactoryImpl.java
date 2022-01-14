package com.cqube.factory.impl;

import com.cqube.factory.IServiceFactory;
import com.cqube.persistence.common.IManagerDAO;
import com.cqube.service.IAuthorRepositoryService;
import com.cqube.service.IBookRepositoryService;
import com.cqube.service.impl.AuthorRepositoryServiceImpl;
import com.cqube.service.impl.BookRepositoryServiceImpl;
import com.cqube.utils.DAOException;

public class ServiceFactoryImpl implements IServiceFactory {

	public IAuthorRepositoryService getAuthorServiceImpl(IManagerDAO manager) throws DAOException {
		return new AuthorRepositoryServiceImpl(manager);
	}
	
	public IBookRepositoryService getBookServiceImpl(IManagerDAO manager) throws DAOException {
		return new BookRepositoryServiceImpl(manager);
	}

}
