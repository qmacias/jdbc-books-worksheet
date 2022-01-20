package com.cqube.service.proxy;

import java.sql.SQLException;
import java.util.List;

import com.cqube.model.Book;
import com.cqube.service.IBookRepositoryService;
import com.cqube.service.common.IManagerService;
import com.cqube.utils.DAOException;

public class BookRepositoryProxyImpl implements IBookRepositoryService {

	private IManagerService realServiceManager;
	
	public BookRepositoryProxyImpl(IManagerService realServiceManager) {
		this.realServiceManager = realServiceManager;
	}

	@Override
	public Book create(String title, String isbn) throws DAOException, SQLException {
		Book book = realServiceManager.getBookService().create(title, isbn);
		if (book  == null) {
			throw new NullPointerException("Null object: failed to create");
		}
		return book;
	}

	//Missing proxy evaluation
	@Override
	public Book update(Long id, String title, String isbn) throws DAOException, SQLException {
		return realServiceManager.getBookService().update(id, title, isbn);
	}
	
	//Missing proxy evaluation
	@Override
	public void delete(Long id) throws DAOException, SQLException {
		realServiceManager.getBookService().delete(id);
	}

	@Override
	public Book find(Long id) throws DAOException {
		Book book = realServiceManager.getBookService().find(id);
		if (book == null) {
			throw new NullPointerException("Null object: failed to find");
		}
		return book;
	}

	@Override
	public List<Book> listAll() throws DAOException {
		List<Book> books = realServiceManager.getBookService().listAll();
		if (books == null) {
			throw new NullPointerException("Null collection: failed to list");
		}
		return books;
	}

}
