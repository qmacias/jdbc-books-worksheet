package com.cqube.service.impl;

import java.util.List;

import com.cqube.model.Author;
import com.cqube.persistence.common.IManagerDAO;
import com.cqube.service.IAuthorRepositoryService;
import com.cqube.utils.DAOException;

public class AuthorRepositoryServiceImpl implements IAuthorRepositoryService {

	private IManagerDAO manager;

	public AuthorRepositoryServiceImpl(IManagerDAO manager) {
		super();
		this.manager = manager;
	}

	@Override
	public List<Author> list() throws DAOException {
		return manager.getAuthorDAO().findAll();
	}

	@Override
	public List<Author> listByBook(Long book) throws DAOException {
		return manager.getAuthorDAO().findAllByBook(book);
	}

}
