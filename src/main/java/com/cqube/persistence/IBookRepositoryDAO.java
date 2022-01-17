package com.cqube.persistence;

import java.util.List;

import com.cqube.model.Book;
import com.cqube.persistence.common.IGenericDAO;
import com.cqube.utils.DAOException;

public interface IBookRepositoryDAO extends IGenericDAO<Book, Long> {
	public Book findByTitle(String title) throws DAOException;
	public List<Book> findAllByAuthor(Long author) throws DAOException;
}
