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
		super();
		this.manager = manager;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	@Override
	public List<Book> selectAll() throws DAOException {
		if (!(bookList == null)) {
			bookList.clear();
		}
		bookList = manager.getBookService().list();
		return null;
	}

	@Override
	public List<Book> selectAllByAuthor(Long author) throws DAOException {
		if (!(bookList == null)) {
			bookList.clear();
		}
		//List books according to an author
		bookList = manager.getBookService().listByAuthor(author);
		return null;
	}

}
