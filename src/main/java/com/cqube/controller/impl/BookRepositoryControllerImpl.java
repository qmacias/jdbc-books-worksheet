package com.cqube.controller.impl;

import java.util.List;

import com.cqube.controller.IBookRepositoryController;
import com.cqube.model.Book;
import com.cqube.service.common.IManagerService;
import com.cqube.utils.DAOException;

public class BookRepositoryControllerImpl implements IBookRepositoryController {

	private Book book;
	private List<Book> bookList;
	private IManagerService manager;

	public BookRepositoryControllerImpl(IManagerService manager) {
		this.manager = manager;
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
	public Book add(String title, String isbn) throws DAOException {
		manager.getBookService().create(title, isbn);
		//Refresh list
		selectAll();
		return null;
	}
	
	@Override
	public Book edit(Long id, String title, String isbn) throws DAOException {
		manager.getBookService().update(id, title, isbn);
		//Refresh list
		selectAll();
		return null;
	}
	
	@Override
	public Book remove(Long id) throws DAOException {
		manager.getBookService().delete(id);
		//Refresh list
		selectAll();
		return null;
	}

	@Override
	public Book select(Long id) throws DAOException {
		setBook(manager.getBookService().find(id));
		return null;
	}

	@Override
	public List<Book> selectAll() throws DAOException {
		clearBookList();
		//List all books
		setBookList(manager.getBookService().listAll());
		return null;
	}

	@Override
	public List<Book> selectAllByAuthor(Long author) throws DAOException {
		clearBookList();
		//List books according to an author
		setBookList(manager.getBookService().listAllByAuthor(author));
		return null;
	}
	
	private void clearBookList() {
		if (!(bookList == null)) {
			bookList.clear();
		}
	}

}
