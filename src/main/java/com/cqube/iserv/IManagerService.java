package com.cqube.iserv;

import com.cqube.main.ILibraryServices;
import com.cqube.utils.DAOException;

public interface IManagerService {
	public ILibraryServices getAuthorService() throws DAOException;
    public ILibraryServices getBookService() throws DAOException;
}
