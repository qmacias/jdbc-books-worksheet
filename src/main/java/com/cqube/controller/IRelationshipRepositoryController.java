package com.cqube.controller;

import java.sql.SQLException;
import java.util.List;

import com.cqube.controller.common.IGenericController;
import com.cqube.model.Relationship;
import com.cqube.utils.DAOException;

public interface IRelationshipRepositoryController extends IGenericController<Relationship, Relationship.PrimaryKey> {
	public void add(long book, long author) throws DAOException, SQLException;
	public void edit(long book, long author) throws DAOException;
	public List<Relationship> selectAllBooksByAuthor(long author) throws DAOException;
	public List<Relationship> selectAllAuthorsByBook(long book) throws DAOException;
}
