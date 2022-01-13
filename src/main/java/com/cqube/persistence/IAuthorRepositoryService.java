package com.cqube.persistence;

import java.util.List;

import com.cqube.model.Author;
import com.cqube.persistence.commons.IGenericService;
import com.cqube.utils.DAOException;

public interface IAuthorRepositoryService extends IGenericService<Author> {
	public List<Author> listByBook(Long book) throws DAOException;
}
