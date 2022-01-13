package com.cqube.persistence;

import java.util.List;

import com.cqube.model.Book;
import com.cqube.persistence.commons.IGenericDAO;
import com.cqube.utils.DAOException;

public interface IBookRepositoryDAO extends IGenericDAO<Book> {
	public List<Book> findAllByAuthor(Long author) throws DAOException;
}
