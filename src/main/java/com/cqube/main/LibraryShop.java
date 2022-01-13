package com.cqube.main;

import com.cqube.persistence.commons.ConnectionProvider;
import com.cqube.persistence.commons.ILibraryService;
import com.cqube.persistence.commons.IManagerService;
import com.cqube.persistence.impl.ManagerServiceImpl;
import com.cqube.utils.DAOException;

public class LibraryShop {

	private ILibraryService libraryService;
	private static IManagerService newService;
	
	public LibraryShop() {
		LibraryShop.newService = new ManagerServiceImpl();
	}

	public LibraryShop(ILibraryService libraryService) {
		super();
		this.libraryService = libraryService;
	}

	public void showBookcaseInfo(ILibraryService service) throws DAOException {
		libraryService.showAllsearches(service);
	}

	public static void main(String[] args) {
		LibraryShop publicLibrary = null;
		try {
			new LibraryShop();
			//List books according to authors
			publicLibrary = new LibraryShop(newService.getBookService());
			publicLibrary.showBookcaseInfo(newService.getAuthorService());
			System.out.println("---\n");
			//List authors according to books
			publicLibrary = new LibraryShop(newService.getAuthorService());
			publicLibrary.showBookcaseInfo(newService.getBookService());
		} catch (DAOException e) {
			e.printStackTrace();
		}
		ConnectionProvider.freeConnection();
	}

}