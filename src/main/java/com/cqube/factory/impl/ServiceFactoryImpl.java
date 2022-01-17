package com.cqube.factory.impl;

import com.cqube.factory.IServiceFactory;
import com.cqube.persistence.common.IManagerDAO;
import com.cqube.service.IAuthorRepositoryService;
import com.cqube.service.IBookRepositoryService;
import com.cqube.service.IRelationshipRepositoryService;
import com.cqube.service.impl.AuthorRepositoryServiceImpl;
import com.cqube.service.impl.BookRepositoryServiceImpl;
import com.cqube.service.impl.RelationshipRepositoryServiceImpl;
import com.cqube.utils.DAOException;

public class ServiceFactoryImpl implements IServiceFactory {

	@Override
	public IAuthorRepositoryService getAuthorServiceImpl(IManagerDAO manager) throws DAOException {
		return new AuthorRepositoryServiceImpl(manager);
	}
	
	@Override
	public IBookRepositoryService getBookServiceImpl(IManagerDAO manager) throws DAOException {
		return new BookRepositoryServiceImpl(manager);
	}

	@Override
	public IRelationshipRepositoryService getRelationshipServiceImpl(IManagerDAO manager) throws DAOException {
		return new RelationshipRepositoryServiceImpl(manager);
	}

}
