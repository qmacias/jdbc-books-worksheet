package com.cqube.controller;

import java.sql.SQLException;

import com.cqube.controller.common.IGenericController;
import com.cqube.model.Author;
import com.cqube.utils.DAOException;

public interface IAuthorRepositoryController extends IGenericController<Author, Long> {
	public Author add(String name) throws DAOException, SQLException;
	public void edit(Long id, String name) throws DAOException, SQLException;
}
