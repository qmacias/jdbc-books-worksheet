package com.cqube.service;

import java.sql.SQLException;
import java.util.List;

import com.cqube.model.Author;
import com.cqube.service.common.IGenericService;
import com.cqube.utils.DAOException;

public interface IAuthorRepositoryService extends IGenericService<Author, Long> {
	public Author create(String name) throws DAOException, SQLException;
	public Author update(Long id, String name) throws DAOException, SQLException;
	public Author findByName(String name) throws DAOException;
	public List<Author> listAllByBook(Long book) throws DAOException;
}
