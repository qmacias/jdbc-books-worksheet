package com.cqube.service;

import java.util.List;

import com.cqube.model.Book;
import com.cqube.service.common.IGenericService;
import com.cqube.utils.DAOException;

public interface IBookRepositoryService extends IGenericService<Book> {
	public Book create(String title, String isbn) throws DAOException;
	public Book update(Long id, String title, String isbn) throws DAOException;
	public List<Book> listAllByAuthor(Long author) throws DAOException;
}
