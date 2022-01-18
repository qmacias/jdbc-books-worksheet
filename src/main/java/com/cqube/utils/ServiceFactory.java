package com.cqube.utils;

import com.cqube.persistence.common.IManagerDAO;
import com.cqube.service.IAuthorRepositoryService;
import com.cqube.service.IBookRepositoryService;
import com.cqube.service.IRelationshipRepositoryService;
import com.cqube.service.impl.AuthorRepositoryServiceImpl;
import com.cqube.service.impl.BookRepositoryServiceImpl;
import com.cqube.service.impl.RelationshipRepositoryServiceImpl;

public class ServiceFactory {

	public static IAuthorRepositoryService getAuthorServiceImpl(IManagerDAO manager) throws DAOException {
		return new AuthorRepositoryServiceImpl(manager);
	}
	
	public static IBookRepositoryService getBookServiceImpl(IManagerDAO manager) throws DAOException {
		return new BookRepositoryServiceImpl(manager);
	}

	public static IRelationshipRepositoryService getRelationshipServiceImpl(IManagerDAO manager) throws DAOException {
		return new RelationshipRepositoryServiceImpl(manager);
	}

}
