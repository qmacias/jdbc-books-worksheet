package com.cqube.main;

import java.sql.SQLException;

import com.cqube.connection.ConnectionProvider;
import com.cqube.controller.common.IManagerController;
import com.cqube.controller.impl.ManagerControllerImpl;
import com.cqube.model.Author;
import com.cqube.model.Book;
import com.cqube.persistence.impl.ManagerDAOImpl;
import com.cqube.service.impl.ManagerServiceImpl;
import com.cqube.utils.DAOException;

public class Bookstore {

	public static void main(String[] args) {
		try {
			//CREATE MANAGER CONTROLLER
			IManagerController manager = new ManagerControllerImpl(new ManagerServiceImpl(new ManagerDAOImpl()));
			//CREATE AN AUTHOR
			manager.getAuthorController().add("William Shakespeare");
			//manager.getAuthorController().add("Enrich Gamma"); //duplicated name error
			manager.getAuthorController().select(10L);
			System.out.println(manager.getAuthorController().getAuthor());
			System.out.println(manager.getAuthorController().getAuthorList());
			//CREATE A BOOK
			manager.getBookController().add("Hamlet", "9789505630028");
			//manager.getBookController().add("Mundo Consumo", "9769603631105"); //duplicated title error
			//manager.getBookController().add("Retrotopía", "977884493-6"); //duplicated isbn error
			manager.getBookController().select(5L);
			System.out.println(manager.getBookController().getBook());
			System.out.println(manager.getBookController().getBookList());
			//EDIT AN AUTHOR
			manager.getAuthorController().edit(10L, "William Faulkner");
			manager.getAuthorController().select(10L);
			System.out.println(manager.getAuthorController().getAuthor());
			System.out.println(manager.getAuthorController().getAuthorList());
			//EDIT A BOOK
			manager.getBookController().edit(5L, "Requiem for a Nun", "9780394714127");
			manager.getBookController().select(5L);
			System.out.println(manager.getBookController().getBook());
			System.out.println(manager.getBookController().getBookList());
			//REMOVE AN AUTHOR
			manager.getAuthorController().remove(10L);
			System.out.println(manager.getAuthorController().getAuthor());
			System.out.println(manager.getAuthorController().getAuthorList());
			//REMOVE A BOOK
			manager.getBookController().remove(5L);
			System.out.println(manager.getBookController().getBook());
			System.out.println(manager.getBookController().getBookList());
			//SELECT BOOKS ACCORDING TO THEIR AUTHORS
			manager.getBookController().selectAll();
			for (Book b : manager.getBookController().getBookList()) {
				System.out.println("Book: " + b.getTitle());
				manager.getAuthorController().selectAllByBook(b.getId());
				System.out.println("Authors: " + manager.getAuthorController().getAuthorList());
			}
			//SELECT AUTHORS ACCORDING TO THEIR BOOKS
			manager.getAuthorController().selectAll();
			for (Author a : manager.getAuthorController().getAuthorList()) {
				System.out.println("Author: " + a.getName());
				manager.getBookController().selectAllByAuthor(a.getId());
				System.out.println("Books: " + manager.getBookController().getBookList());
			}
		} catch (DAOException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.freeConnection();
		}
	}

}