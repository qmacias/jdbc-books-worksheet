package com.cqube.persistence.impl;

import java.util.List;

import com.cqube.model.Author;
import com.cqube.persistence.IAuthorRepositoryService;
import com.cqube.persistence.commons.ILibraryService;
import com.cqube.persistence.commons.IManagerDAO;
import com.cqube.utils.DAOException;

public class AuthorRepositoryServiceImpl implements IAuthorRepositoryService, ILibraryService {

	private IManagerDAO manager;

	public AuthorRepositoryServiceImpl() throws DAOException {
		super();
		this.manager = new ManagerDAOImpl();
	}

	@Override
	public List<Author> list() throws DAOException {
		return manager.getAuthorDAO().findAll();
	}

	@Override
	public List<Author> listByBook(Long book) throws DAOException {
		return manager.getAuthorDAO().findAllByBook(book);
	}

	@Override
	public void showAllsearches(ILibraryService service) throws DAOException {
		for (Author a : list()) {
			System.out.println("Author: " + a.getName());
			service.showByParameter(a.getId());
		}
	}

	@Override
	public void showByParameter(Long parameter) throws DAOException {
		System.out.println("Books: " + listByBook(parameter) + "\n");
	}
}
