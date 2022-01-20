package com.cqube.controller;

import java.sql.SQLException;
import java.util.List;

import com.cqube.controller.common.IGenericController;
import com.cqube.model.Book;
import com.cqube.utils.DAOException;

public interface IBookRepositoryController extends IGenericController<Book, Long> {
	public Book add(String title, String isbn) throws DAOException, SQLException;
	public void edit(Long id, String title, String isbn) throws DAOException, SQLException;
	public Book selectByTitle(String title) throws DAOException;
	public List<Book> selectAllByAuthor(Long author) throws DAOException;
}
