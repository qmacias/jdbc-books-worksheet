package com.cqube.service.proxy.common;

import com.cqube.service.IAuthorRepositoryService;
import com.cqube.service.IBookRepositoryService;
import com.cqube.utils.DAOException;

public interface IManagerProxy {
	public IAuthorRepositoryService getAuthorProxy() throws DAOException;
	public IBookRepositoryService getBookProxy() throws DAOException;
}
