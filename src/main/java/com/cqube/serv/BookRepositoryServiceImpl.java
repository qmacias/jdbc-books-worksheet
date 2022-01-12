package com.cqube.serv;

import java.util.List;

import com.cqube.dao.ManagerDAOImpl;
import com.cqube.idao.IManagerDAO;
import com.cqube.iserv.IBookRepositoryService;
import com.cqube.iserv.ILibraryService;
import com.cqube.model.Book;
import com.cqube.utils.DAOException;

public class BookRepositoryServiceImpl implements IBookRepositoryService, ILibraryService {

	private IManagerDAO manager;

	public BookRepositoryServiceImpl() throws DAOException {
		super();
		this.manager = new ManagerDAOImpl();
	}
	
	@Override
	public List<Book> list() throws DAOException {
		return manager.getBookDAO().findAll();
	}

	@Override
	public List<Book> listByAuthor(Long author) throws DAOException {
		return manager.getBookDAO().findAllByAuthor(author);
	}

	@Override
	public void showAllsearches(ILibraryService service) throws DAOException {
		for (Book b : list()) {
			System.out.println("Book: " + b.getTitle());
			service.showByParameter(b.getId());
		}
	}

	@Override
	public void showByParameter(Long parameter) throws DAOException {
		System.out.println("Authors: " + listByAuthor(parameter) + "\n");
	}

}
