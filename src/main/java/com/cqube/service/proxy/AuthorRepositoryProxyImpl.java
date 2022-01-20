package com.cqube.service.proxy;

import java.sql.SQLException;
import java.util.List;

import com.cqube.model.Author;
import com.cqube.service.IAuthorRepositoryService;
import com.cqube.service.common.IManagerService;
import com.cqube.utils.DAOException;

public class AuthorRepositoryProxyImpl implements IAuthorRepositoryService {

	private IManagerService realServiceManager;
	
	public AuthorRepositoryProxyImpl(IManagerService realServiceManager) {
		this.realServiceManager = realServiceManager;
	}

	@Override
	public Author create(String name) throws DAOException, SQLException {
		Author author = realServiceManager.getAuthorService().create(name);
		if (author == null) {
			throw new NullPointerException("Null object: failed to create");
		}
		return author;
	}
	
	//Missing proxy evaluation
	@Override
	public Author update(Long id, String name) throws DAOException, SQLException {
		return realServiceManager.getAuthorService().update(id, name);
	}
	
	//Missing proxy evaluation
	@Override
	public void delete(Long id) throws DAOException, SQLException {
		realServiceManager.getAuthorService().delete(id);
	}

	@Override
	public Author find(Long id) throws DAOException {
		Author author = realServiceManager.getAuthorService().find(id);
		if (author == null) {
			throw new NullPointerException("Null object: failed to find");
		}
		return author;
	}
	
	@Override
	public List<Author> listAll() throws DAOException {
		List<Author> authors = realServiceManager.getAuthorService().listAll();
		if (authors == null) {
			throw new NullPointerException("Null collection: failed to list");
		}
		return authors;
	}

}
