package com.cqube.main;

import java.sql.SQLException;

import com.cqube.utils.DAOException;

public interface IBookstore {
	public void addTransaction(String title, String isbn, String name) throws DAOException, SQLException;
	public void editTransaction(String title, String isbn, String name, long book, long author) throws DAOException, SQLException;
	public void removeTransaction(Long book, Long author) throws DAOException, SQLException;
}
