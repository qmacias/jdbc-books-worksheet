package com.cqube.service.common;

import com.cqube.service.IAuthorRepositoryService;
import com.cqube.service.IBookRepositoryService;
import com.cqube.service.IRelationshipRepositoryService;
import com.cqube.utils.DAOException;

public interface IManagerService {
	public IAuthorRepositoryService getAuthorService() throws DAOException;
    public IBookRepositoryService getBookService() throws DAOException;
    public IRelationshipRepositoryService getRelationshipService() throws DAOException;
}
