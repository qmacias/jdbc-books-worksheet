package com.cqube.service.common;

import com.cqube.service.IAuthorRepositoryService;
import com.cqube.service.IBookRepositoryService;
import com.cqube.utils.DAOException;

public interface IManagerService {
	public IAuthorRepositoryService getAuthorService() throws DAOException;
    public IBookRepositoryService getBookService() throws DAOException;
}
