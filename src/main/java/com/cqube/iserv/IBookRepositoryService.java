package com.cqube.iserv;

import java.util.List;

import com.cqube.model.Book;
import com.cqube.utils.DAOException;

public interface IBookRepositoryService extends IGenericService<Book> {
	public List<Book> listByAuthor(Long author) throws DAOException;
}
