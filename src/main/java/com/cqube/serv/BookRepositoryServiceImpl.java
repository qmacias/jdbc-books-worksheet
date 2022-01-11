package com.cqube.serv;

import java.util.List;

import com.cqube.dao.ManagerDAOImpl;
import com.cqube.idao.IManagerDAO;
import com.cqube.iserv.IAuthorRepositoryService;
import com.cqube.iserv.IBookRepositoryService;
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
	public void searchAll(ILibraryService service) throws DAOException {
		for (Book b : list()) {
			System.out.println("Book: " + b.getTitle());
			System.out.println("Authors: " + ((IAuthorRepositoryService) service).listByBook(b.getId()) + "\n");
		}
	}

}
