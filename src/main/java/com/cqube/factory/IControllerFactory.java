package com.cqube.factory;

import com.cqube.controller.IAuthorRepositoryController;
import com.cqube.controller.IBookRepositoryController;
import com.cqube.factory.common.IGenericFactory;
import com.cqube.service.common.IManagerService;
import com.cqube.utils.DAOException;

public interface IControllerFactory extends IGenericFactory {
	public IAuthorRepositoryController getAuthorControllerImpl(IManagerService manager) throws DAOException;
	public IBookRepositoryController getBookControllerImpl(IManagerService manager) throws DAOException;
}
