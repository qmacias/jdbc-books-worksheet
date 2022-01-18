package com.cqube.controller.impl;

import java.sql.SQLException;
import java.util.List;

import com.cqube.controller.IAuthorRepositoryController;
import com.cqube.model.Author;
import com.cqube.service.proxy.common.IManagerProxy;
import com.cqube.utils.DAOException;

public class AuthorRepositoryControllerImpl implements IAuthorRepositoryController {

	private Author author;
	private List<Author> authorList;
	private IManagerProxy proxyManager;
	
	public AuthorRepositoryControllerImpl(IManagerProxy proxyManager) {
		this.proxyManager = proxyManager;
	}

	@Override
	public Author getAuthor() {
		return author;
	}

	@Override
	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public List<Author> getAuthorList() {
		return authorList;
	}

	@Override
	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}
	
	@Override
	public Author add(String name) throws DAOException, SQLException {
		proxyManager.getAuthorProxy().create(name);
		//Refresh
		selectAll();
		return null;
	}
	
	@Override
	public Author edit(Long id, String name) throws DAOException, SQLException {
		proxyManager.getAuthorProxy().update(id, name);
		//Refresh list
		selectAll();
		return null;
	}
	
	@Override
	public Author remove(Long id) throws DAOException, SQLException {
		proxyManager.getAuthorProxy().delete(id);
		//Refresh list
		selectAll();
		return null;
	}

	@Override
	public Author select(Long id) throws DAOException {
		clearAuthor();
		//Select an author
		setAuthor(proxyManager.getAuthorProxy().find(id));
		return null;
	}

	@Override
	public Author selectByName(String name) throws DAOException {
		clearAuthor();
		//Select an author by name
		setAuthor(proxyManager.getAuthorProxy().findByName(name));
		return null;
	}
	
	@Override
	public List<Author> selectAll() throws DAOException {
		clearAuthorList();
		//Select all authors
		setAuthorList(proxyManager.getAuthorProxy().listAll());
		return null;
	}

	@Override
	public List<Author> selectAllByBook(Long book) throws DAOException {
		clearAuthorList();
		//Select authors according to a book
		setAuthorList(proxyManager.getAuthorProxy().listAllByBook(book));
		return null;
	}

	private void clearAuthor() {
		if (!(author == null)) {
			author = null;
		}
	}

	private void clearAuthorList() {
		if (!(authorList == null)) {
			authorList.clear();
		}
	}

}
