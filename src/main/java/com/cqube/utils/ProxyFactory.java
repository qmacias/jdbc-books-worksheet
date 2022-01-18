package com.cqube.utils;

import com.cqube.service.IAuthorRepositoryService;
import com.cqube.service.IBookRepositoryService;
import com.cqube.service.IRelationshipRepositoryService;
import com.cqube.service.common.IManagerService;
import com.cqube.service.proxy.AuthorRepositoryProxyImpl;
import com.cqube.service.proxy.BookRepositoryProxyImpl;
import com.cqube.service.proxy.RelationshipRepositoryProxyImpl;

public class ProxyFactory {

	public static IAuthorRepositoryService getAuthorProxyImpl(IManagerService manager) throws DAOException {
		return new AuthorRepositoryProxyImpl(manager);
	}

	public static IBookRepositoryService getBookProxyImpl(IManagerService manager) throws DAOException {
		return new BookRepositoryProxyImpl(manager);
	}

	public static IRelationshipRepositoryService getRelationshipProxyImpl(IManagerService manager) throws DAOException {
		return new RelationshipRepositoryProxyImpl(manager);
	}

}
