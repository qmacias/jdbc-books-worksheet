package com.cqube.idao;

import java.util.List;

import com.cqube.model.Book;
import com.cqube.utils.DAOException;

public interface IBookRepositoryDAO extends IGenericDAO<Book, Long> {
	public List<Book> findAllByAuthor(Long author) throws DAOException;
}
