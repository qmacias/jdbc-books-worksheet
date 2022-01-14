package com.cqube.service;

import java.util.List;

import com.cqube.model.Author;
import com.cqube.service.common.IGenericService;
import com.cqube.utils.DAOException;

public interface IAuthorRepositoryService extends IGenericService<Author> {
	public List<Author> listByBook(Long book) throws DAOException;
}
