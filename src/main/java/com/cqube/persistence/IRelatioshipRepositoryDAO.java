package com.cqube.persistence;

import java.util.List;

import com.cqube.model.Relationship;
import com.cqube.persistence.common.IGenericDAO;
import com.cqube.utils.DAOException;

public interface IRelatioshipRepositoryDAO extends IGenericDAO<Relationship, Relationship.PrimaryKey> {
	public List<Relationship> findAllAuthorsByBook(Long book) throws DAOException;
	public List<Relationship> findAllBooksByAuthor(Long author) throws DAOException;
}
