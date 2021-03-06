package com.cqube.service.impl;

import com.cqube.persistence.common.IManagerDAO;
import com.cqube.service.IAuthorRepositoryService;
import com.cqube.service.IBookRepositoryService;
import com.cqube.service.IRelationshipRepositoryService;
import com.cqube.service.common.IManagerService;
import com.cqube.utils.DAOException;
import com.cqube.utils.ServiceFactory;

public class ManagerServiceImpl implements IManagerService {

	private IManagerDAO manager;
	private IAuthorRepositoryService authorService = null;
	private IBookRepositoryService bookService = null;
	private IRelationshipRepositoryService relationshipService = null;

	public ManagerServiceImpl(IManagerDAO manager) {
		this.manager = manager;
	}

	@Override
	public IAuthorRepositoryService getAuthorService() throws DAOException {
		if (authorService == null) {
			authorService = ServiceFactory.getAuthorServiceImpl(manager);
		}
		return authorService;
	}

	@Override
	public IBookRepositoryService getBookService() throws DAOException {
		if (bookService == null) {
			bookService = ServiceFactory.getBookServiceImpl(manager);
		}
		return bookService;
	}

	@Override
	public IRelationshipRepositoryService getRelationshipService() throws DAOException {
		if (relationshipService == null) {
			relationshipService = ServiceFactory.getRelationshipServiceImpl(manager);
		}
		return relationshipService;
	}

}
