package com.cqube.main;

import java.sql.SQLException;

import com.cqube.dao.ManagerDAOImpl;
import com.cqube.idao.IManagerDAO;
import com.cqube.model.Author;
import com.cqube.model.Book;
import com.cqube.utils.DAOException;

public class App {
    
    public static void main(String[] args) throws SQLException, DAOException {
        
        IManagerDAO manager = new ManagerDAOImpl();
        
        //List books according to authors
        for (Book b : manager.getBookDAO().findAll()) {
        	System.out.println("Book: " + b.getTitle());
        	System.out.println("Authors: " + manager.getAuthorDAO().findAllByBook(b.getId()) + "\n");
        }
        
        System.out.println("---\n");
        
        //List authors according to books
        for (Author a : manager.getAuthorDAO().findAll()) {
        	System.out.println("Author: " + a.getName());
        	System.out.println("Books: " + manager.getBookDAO().findAllByAuthor(a.getId()) + "\n");
        }
    }

}
