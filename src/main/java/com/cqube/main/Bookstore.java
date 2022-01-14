package com.cqube.main;

import com.cqube.connection.ConnectionProvider;
import com.cqube.controller.impl.AuthorRepositoryControllerImpl;
import com.cqube.controller.impl.BookRepositoryControllerImpl;
import com.cqube.model.Book;
import com.cqube.persistence.impl.ManagerDAOImpl;
import com.cqube.service.impl.ManagerServiceImpl;
import com.cqube.utils.DAOException;

public class Bookstore {

	public static void main(String[] args) {
		try {
			BookRepositoryControllerImpl bookController = new BookRepositoryControllerImpl(new ManagerServiceImpl(new ManagerDAOImpl()));
			AuthorRepositoryControllerImpl authorController = new AuthorRepositoryControllerImpl(new ManagerServiceImpl(new ManagerDAOImpl()));
			bookController.selectAll();
			for (Book b : bookController.getBookList()) {
				System.out.println("Book: " + b.getTitle());
				authorController.selectAllByBook(b.getId());
				System.out.println("Authors: " + authorController.getAuthorList());
			}
		} catch (DAOException e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.freeConnection();
		}
	}

}