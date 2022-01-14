package com.cqube.controller;

import java.util.List;

import com.cqube.controller.common.IGenericController;
import com.cqube.model.Book;
import com.cqube.utils.DAOException;

public interface IBookRepositoryController extends IGenericController<Book> {
	public List<Book> selectAllByAuthor(Long author) throws DAOException;
}
