package com.cqube.controller;

import java.sql.SQLException;
import java.util.List;

import com.cqube.controller.common.IGenericController;
import com.cqube.model.Relationship;
import com.cqube.utils.DAOException;

public interface IRelationshipRepositoryController extends IGenericController<Relationship, Relationship.PrimaryKey> {
	public Relationship getRelationship();
	public void setRelationship(Relationship relationship);
	public List<Relationship> getRelationshipList();
	public void setRelationshipList(List<Relationship> relationshipList);
	public Relationship add(long book, long author) throws DAOException, SQLException;
	public Relationship edit(long book, long author) throws DAOException;
	public List<Relationship> selectAllBooksByAuthor(Long author) throws DAOException;
	public List<Relationship> selectAllAuthorsByBook(Long book) throws DAOException;
}
