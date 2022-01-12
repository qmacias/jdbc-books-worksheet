package com.cqube.iserv;

import com.cqube.utils.DAOException;

public interface IManagerService {
	public ILibraryService getAuthorService() throws DAOException;
    public ILibraryService getBookService() throws DAOException;
}
