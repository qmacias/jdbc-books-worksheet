package com.cqube.service.impl;

import java.util.List;

import com.cqube.model.Book;
import com.cqube.persistence.common.IManagerDAO;
import com.cqube.service.IBookRepositoryService;
import com.cqube.utils.DAOException;

public class BookRepositoryServiceImpl implements IBookRepositoryService {

	private IManagerDAO manager;

	public BookRepositoryServiceImpl(IManagerDAO manager) {
		super();
		this.manager = manager;
	}

	@Override
	public List<Book> list() throws DAOException {
		return manager.getBookDAO().findAll();
	}

	@Override
	public List<Book> listByAuthor(Long author) throws DAOException {
		return manager.getBookDAO().findAllByAuthor(author);
	}

}
