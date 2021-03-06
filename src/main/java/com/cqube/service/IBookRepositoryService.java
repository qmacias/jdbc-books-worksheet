package com.cqube.service;

import java.sql.SQLException;

import com.cqube.model.Book;
import com.cqube.service.common.IGenericService;
import com.cqube.utils.DAOException;

public interface IBookRepositoryService extends IGenericService<Book, Long> {
	public Book create(String title, String isbn) throws DAOException, SQLException;
	public Book update(Long id, String title, String isbn) throws DAOException, SQLException;
}
