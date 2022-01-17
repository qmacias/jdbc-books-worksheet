package com.cqube.service.proxy;

import java.sql.SQLException;
import java.util.List;

import com.cqube.model.Book;
import com.cqube.service.IBookRepositoryService;
import com.cqube.service.common.IManagerService;
import com.cqube.utils.DAOException;

public class BookRepositoryProxyImpl implements IBookRepositoryService {

	private IManagerService realService;
	
	public BookRepositoryProxyImpl(IManagerService manager) {
		this.realService = manager;
	}

	@Override
	public Book create(String title, String isbn) throws DAOException, SQLException {
		return realService.getBookService().create(title, isbn);
	}

	@Override
	public Book update(Long id, String title, String isbn) throws DAOException, SQLException {
		return realService.getBookService().update(id, title, isbn);
	}
	
	@Override
	public int delete(Long id) throws DAOException, SQLException {
		return realService.getBookService().delete(id);
	}

	@Override
	public Book find(Long id) throws DAOException {
		return realService.getBookService().find(id);
	}
	
	@Override
	public Book findByTitle(String title) throws DAOException {
		return realService.getBookService().findByTitle(title);
	}

	@Override
	public List<Book> listAll() throws DAOException {
		return realService.getBookService().listAll();
	}

	@Override
	public List<Book> listAllByAuthor(Long author) throws DAOException {
		return realService.getBookService().listAllByAuthor(author);
	}

}
