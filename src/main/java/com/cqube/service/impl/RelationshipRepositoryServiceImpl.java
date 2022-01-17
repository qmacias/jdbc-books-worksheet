package com.cqube.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.cqube.model.Relationship;
import com.cqube.model.Relationship.PrimaryKey;
import com.cqube.persistence.common.IManagerDAO;
import com.cqube.service.IRelationshipRepositoryService;
import com.cqube.utils.DAOException;

public class RelationshipRepositoryServiceImpl implements IRelationshipRepositoryService {

	private IManagerDAO manager;
	
	public RelationshipRepositoryServiceImpl(IManagerDAO manager) {
		this.manager = manager;
	}

	@Override
	public Relationship create(long book, long author) throws DAOException, SQLException {
		Relationship relation = new Relationship(book, author);
		manager.getRelationshipDAO().insert(relation);
		return relation;
	}

	@Override
	public Relationship update(long book, long author) throws DAOException {
		Relationship relation = manager.getRelationshipDAO().find(new PrimaryKey(book, author));
		return relation;
	}

	@Override
	public int delete(PrimaryKey id) throws DAOException, SQLException {
		Relationship relation = new Relationship(id);
		return manager.getRelationshipDAO().delete(relation);
	}

	@Override
	public Relationship find(PrimaryKey id) throws DAOException {
		return manager.getRelationshipDAO().find(id);
	}

	@Override
	public List<Relationship> listAll() throws DAOException {
		return manager.getRelationshipDAO().findAll();
	}

	@Override
	public List<Relationship> listAllAuthorsByBook(Long book) throws DAOException {
		return manager.getRelationshipDAO().findAllAuthorsByBook(book);
	}

	@Override
	public List<Relationship> listAllBooksByAuthor(Long author) throws DAOException {
		return manager.getRelationshipDAO().findAllBooksByAuthor(author);
	}	
	
}
