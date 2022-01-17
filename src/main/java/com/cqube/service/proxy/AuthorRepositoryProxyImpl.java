package com.cqube.service.proxy;

import java.sql.SQLException;
import java.util.List;

import com.cqube.model.Author;
import com.cqube.service.IAuthorRepositoryService;
import com.cqube.service.common.IManagerService;
import com.cqube.utils.DAOException;

public class AuthorRepositoryProxyImpl implements IAuthorRepositoryService {

	private IManagerService realService;
	
	public AuthorRepositoryProxyImpl(IManagerService realService) {
		this.realService = realService;
	}

	@Override
	public Author create(String name) throws DAOException, SQLException {
		return realService.getAuthorService().create(name);
	}
	
	@Override
	public Author update(Long id, String name) throws DAOException, SQLException {
		return realService.getAuthorService().update(id, name);
	}
	
	@Override
	public int delete(Long id) throws DAOException, SQLException {
		return realService.getAuthorService().delete(id);
	}

	@Override
	public Author find(Long id) throws DAOException {
		return realService.getAuthorService().find(id);
	}

	@Override
	public Author findByName(String name) throws DAOException {
		return realService.getAuthorService().findByName(name);
	}
	
	@Override
	public List<Author> listAll() throws DAOException {
		return realService.getAuthorService().listAll();
	}

	@Override
	public List<Author> listAllByBook(Long book) throws DAOException {
		return realService.getAuthorService().listAllByBook(book);
	}

}
