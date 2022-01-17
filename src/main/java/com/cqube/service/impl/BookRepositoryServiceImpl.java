package com.cqube.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.cqube.model.Book;
import com.cqube.persistence.common.IManagerDAO;
import com.cqube.service.IBookRepositoryService;
import com.cqube.utils.DAOException;

public class BookRepositoryServiceImpl implements IBookRepositoryService {

	private IManagerDAO manager;

	public BookRepositoryServiceImpl(IManagerDAO manager) {
		this.manager = manager;
	}

	@Override
	public Book create(String title, String isbn) throws DAOException, SQLException {
		Book book = new Book(title, isbn);
		//Should be validated
		manager.getBookDAO().insert(book);
		return book;
	}
	
	@Override
	public Book update(Long id, String title, String isbn) throws DAOException, SQLException {
		Book book = manager.getBookDAO().find(id);
		book.setTitle(title);
		book.setIsbn(isbn);
		//Should be validated
		manager.getBookDAO().update(book);
		return book;
	}
	
	@Override
	public int delete(Long id) throws DAOException, SQLException {
		Book book = new Book(id, null, null);
		return manager.getBookDAO().delete(book);
	}

	@Override
	public Book find(Long id) throws DAOException {
		return manager.getBookDAO().find(id);
	}
	
	@Override
	public Book findByTitle(String title) throws DAOException {
		return manager.getBookDAO().findByTitle(title);
	}
	
	@Override
	public List<Book> listAll() throws DAOException {
		return manager.getBookDAO().findAll();
	}

	@Override
	public List<Book> listAllByAuthor(Long author) throws DAOException {
		return manager.getBookDAO().findAllByAuthor(author);
	}

}
