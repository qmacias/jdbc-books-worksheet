package com.cqube.main;

import java.sql.SQLException;

import com.cqube.iserv.IAuthorRepositoryService;
import com.cqube.iserv.IBookRepositoryService;
import com.cqube.jdbc.ConnectionProvider;
import com.cqube.model.Author;
import com.cqube.model.Book;
import com.cqube.serv.AuthorRepositoryServiceImpl;
import com.cqube.serv.BookRepositoryServiceImpl;
import com.cqube.utils.DAOException;

public class App {
    
    public static void main(String[] args) throws SQLException, DAOException {
        
    	IAuthorRepositoryService authorService = new AuthorRepositoryServiceImpl();
    	IBookRepositoryService bookService = new BookRepositoryServiceImpl();
    	
        //List books according to authors
        for (Book b : bookService.list()) {
        	System.out.println("Book: " + b.getTitle());
        	System.out.println("Authors: " + authorService.listByBook(b.getId()) + "\n");
        }
        
        System.out.println("---\n");
        
        //List authors according to books
        for (Author a : authorService.list()) {
        	System.out.println("Author: " + a.getName());
        	System.out.println("Books: " + bookService.listByAuthor(a.getId()) + "\n");
        }
        
        ConnectionProvider.freeConnection();
    }

}
