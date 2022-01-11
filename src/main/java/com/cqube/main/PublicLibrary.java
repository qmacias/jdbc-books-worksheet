package com.cqube.main;

import com.cqube.jdbc.ConnectionProvider;
import com.cqube.serv.AuthorRepositoryServiceImpl;
import com.cqube.serv.BookRepositoryServiceImpl;
import com.cqube.serv.ILibraryService;
import com.cqube.utils.DAOException;

public class PublicLibrary {

	private ILibraryService libraryService;

	public PublicLibrary(ILibraryService libraryService) {
		super();
		this.libraryService = libraryService;
	}

	public void showBookcaseInfo(ILibraryService service) throws DAOException {
		libraryService.showAllsearches(service);
	}

	public static void main(String[] args) throws DAOException {
		ILibraryService authorService = new AuthorRepositoryServiceImpl();
		ILibraryService bookService = new BookRepositoryServiceImpl();

		PublicLibrary publicLibrary = null;

		//List books according to authors
		publicLibrary = new PublicLibrary(bookService);
		publicLibrary.showBookcaseInfo(authorService);

		System.out.println("---\n");

		//List authors according to books
		publicLibrary = new PublicLibrary(authorService);
		publicLibrary.showBookcaseInfo(bookService);

		ConnectionProvider.freeConnection();
	}

}