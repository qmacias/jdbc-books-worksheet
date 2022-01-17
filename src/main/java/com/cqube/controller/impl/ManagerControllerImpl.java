package com.cqube.controller.impl;

import com.cqube.controller.IAuthorRepositoryController;
import com.cqube.controller.IBookRepositoryController;
import com.cqube.controller.IRelationshipRepositoryController;
import com.cqube.controller.common.IManagerController;
import com.cqube.factory.IControllerFactory;
import com.cqube.factory.impl.ControllerFactoryImpl;
import com.cqube.service.common.IManagerService;
import com.cqube.utils.DAOException;

public class ManagerControllerImpl implements IManagerController {

	private IManagerService manager;
	private IControllerFactory controllerFactory;
	private IAuthorRepositoryController authorController = null;
	private IBookRepositoryController bookController = null;
	private IRelationshipRepositoryController relationshipController = null;

	public ManagerControllerImpl(IManagerService manager) {
		this.manager = manager;
		this.controllerFactory = new ControllerFactoryImpl();
	}
	
	@Override
	public IAuthorRepositoryController getAuthorController() throws DAOException {
		if (authorController == null) {
			authorController = controllerFactory.getAuthorControllerImpl(manager);
		}
		return authorController;
	}

	@Override
	public IBookRepositoryController getBookController() throws DAOException {
		if (bookController == null) {
			bookController = controllerFactory.getBookControllerImpl(manager);
		}
		return bookController;
	}

	@Override
	public IRelationshipRepositoryController getRelationshipController() throws DAOException {
		if (relationshipController  == null) {
			relationshipController = controllerFactory.getRelationshipControllerImpl(manager);
		}
		return relationshipController;
	}

}
