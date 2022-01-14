package com.cqube.controller;

import java.util.List;

import com.cqube.controller.common.IGenericController;
import com.cqube.model.Author;
import com.cqube.utils.DAOException;

public interface IAuthorRepositoryController extends IGenericController<Author> {
	public Author add(String name) throws DAOException;
	public Author edit(Long id, String name) throws DAOException;
	public List<Author> selectAllByBook(Long book) throws DAOException;
}
