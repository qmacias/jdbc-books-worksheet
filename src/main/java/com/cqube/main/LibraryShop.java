package com.cqube.main;

import com.cqube.jdbc.ConnectionProvider;
import com.cqube.utils.DAOException;
import com.cqube.utils.ServiceFactory;

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
		ILibraryServices authorService = ServiceFactory.getAuthorServiceImpl();
		ILibraryServices bookService = ServiceFactory.getBookServiceImpl();

		LibraryShop publicLibrary = null;

		//List books according to authors
		publicLibrary = new LibraryShop(bookService);
		publicLibrary.showBookcaseInfo(authorService);

		System.out.println("---\n");

		//List authors according to books
		publicLibrary = new LibraryShop(authorService);
		publicLibrary.showBookcaseInfo(bookService);

		ConnectionProvider.freeConnection();
	}

}