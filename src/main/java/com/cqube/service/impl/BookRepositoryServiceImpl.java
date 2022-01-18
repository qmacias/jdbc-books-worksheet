package com.cqube.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.cqube.model.Book;
import com.cqube.persistence.common.IManagerDAO;
import com.cqube.service.IBookRepositoryService;
import com.cqube.utils.DAOException;

public class BookRepositoryServiceImpl implements IBookRepositoryService {

	private IManagerDAO daoManager;

	public BookRepositoryServiceImpl(IManagerDAO daoManager) {
		this.daoManager = daoManager;
	}

	@Override
	public Book create(String title, String isbn) throws DAOException, SQLException {
		Book book = new Book(title, isbn);
		//Should be validated
		daoManager.getBookDAO().insert(book);
		return book;
	}
	
	@Override
	public Book update(Long id, String title, String isbn) throws DAOException, SQLException {
		Book book = daoManager.getBookDAO().find(id);
		book.setTitle(title);
		book.setIsbn(isbn);
		//Should be validated
		daoManager.getBookDAO().update(book);
		return book;
	}
	
	@Override
	public int delete(Long id) throws DAOException, SQLException {
		Book book = new Book(id, null, null);
		return daoManager.getBookDAO().delete(book);
	}

	@Override
	public Book find(Long id) throws DAOException {
		return daoManager.getBookDAO().find(id);
	}
	
	@Override
	public Book findByTitle(String title) throws DAOException {
		return daoManager.getBookDAO().findByTitle(title);
	}
	
	@Override
	public List<Book> listAll() throws DAOException {
		return daoManager.getBookDAO().findAll();
	}

	@Override
	public List<Book> listAllByAuthor(Long author) throws DAOException {
		return daoManager.getBookDAO().findAllByAuthor(author);
	}

}
