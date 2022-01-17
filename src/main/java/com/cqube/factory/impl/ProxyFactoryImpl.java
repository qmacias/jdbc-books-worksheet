package com.cqube.factory.impl;

import com.cqube.factory.IProxyFactory;
import com.cqube.service.IAuthorRepositoryService;
import com.cqube.service.IBookRepositoryService;
import com.cqube.service.common.IManagerService;
import com.cqube.service.proxy.AuthorRepositoryProxyImpl;
import com.cqube.service.proxy.BookRepositoryProxyImpl;
import com.cqube.utils.DAOException;

public class ProxyFactoryImpl implements IProxyFactory {

	@Override
	public IAuthorRepositoryService getAuthorProxyImpl(IManagerService manager) throws DAOException {
		return new AuthorRepositoryProxyImpl(manager);
	}

	@Override
	public IBookRepositoryService getBookProxyImpl(IManagerService manager) throws DAOException {
		return new BookRepositoryProxyImpl(manager);
	}

}
