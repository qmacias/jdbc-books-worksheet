package com.cqube.main;

import com.cqube.iserv.IManagerService;
import com.cqube.jdbc.ConnectionProvider;
import com.cqube.serv.ManagerServiceImpl;
import com.cqube.utils.DAOException;

public class LibraryShop {

	private ILibraryServices libraryService;

	public LibraryShop(ILibraryServices libraryService) {
		super();
		this.libraryService = libraryService;
	}

	public void showBookcaseInfo(ILibraryServices service) throws DAOException {
		libraryService.showAllsearches(service);
	}

	public static void main(String[] args) throws DAOException {
		LibraryShop publicLibrary = null;
		IManagerService service = new ManagerServiceImpl();

		//List books according to authors
		publicLibrary = new LibraryShop(service.getBookService());
		publicLibrary.showBookcaseInfo(service.getAuthorService());

		System.out.println("---\n");

		//List authors according to books
		publicLibrary = new LibraryShop(service.getAuthorService());
		publicLibrary.showBookcaseInfo(service.getBookService());

		ConnectionProvider.freeConnection();
	}

}