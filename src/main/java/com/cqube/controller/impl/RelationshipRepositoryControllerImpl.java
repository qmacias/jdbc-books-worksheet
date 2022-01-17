package com.cqube.controller.impl;

import java.sql.SQLException;
import java.util.List;

import com.cqube.controller.IRelationshipRepositoryController;
import com.cqube.model.Relationship;
import com.cqube.model.Relationship.PrimaryKey;
import com.cqube.service.common.IManagerService;
import com.cqube.utils.DAOException;

public class RelationshipRepositoryControllerImpl implements IRelationshipRepositoryController {

	private Relationship relationship;
	private List<Relationship> relationshipList;
	private IManagerService serviceManager;
	
	public RelationshipRepositoryControllerImpl(IManagerService serviceManager) {
		this.serviceManager = serviceManager;
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
		serviceManager.getRelationshipService().create(book, author);
		//Refresh
		selectAll();
		return null;
	}

	@Override
	public Relationship edit(long book, long author) throws DAOException {
		serviceManager.getRelationshipService().update(book, author);
		//Refresh list
		selectAll();
		return null;
	}
	
	@Override
	public Relationship remove(PrimaryKey id) throws DAOException, SQLException {
		serviceManager.getRelationshipService().delete(id);
		//Refresh list
		selectAll();
		return null;
	}

	@Override
	public Relationship select(PrimaryKey id) throws DAOException {
		clearRelationship();
		//Select a relationship
		setRelationship(serviceManager.getRelationshipService().find(id));
		return null;
	}

	@Override
	public List<Relationship> selectAll() throws DAOException {
		clearRelationshipList();
		//Select all relationships
		setRelationshipList(serviceManager.getRelationshipService().listAll());
		return null;
	}

	@Override
	public List<Relationship> selectAllBooksByAuthor(Long author) throws DAOException {
		clearRelationshipList();
		//Select all authors according to a book
		setRelationshipList(serviceManager.getRelationshipService().listAllBooksByAuthor(author));
		return null;
	}

	@Override
	public List<Relationship> selectAllAuthorsByBook(Long book) throws DAOException {
		clearRelationshipList();
		//Select all books according to an author
		setRelationshipList(serviceManager.getRelationshipService().listAllAuthorsByBook(book));
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
