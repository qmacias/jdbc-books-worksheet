package com.cqube.utils;

import com.cqube.controller.IAuthorRepositoryController;
import com.cqube.controller.IBookRepositoryController;
import com.cqube.controller.IRelationshipRepositoryController;
import com.cqube.controller.impl.AuthorRepositoryControllerImpl;
import com.cqube.controller.impl.BookRepositoryControllerImpl;
import com.cqube.controller.impl.RelationshipRepositoryControllerImpl;
import com.cqube.service.proxy.common.IManagerProxy;

public class ControllerFactory {

	public static IAuthorRepositoryController getAuthorControllerImpl(IManagerProxy manager) throws DAOException {
		return new AuthorRepositoryControllerImpl(manager);
	}

	public static IBookRepositoryController getBookControllerImpl(IManagerProxy manager) throws DAOException {
		return new BookRepositoryControllerImpl(manager);
	}

	public static IRelationshipRepositoryController getRelationshipControllerImpl(IManagerProxy manager) throws DAOException {
		return new RelationshipRepositoryControllerImpl(manager);
	}

}
