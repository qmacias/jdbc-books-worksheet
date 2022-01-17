package com.cqube.model;

public class Relationship {
	
	public static class PrimaryKey {
		
		private long book;
		private long author;
		
		public PrimaryKey(long book, long author) {
			this.book = book;
			this.author = author;
		}

		public long getBook() {
			return book;
		}

		public void setBook(long book) {
			this.book = book;
		}
		
		public long getAuthor() {
			return author;
		}

		public void setAuthor(long author) {
			this.author = author;
		}

		@Override
		public String toString() {
			return "PrimaryKey [book=" + book + ", author=" + author + "]";
		}
		
	}
	
	private PrimaryKey id;

	public Relationship(PrimaryKey id) {
		this.id = id;
	}
	
	public Relationship(long book, long author) {
		this(new PrimaryKey(book, author));
	}

	public PrimaryKey getId() {
		return id;
	}

	public void setId(PrimaryKey id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Relationship [id=" + id + "]";
	}

}
