package com.cqube.service;

import java.sql.SQLException;

import com.cqube.model.Author;
import com.cqube.service.common.IGenericService;
import com.cqube.utils.DAOException;

public interface IAuthorRepositoryService extends IGenericService<Author, Long> {
	public Author create(String name) throws DAOException, SQLException;
	public Author update(Long id, String name) throws DAOException, SQLException;
}
