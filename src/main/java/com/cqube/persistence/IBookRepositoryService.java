package com.cqube.persistence;

import java.util.List;

import com.cqube.model.Book;
import com.cqube.persistence.commons.IGenericService;
import com.cqube.utils.DAOException;

public interface IBookRepositoryService extends IGenericService<Book> {
	public List<Book> listByAuthor(Long author) throws DAOException;
}
