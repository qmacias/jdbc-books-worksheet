package com.cqube.view;

public class BookView {
	public void printBookInfo(String title, String isbn) {
		System.out.print(
				"============================================\n"
	            + "\nBook\n"
	            + "-Title: " + title + "\n"
	            + "-ISBN: " + isbn + "\n"
	            + "\n============================================\n"
	    );
	}
}
