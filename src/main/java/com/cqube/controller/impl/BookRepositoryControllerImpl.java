package com.cqube.controller.impl;

import java.sql.SQLException;
import java.util.List;

import com.cqube.controller.IBookRepositoryController;
import com.cqube.model.Book;
import com.cqube.service.proxy.common.IManagerProxy;
import com.cqube.utils.DAOException;

public class BookRepositoryControllerImpl implements IBookRepositoryController {

	private Book book;
	private List<Book> bookList;
	private IManagerProxy proxyManager;

	public BookRepositoryControllerImpl(IManagerProxy manager) {
		this.proxyManager = manager;
	}

	@Override
	public Book getBook() {
		return book;
	}

	@Override
	public void setBook(Book book) {
		this.book = book;
	}
	
	@Override
	public List<Book> getBookList() {
		return bookList;
	}

	@Override
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
	@Override
	public Book add(String title, String isbn) throws DAOException, SQLException {
		proxyManager.getBookProxy().create(title, isbn);
		//Refresh list
		selectAll();
		return null;
	}
	
	@Override
	public Book edit(Long id, String title, String isbn) throws DAOException, SQLException {
		proxyManager.getBookProxy().update(id, title, isbn);
		//Refresh list
		selectAll();
		return null;
	}
	
	@Override
	public Book remove(Long id) throws DAOException, SQLException {
		proxyManager.getBookProxy().delete(id);
		//Refresh list
		selectAll();
		return null;
	}

	@Override
	public Book select(Long id) throws DAOException {
		clearBook();
		//Select a book
		setBook(proxyManager.getBookProxy().find(id));
		return null;
	}
	
	@Override
	public Book selectByTitle(String title) throws DAOException {
		clearBook();
		//Select a book by title
		setBook(proxyManager.getBookProxy().findByTitle(title));
		return null;
	}

	@Override
	public List<Book> selectAll() throws DAOException {
		clearBookList();
		//List all books
		setBookList(proxyManager.getBookProxy().listAll());
		return null;
	}

	@Override
	public List<Book> selectAllByAuthor(Long author) throws DAOException {
		clearBookList();
		//List books according to an author
		setBookList(proxyManager.getBookProxy().listAllByAuthor(author));
		return null;
	}
	
	private void clearBook() {
		if (!(book == null)) {
			book = null;
		}		
	}
	
	private void clearBookList() {
		if (!(bookList == null)) {
			bookList.clear();
		}
	}

}
