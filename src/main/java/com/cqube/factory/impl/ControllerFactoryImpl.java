package com.cqube.factory.impl;

import com.cqube.controller.IAuthorRepositoryController;
import com.cqube.controller.IBookRepositoryController;
import com.cqube.controller.IRelationshipRepositoryController;
import com.cqube.controller.impl.AuthorRepositoryControllerImpl;
import com.cqube.controller.impl.BookRepositoryControllerImpl;
import com.cqube.controller.impl.RelationshipRepositoryControllerImpl;
import com.cqube.factory.IControllerFactory;
import com.cqube.service.common.IManagerService;
import com.cqube.utils.DAOException;

public class ControllerFactoryImpl implements IControllerFactory {

	@Override
	public IAuthorRepositoryController getAuthorControllerImpl(IManagerService manager) throws DAOException {
		return new AuthorRepositoryControllerImpl(manager);
	}

	@Override
	public IBookRepositoryController getBookControllerImpl(IManagerService manager) throws DAOException {
		return new BookRepositoryControllerImpl(manager);
	}

	@Override
	public IRelationshipRepositoryController getRelationshipControllerImpl(IManagerService manager) throws DAOException {
		return new RelationshipRepositoryControllerImpl(manager);
	}

}
