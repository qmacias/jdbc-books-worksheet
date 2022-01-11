package com.cqube.main;

import com.cqube.utils.DAOException;

public interface ILibraryServices {
	public void showAllsearches(ILibraryServices service) throws DAOException;
	public void showByParameter(Long parameter) throws DAOException;
}
