package com.cqube.controller.common;

import com.cqube.controller.IAuthorRepositoryController;
import com.cqube.controller.IBookRepositoryController;
import com.cqube.controller.IRelationshipRepositoryController;
import com.cqube.utils.DAOException;

public interface IManagerController {
	public IAuthorRepositoryController getAuthorController() throws DAOException;
	public IBookRepositoryController getBookController() throws DAOException;
	public IRelationshipRepositoryController getRelationshipController() throws DAOException;
}
