package com.cqube.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.cqube.model.Author;
import com.cqube.persistence.common.IManagerDAO;
import com.cqube.service.IAuthorRepositoryService;
import com.cqube.utils.DAOException;

public class AuthorRepositoryServiceImpl implements IAuthorRepositoryService {

	private IManagerDAO daoManager;

	public AuthorRepositoryServiceImpl(IManagerDAO daoManager) {
		this.daoManager = daoManager;
	}
	
	@Override
	public Author create(String name) throws DAOException, SQLException {
		Author author = new Author(name);
		//Should be validated
		daoManager.getAuthorDAO().insert(author);
		return author;
	}
	
	@Override
	public Author update(Long id, String name) throws DAOException, SQLException {
		Author author = daoManager.getAuthorDAO().find(id);
		author.setName(name);
		//Should be validated
		daoManager.getAuthorDAO().update(author);
		return author;
	}

	@Override
	public int delete(Long id) throws DAOException, SQLException {
		Author author = new Author(id, null);
		return daoManager.getAuthorDAO().delete(author);
	}

	@Override
	public Author find(Long id) throws DAOException {
		return daoManager.getAuthorDAO().find(id);
	}
	
	@Override
	public Author findByName(String name) throws DAOException {
		return daoManager.getAuthorDAO().findByName(name);
	}

	@Override
	public List<Author> listAll() throws DAOException {
		return daoManager.getAuthorDAO().findAll();
	}

	@Override
	public List<Author> listAllByBook(Long book) throws DAOException {
		return daoManager.getAuthorDAO().findAllByBook(book);
	}

}
