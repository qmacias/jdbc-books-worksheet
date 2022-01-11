package com.cqube.idao;

import java.util.List;

import com.cqube.model.Author;
import com.cqube.utils.DAOException;

public interface IAuthorRepositoryDAO extends IGenericDAO<Author, Long> {
	public List<Author> findAllByBook(Long book) throws DAOException;
}
