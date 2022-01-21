package com.cqube.controller.impl;

import java.sql.SQLException;
import java.util.List;

import com.cqube.controller.IBookRepositoryController;
import com.cqube.model.Book;
import com.cqube.service.proxy.common.IManagerProxy;
import com.cqube.utils.DAOException;
import com.cqube.view.BookView;

public class BookRepositoryControllerImpl implements IBookRepositoryController {

	private Book bookModel;
	private BookView bookView;
	private IManagerProxy proxyManager;

	public BookRepositoryControllerImpl(IManagerProxy manager) {
		this.proxyManager = manager;
	}
	
	public String getTitle() {
		return bookModel.getTitle();
	}
	
	public void setTitle(String title) {
		this.bookModel.setTitle(title);
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

	@Override
	public void printTicket() throws DAOException {
		selectAll().forEach((author) -> {
			bookModel = author;
			bookView = new BookView();
			updateView();
		});
	}

	@Override
	public void updateView() {
		bookView.printBookInfo(bookModel.getTitle(), bookModel.getIsbn());
	}

}
