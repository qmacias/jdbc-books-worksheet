package com.cqube.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.cqube.model.Relationship;
import com.cqube.model.Relationship.PrimaryKey;
import com.cqube.persistence.common.IManagerDAO;
import com.cqube.service.IRelationshipRepositoryService;
import com.cqube.utils.DAOException;

public class RelationshipRepositoryServiceImpl implements IRelationshipRepositoryService {

	private IManagerDAO daoManager;
	
	public RelationshipRepositoryServiceImpl(IManagerDAO daoManager) {
		this.daoManager = daoManager;
	}

	@Override
	public Relationship create(long book, long author) throws DAOException, SQLException {
		Relationship relation = new Relationship(book, author);
		daoManager.getRelationshipDAO().insert(relation);
		return relation;
	}

	@Override
	public Relationship update(long book, long author) throws DAOException {
		Relationship relation = daoManager.getRelationshipDAO().find(new PrimaryKey(book, author));
		return relation;
	}

	@Override
	public void delete(PrimaryKey id) throws DAOException, SQLException {
		Relationship relation = new Relationship(id);
		daoManager.getRelationshipDAO().delete(relation);
	}

	@Override
	public Relationship find(PrimaryKey id) throws DAOException {
		return daoManager.getRelationshipDAO().find(id);
	}

	@Override
	public List<Relationship> listAll() throws DAOException {
		return daoManager.getRelationshipDAO().findAll();
	}

	@Override
	public List<Relationship> listAllAuthorsByBook(Long book) throws DAOException {
		return daoManager.getRelationshipDAO().findAllAuthorsByBook(book);
	}

	@Override
	public List<Relationship> listAllBooksByAuthor(Long author) throws DAOException {
		return daoManager.getRelationshipDAO().findAllBooksByAuthor(author);
	}	
	
}
