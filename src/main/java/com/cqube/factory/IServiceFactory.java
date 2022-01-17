package com.cqube.factory;

import com.cqube.factory.common.IGenericFactory;
import com.cqube.persistence.common.IManagerDAO;
import com.cqube.service.IAuthorRepositoryService;
import com.cqube.service.IBookRepositoryService;
import com.cqube.service.IRelationshipRepositoryService;
import com.cqube.utils.DAOException;

public interface IServiceFactory extends IGenericFactory {
	public IAuthorRepositoryService getAuthorServiceImpl(IManagerDAO manager) throws DAOException;
	public IBookRepositoryService getBookServiceImpl(IManagerDAO manager) throws DAOException;
	public IRelationshipRepositoryService getRelationshipServiceImpl(IManagerDAO manager) throws DAOException;
}
