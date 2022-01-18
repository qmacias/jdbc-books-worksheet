package com.cqube.controller.impl;

import java.sql.SQLException;
import java.util.List;

import com.cqube.controller.IRelationshipRepositoryController;
import com.cqube.model.Relationship;
import com.cqube.model.Relationship.PrimaryKey;
import com.cqube.service.proxy.common.IManagerProxy;
import com.cqube.utils.DAOException;

public class RelationshipRepositoryControllerImpl implements IRelationshipRepositoryController {

	private Relationship relationship;
	private List<Relationship> relationshipList;
	private IManagerProxy proxyManager;
	
	public RelationshipRepositoryControllerImpl(IManagerProxy proxyManager) {
		this.proxyManager = proxyManager;
	}
	
	@Override
	public Relationship getRelationship() {
		return relationship;
	}

	@Override
	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
	}

	@Override
	public List<Relationship> getRelationshipList() {
		return relationshipList;
	}

	@Override
	public void setRelationshipList(List<Relationship> relationshipList) {
		this.relationshipList = relationshipList;
	}

	@Override
	public Relationship add(long book, long author) throws DAOException, SQLException {
		proxyManager.getRelationshipProxy().create(book, author);
		//Refresh
		selectAll();
		return null;
	}

	@Override
	public Relationship edit(long book, long author) throws DAOException {
		proxyManager.getRelationshipProxy().update(book, author);
		//Refresh list
		selectAll();
		return null;
	}
	
	@Override
	public Relationship remove(PrimaryKey id) throws DAOException, SQLException {
		proxyManager.getRelationshipProxy().delete(id);
		//Refresh list
		selectAll();
		return null;
	}

	@Override
	public Relationship select(PrimaryKey id) throws DAOException {
		clearRelationship();
		//Select a relationship
		setRelationship(proxyManager.getRelationshipProxy().find(id));
		return null;
	}

	@Override
	public List<Relationship> selectAll() throws DAOException {
		clearRelationshipList();
		//Select all relationships
		setRelationshipList(proxyManager.getRelationshipProxy().listAll());
		return null;
	}

	@Override
	public List<Relationship> selectAllBooksByAuthor(long author) throws DAOException {
		clearRelationshipList();
		//Select all authors according to a book
		setRelationshipList(proxyManager.getRelationshipProxy().listAllBooksByAuthor(author));
		return null;
	}

	@Override
	public List<Relationship> selectAllAuthorsByBook(long book) throws DAOException {
		clearRelationshipList();
		//Select all books according to an author
		setRelationshipList(proxyManager.getRelationshipProxy().listAllAuthorsByBook(book));
		return null;
	}
	
	private void clearRelationship() {
		if (!(relationship == null)) {
			relationship = null;
		}
	}
	
	private void clearRelationshipList() {
		if (!(relationshipList == null)) {
			relationshipList.clear();
		}
	}

}
