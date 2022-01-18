package com.cqube.controller;

import java.sql.SQLException;
import java.util.List;

import com.cqube.controller.common.IGenericController;
import com.cqube.model.Author;
import com.cqube.utils.DAOException;

public interface IAuthorRepositoryController extends IGenericController<Author, Long> {
	public void add(String name) throws DAOException, SQLException;
	public void edit(Long id, String name) throws DAOException, SQLException;
	public Author selectByName(String name) throws DAOException;
	public List<Author> selectAllByBook(Long book) throws DAOException;
}
