package com.cqube.persistence;

import java.util.List;

import com.cqube.model.Author;
import com.cqube.persistence.common.IGenericDAO;
import com.cqube.utils.DAOException;

public interface IAuthorRepositoryDAO extends IGenericDAO<Author, Long> {
	public Author findByName(String name) throws DAOException;
	public List<Author> findAllByBook(Long book) throws DAOException;
}
