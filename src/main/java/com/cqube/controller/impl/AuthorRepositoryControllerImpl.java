package com.cqube.controller.impl;

import java.util.List;

import com.cqube.controller.IAuthorRepositoryController;
import com.cqube.model.Author;
import com.cqube.service.common.IManagerService;
import com.cqube.utils.DAOException;

public class AuthorRepositoryControllerImpl implements IAuthorRepositoryController {

	private Author author;
	private List<Author> authorList;
	private IManagerService manager;

	public AuthorRepositoryControllerImpl(IManagerService manager) {
		super();
		this.manager = manager;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Author> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}

	@Override
	public List<Author> selectAll() throws DAOException {
		if (!(authorList == null)) {
			authorList.clear();
		}
		authorList = manager.getAuthorService().list();
		return null;
	}

	@Override
	public List<Author> selectAllByBook(Long book) throws DAOException {
		if (!(authorList == null)) {
			authorList.clear();
		}
		//List authors according to a book
		authorList = manager.getAuthorService().listByBook(book);
		return null;
	}

}
