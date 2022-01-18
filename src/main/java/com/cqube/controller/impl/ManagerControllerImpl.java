package com.cqube.controller.impl;

import com.cqube.controller.IAuthorRepositoryController;
import com.cqube.controller.IBookRepositoryController;
import com.cqube.controller.IRelationshipRepositoryController;
import com.cqube.controller.common.IManagerController;
import com.cqube.service.proxy.common.IManagerProxy;
import com.cqube.utils.ControllerFactory;
import com.cqube.utils.DAOException;

public class ManagerControllerImpl implements IManagerController {

	private IManagerProxy manager;
	private IAuthorRepositoryController authorController = null;
	private IBookRepositoryController bookController = null;
	private IRelationshipRepositoryController relationshipController = null;

	public ManagerControllerImpl(IManagerProxy manager) {
		this.manager = manager;
	}
	
	@Override
	public IAuthorRepositoryController getAuthorController() throws DAOException {
		if (authorController == null) {
			authorController = ControllerFactory.getAuthorControllerImpl(manager);
		}
		return authorController;
	}

	@Override
	public IBookRepositoryController getBookController() throws DAOException {
		if (bookController == null) {
			bookController = ControllerFactory.getBookControllerImpl(manager);
		}
		return bookController;
	}

	@Override
	public IRelationshipRepositoryController getRelationshipController() throws DAOException {
		if (relationshipController  == null) {
			relationshipController = ControllerFactory.getRelationshipControllerImpl(manager);
		}
		return relationshipController;
	}

}
