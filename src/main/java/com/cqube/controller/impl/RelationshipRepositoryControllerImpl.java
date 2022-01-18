package com.cqube.controller.impl;

import java.sql.SQLException;
import java.util.List;

import com.cqube.controller.IRelationshipRepositoryController;
import com.cqube.model.Relationship;
import com.cqube.model.Relationship.PrimaryKey;
import com.cqube.service.proxy.common.IManagerProxy;
import com.cqube.utils.DAOException;

public class RelationshipRepositoryControllerImpl implements IRelationshipRepositoryController {

	private IManagerProxy proxyManager;
	
	public RelationshipRepositoryControllerImpl(IManagerProxy proxyManager) {
		this.proxyManager = proxyManager;
	}
	
	@Override
	public void add(long book, long author) throws DAOException, SQLException {
		proxyManager.getRelationshipProxy().create(book, author);
		selectAll();
	}

	@Override
	public void edit(long book, long author) throws DAOException {
		proxyManager.getRelationshipProxy().update(book, author);
		selectAll();
	}
	
	@Override
	public void remove(PrimaryKey id) throws DAOException, SQLException {
		proxyManager.getRelationshipProxy().delete(id);
		selectAll();
	}

	@Override
	public Relationship select(PrimaryKey id) throws DAOException {
		return proxyManager.getRelationshipProxy().find(id);
	}

	@Override
	public List<Relationship> selectAll() throws DAOException {
		return proxyManager.getRelationshipProxy().listAll();
	}

	@Override
	public List<Relationship> selectAllBooksByAuthor(long author) throws DAOException {
		return proxyManager.getRelationshipProxy().listAllBooksByAuthor(author);
	}

	@Override
	public List<Relationship> selectAllAuthorsByBook(long book) throws DAOException {
		return proxyManager.getRelationshipProxy().listAllAuthorsByBook(book);
	}

}
