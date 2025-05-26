package com.ruby.java.ch09;

import java.util.Arrays;

/* Book 클래스 */
class Book {
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;

	// 생성자
	public Book(String title, String author, int publicationYear, String isbn) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}

	// Getter
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public String getISBN() {
		return isbn;
	}

	@Override
	public String toString() {
	    return String.format("도서명:\t%s\t저자:\t%s\t출판연도:\t%d\tISBN:\t%s",
	            title, author, publicationYear, isbn);
	}
}

/* Library 클래스 */
class Library { 
	static final int CAPACITY = 20;
	private Book[] books; 
	private int top;

	public Library() {
		books = new Book[CAPACITY];
		top = 0;
	}

	public boolean addBook(Book book) {
		if (top >= CAPACITY) {
			System.out.println("도서 저장 공간이 부족합니다.");
			return false;
		}
		books[top++] = book;
		return true;
	}

	public void printBooks(String msg) {
		System.out.println(msg);
		for (int i = 0; i < top; i++) {
			System.out.println(books[i]);
		}
	}

	public void sortBooksByTitle() {
		// String의 compareTo() 사용
		Arrays.sort(books, 0, top, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
	}

	public void sortBooksByISBN() {
		Arrays.sort(books, 0, top, (b1, b2) -> {
			int isbn1 = Integer.parseInt(b1.getISBN());
			int isbn2 = Integer.parseInt(b2.getISBN());
			return Integer.compare(isbn1, isbn2);
		});
	}

	public Book searchBookByTitle(String title) {
		for (int i = 0; i < top; i++) {
			if (books[i].getTitle().equals(title)) {
				return books[i];
			}
		}
		return null;
	}
}

/* 메인 클래스 */
public class Ex_01 {
	public static void main(String[] args) {
		Library library = new Library(); 
		
		// 5개의 Book 객체 초기화 
		Book book1 = new Book("자바", "강감찬", 1995, "12"); 
		Book book2 = new Book("파이썬", "이순신", 2008, "9"); 
		Book book3 = new Book("C++", "을지문덕", 2008, "8"); 
		Book book4 = new Book("자료구조", "연개소문", 1994, "45"); 
		Book book5 = new Book("리액트", "김춘추", 1999, "7");

		// 책 추가
		library.addBook(book1); 
		library.addBook(book2); 
		library.addBook(book3); 
		library.addBook(book4);
		library.addBook(book5); 

		// 도서 목록 출력
		library.printBooks("\n제목정렬전"); 

		// 도서 목록 정렬 
		library.sortBooksByTitle(); 
		library.printBooks("\n제목정렬후");

		library.printBooks("\nISBN정렬전"); 
		library.sortBooksByISBN(); 
		library.printBooks("\nISBN정렬후");

		// 특정 제목으로 도서 검색 
		String searchTitle = "자바"; 
		Book foundBook = library.searchBookByTitle(searchTitle); 
		if (foundBook == null)
			System.out.println("\n자바 책이 없다");
		else 
			System.out.println("\n도서명으로 검색한 도서\n" + foundBook.toString());
	}
}
