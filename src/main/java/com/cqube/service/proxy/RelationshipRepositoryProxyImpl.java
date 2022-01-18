package com.cqube.service.proxy;

import java.sql.SQLException;
import java.util.List;

import com.cqube.model.Relationship;
import com.cqube.model.Relationship.PrimaryKey;
import com.cqube.service.IRelationshipRepositoryService;
import com.cqube.service.common.IManagerService;
import com.cqube.utils.DAOException;

public class RelationshipRepositoryProxyImpl implements IRelationshipRepositoryService {

	private IManagerService realServiceManager;
	
	public RelationshipRepositoryProxyImpl(IManagerService realServiceManager) {
		this.realServiceManager = realServiceManager;
	}

	@Override
	public Relationship create(long book, long author) throws DAOException, SQLException {
		return realServiceManager.getRelationshipService().create(book, author);
	}

	@Override
	public Relationship update(long book, long author) throws DAOException {
		return realServiceManager.getRelationshipService().update(book, author);
	}
	
	@Override
	public int delete(PrimaryKey id) throws DAOException, SQLException {
		return realServiceManager.getRelationshipService().delete(id);
	}

	@Override
	public Relationship find(PrimaryKey id) throws DAOException {
		return realServiceManager.getRelationshipService().find(id);
	}

	@Override
	public List<Relationship> listAll() throws DAOException {
		return realServiceManager.getRelationshipService().listAll();
	}

	@Override
	public List<Relationship> listAllAuthorsByBook(Long book) throws DAOException {
		return realServiceManager.getRelationshipService().listAllAuthorsByBook(book);
	}

	@Override
	public List<Relationship> listAllBooksByAuthor(Long author) throws DAOException {
		return realServiceManager.getRelationshipService().listAllBooksByAuthor(author);
	}

}
