package com.cqube.controller.impl;

import java.sql.SQLException;
import java.util.List;

import com.cqube.controller.IAuthorRepositoryController;
import com.cqube.model.Author;
import com.cqube.service.proxy.common.IManagerProxy;
import com.cqube.utils.DAOException;

public class AuthorRepositoryControllerImpl implements IAuthorRepositoryController {

	private IManagerProxy proxyManager;
	
	public AuthorRepositoryControllerImpl(IManagerProxy proxyManager) {
		this.proxyManager = proxyManager;
	}
	
	@Override
	public Author add(String name) throws DAOException, SQLException {
		Author author = proxyManager.getAuthorProxy().create(name);
		selectAll();
		return author;
	}
	
	@Override
	public void edit(Long id, String name) throws DAOException, SQLException {
		proxyManager.getAuthorProxy().update(id, name);
		selectAll();
	}
	
	@Override
	public void remove(Long id) throws DAOException, SQLException {
		proxyManager.getAuthorProxy().delete(id);
		selectAll();
	}

	@Override
	public Author select(Long id) throws DAOException {
		return proxyManager.getAuthorProxy().find(id);
	}

	@Override
	public Author selectByName(String name) throws DAOException {
		return proxyManager.getAuthorProxy().findByName(name);
	}
	
	@Override
	public List<Author> selectAll() throws DAOException {
		return proxyManager.getAuthorProxy().listAll();
	}

	@Override
	public List<Author> selectAllByBook(Long book) throws DAOException {
		return proxyManager.getAuthorProxy().listAllByBook(book);
	}

}
