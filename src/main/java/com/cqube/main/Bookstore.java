package com.cqube.main;

import java.sql.Connection;
import java.sql.SQLException;

import com.cqube.connection.ConnectionProvider;
import com.cqube.controller.common.IManagerController;
import com.cqube.model.Author;
import com.cqube.model.Book;
import com.cqube.model.Relationship;
import com.cqube.model.Relationship.PrimaryKey;
import com.cqube.utils.DAOException;
import com.cqube.utils.ManagerFactory;

public class Bookstore {
	
	private IManagerController manager;
	
	public Bookstore(Connection connection) {
		this.manager = ManagerFactory.getManagerController(connection);
	}

	public void addTransaction(String title, String isbn, String name) throws DAOException, SQLException {
		manager.getRelationshipController().add(
				manager.getBookController().add(title, isbn).getId(), manager.getAuthorController().add(name).getId()
		);
	}

	public void editTransaction(String title, String isbn, String name, long book, long author) throws DAOException, SQLException {
		manager.getBookController().edit(book, title, isbn);
		manager.getAuthorController().edit(author, name);
	}
	
	public void removeTransaction(Long book, Long author) throws DAOException, SQLException {
		manager.getRelationshipController().remove(new PrimaryKey(book, author));
		manager.getAuthorController().remove(author);
		manager.getBookController().remove(book);
	}
	
	public void printBookstoreInfo() throws DAOException {
		manager.getAuthorController().printTicket();
		manager.getBookController().printTicket();
	}

	public static void main(String[] args) {
		try {
			//MANAGER CONTROLLER
			Bookstore bookstore = new Bookstore(ConnectionProvider.getConnection());
			//ADD TRANSACTION
			bookstore.addTransaction("Hamlet", "9789505630028", "William Shakespeare");
			//EDIT TRANSACTION
			bookstore.editTransaction("Requiem for a Nun", "9780394714127", "William Faulkner", 5L, 10L);
			//REMOVE TRANSACTION
			bookstore.removeTransaction(5L, 10L);
			//SELECT ALL ITEMS
			bookstore.printBookstoreInfo();
			/*
			//SELECT BOOK ACCORDING TO THEIR AUTHORS
			for (Book b : manager.getBookController().selectAll()) {
				System.out.println("Book: " + b.getTitle());
				for (Relationship r : manager.getRelationshipController().selectAllAuthorsByBook(b.getId())) {
					System.out.println(manager.getAuthorController().select(r.getId().getAuthor()));
				}
			}
			//SELECT AUTHOR ACCORDING TO THEIR BOOKS
			for (Author a : manager.getAuthorController().selectAll()) {
				System.out.println("Author: " + a.getName());
				for (Relationship r : manager.getRelationshipController().selectAllBooksByAuthor(a.getId())) {
					System.out.println(manager.getBookController().select(r.getId().getBook()));
				}
			}
			*/
		} catch (DAOException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.freeConnection();
		}
	}

}