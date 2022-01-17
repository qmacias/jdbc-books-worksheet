package com.cqube.factory;

import com.cqube.factory.common.IGenericFactory;
import com.cqube.service.IAuthorRepositoryService;
import com.cqube.service.IBookRepositoryService;
import com.cqube.service.common.IManagerService;
import com.cqube.utils.DAOException;

public interface IProxyFactory extends IGenericFactory {
	public IAuthorRepositoryService getAuthorProxyImpl(IManagerService manager) throws DAOException;
	public IBookRepositoryService getBookProxyImpl(IManagerService manager) throws DAOException;
}
