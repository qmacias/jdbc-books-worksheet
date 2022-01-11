package com.cqube.serv;

import java.util.List;

import com.cqube.dao.ManagerDAOImpl;
import com.cqube.idao.IManagerDAO;
import com.cqube.iserv.IAuthorRepositoryService;
import com.cqube.main.ILibraryServices;
import com.cqube.model.Author;
import com.cqube.utils.DAOException;

public class AuthorRepositoryServiceImpl implements IAuthorRepositoryService, ILibraryServices {

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
	public void showAllsearches(ILibraryServices service) throws DAOException {
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
