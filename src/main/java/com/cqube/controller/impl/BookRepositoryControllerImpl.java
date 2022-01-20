package com.cqube.controller.impl;

import java.sql.SQLException;
import java.util.List;

import com.cqube.controller.IBookRepositoryController;
import com.cqube.model.Book;
import com.cqube.service.proxy.common.IManagerProxy;
import com.cqube.utils.DAOException;

public class BookRepositoryControllerImpl implements IBookRepositoryController {

	private IManagerProxy proxyManager;

	public BookRepositoryControllerImpl(IManagerProxy manager) {
		this.proxyManager = manager;
	}

	@Override
	public Book add(String title, String isbn) throws DAOException, SQLException {
		Book book = proxyManager.getBookProxy().create(title, isbn);
		selectAll();
		return book;
	}
	
	@Override
	public void edit(Long id, String title, String isbn) throws DAOException, SQLException {
		proxyManager.getBookProxy().update(id, title, isbn);
		selectAll();
	}
	
	@Override
	public void remove(Long id) throws DAOException, SQLException {
		proxyManager.getBookProxy().delete(id);
		selectAll();
	}

	@Override
	public Book select(Long id) throws DAOException {
		return proxyManager.getBookProxy().find(id);
	}

	@Override
	public List<Book> selectAll() throws DAOException {
		return proxyManager.getBookProxy().listAll();
	}

}
