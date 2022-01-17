package com.cqube.service;

import java.sql.SQLException;
import java.util.List;

import com.cqube.model.Relationship;
import com.cqube.service.common.IGenericService;
import com.cqube.utils.DAOException;

public interface IRelationshipRepositoryService extends IGenericService<Relationship, Relationship.PrimaryKey> {
	public Relationship create(long book, long author) throws DAOException, SQLException;
	public Relationship update(long book, long author) throws DAOException;
	public List<Relationship> listAllAuthorsByBook(Long book) throws DAOException;
	public List<Relationship> listAllBooksByAuthor(Long author) throws DAOException;
}
