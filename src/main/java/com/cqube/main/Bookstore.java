package com.cqube.main;

import java.sql.SQLException;

import com.cqube.connection.ConnectionProvider;
import com.cqube.controller.common.IManagerController;
import com.cqube.controller.impl.ManagerControllerImpl;
import com.cqube.model.Author;
import com.cqube.model.Book;
import com.cqube.model.Relationship;
import com.cqube.model.Relationship.PrimaryKey;
import com.cqube.persistence.impl.ManagerDAOImpl;
import com.cqube.service.impl.ManagerServiceImpl;
import com.cqube.service.proxy.ManagerProxyImpl;
import com.cqube.utils.DAOException;

public class Bookstore {

	public static void main(String[] args) {
		try {
			//CREATE MANAGER CONTROLLER
			IManagerController manager = new ManagerControllerImpl(new ManagerProxyImpl(
							new ManagerServiceImpl(new ManagerDAOImpl(ConnectionProvider.getConnection()))));
			//CREATE A BOOK
			manager.getBookController().add("Hamlet", "9789505630028");
			System.out.println(manager.getBookController().selectByTitle("Hamlet"));
			//CREATE AN AUTHOR
			manager.getAuthorController().add("William Shakespeare");
			System.out.println(manager.getAuthorController().selectByName("William Shakespeare"));
			//CREATE A RELATIONSHIP (first book id then author id)
			manager.getRelationshipController().add(
					manager.getBookController().selectByTitle("Hamlet").getId(),
					manager.getAuthorController().selectByName("William Shakespeare").getId()
			);
			//EDIT A BOOK
			manager.getBookController().edit(5L, "Requiem for a Nun", "9780394714127");
			System.out.println(manager.getBookController().select(5L));
			//EDIT AN AUTHOR
			manager.getAuthorController().edit(10L, "William Faulkner");
			System.out.println(manager.getAuthorController().select(10L));
			//REMOVE RELATIONSHIP
			manager.getRelationshipController().remove(new PrimaryKey(5, 10));
			//REMOVE AN AUTHOR
			manager.getAuthorController().remove(10L);
			//REMOVE A BOOK
			manager.getBookController().remove(5L);
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
		} catch (DAOException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.freeConnection();
		}
	}

}