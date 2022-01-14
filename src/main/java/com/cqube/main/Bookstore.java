package com.cqube.main;

import com.cqube.connection.ConnectionProvider;
import com.cqube.controller.impl.AuthorRepositoryControllerImpl;
import com.cqube.controller.impl.BookRepositoryControllerImpl;
import com.cqube.model.Author;
import com.cqube.model.Book;
import com.cqube.persistence.impl.ManagerDAOImpl;
import com.cqube.service.impl.ManagerServiceImpl;
import com.cqube.utils.DAOException;

public class Bookstore {

	public static void main(String[] args) {
		try {
			//CREATE CONTROLLERS
			BookRepositoryControllerImpl bookController = new BookRepositoryControllerImpl(new ManagerServiceImpl(new ManagerDAOImpl()));
			AuthorRepositoryControllerImpl authorController = new AuthorRepositoryControllerImpl(new ManagerServiceImpl(new ManagerDAOImpl()));
			//CREATE AN AUTHOR
			authorController.add("William Shakespeare");
			authorController.select(10L);
			System.out.println(authorController.getAuthor());
			System.out.println(authorController.getAuthorList());
			//CREATE A BOOK
			bookController.add("Hamlet", "9789505630028");
			bookController.select(5L);
			System.out.println(bookController.getBook());
			System.out.println(bookController.getBookList());
			//EDIT AN AUTHOR
			authorController.edit(10L, "William Faulkner");
			authorController.select(10L);
			System.out.println(authorController.getAuthor());
			System.out.println(authorController.getAuthorList());
			//EDIT A BOOK
			bookController.edit(5L, "Requiem for a Nun", "9780394714127");
			bookController.select(5L);
			System.out.println(bookController.getBook());
			System.out.println(bookController.getBookList());
			//REMOVE AN AUTHOR
			authorController.remove(10L);
			System.out.println(authorController.getAuthor());
			System.out.println(authorController.getAuthorList());
			//REMOVE A BOOK
			bookController.remove(5L);
			System.out.println(bookController.getBook());
			System.out.println(bookController.getBookList());
			//SELECT BOOKS ACCORDING TO THEIR AUTHORS
			bookController.selectAll();
			for (Book b : bookController.getBookList()) {
				System.out.println("Book: " + b.getTitle());
				authorController.selectAllByBook(b.getId());
				System.out.println("Authors: " + authorController.getAuthorList());
			}
			//SELECT AUTHORS ACCORDING TO THEIR BOOKS
			authorController.selectAll();
			for (Author a : authorController.getAuthorList()) {
				System.out.println("Author: " + a.getName());
				bookController.selectAllByAuthor(a.getId());
				System.out.println("Books: " + bookController.getBookList());
			}
		} catch (DAOException e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.freeConnection();
		}
	}

}