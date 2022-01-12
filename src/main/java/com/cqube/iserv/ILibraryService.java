package com.cqube.iserv;

import com.cqube.utils.DAOException;

public interface ILibraryService {
	public void showAllsearches(ILibraryService service) throws DAOException;
	public void showByParameter(Long parameter) throws DAOException;
}
