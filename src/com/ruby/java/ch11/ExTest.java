package com.ruby.java.ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Overflow 예외 클래스
class OverflowException extends RuntimeException {
	public OverflowException(String message) {
		super(message);
	}
}

// Underflow 예외 클래스
class UnderflowException extends RuntimeException {
	public UnderflowException(String message) {
		super(message);
	}
}

// Book 클래스
class Book implements Comparable<Book> {
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;

	public Book(String title, String author, int publicationYear, String isbn) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getIsbn() {
		return isbn;
	}

	@Override
	public String toString() {
		return String.format("도서명:\t%s\t저자:\t%s\t출판연도:\t%d\tISBN:\t%s", title, author, publicationYear, isbn);
	}

	@Override
	public int compareTo(Book o) {
		return this.title.compareTo(o.title); // 제목 기준 오름차순 정렬
	}
}

class Library {
	static final int CAPACITY = 5; // 기본 용량 5
	private ArrayList<Book> books = new ArrayList<>();

	// 책 추가
	public void addBook(Book book) {
		if (books.size() >= CAPACITY) {
			throw new OverflowException("도서관 용량 초과로 책을 추가할 수 없습니다.");
		}
		books.add(book);
	}

	// 책 삭제
	public Book removeBook() {
		if (books.isEmpty()) {
			throw new UnderflowException("도서관이 비어 있어 책을 삭제할 수 없습니다.");
		}
		return books.remove(books.size() - 1); // 마지막 책 삭제
	}

	// 도서 출력
	public void printBooks(String msg) {
		System.out.println(msg);
		for (Book b : books) {
			System.out.println(b);
		}
	}

	// 제목으로 정렬
	public void sortBooksByTitle() {
		Collections.sort(books);
	}

	// ISBN으로 정렬
	public void sortBooksByISBN() {
		Collections.sort(books, Comparator.comparing(Book::getIsbn));
	}

	// 제목으로 책 검색
	public Book searchBookByTitle(String title) {
		for (Book b : books) {
			if (b.getTitle().equals(title)) {
				return b;
			}
		}
		return null;
	}
}

public class ExTest {
	public static void main(String[] args) {
		try {
			String s = new String("java");
			System.out.println(s.length());
			s = null;
			System.out.println(s.length()); // NullPointerException 발생
			int[] arr = new int[2];
			arr[2] = 10; // ArrayIndexOutOfBoundsException 발생
		} catch (ArrayIndexOutOfBoundsException e1) {
			System.out.println("***배열 색인 예외 발생");
			System.out.println(e1.getMessage());
		} catch (NullPointerException e2) {
			System.out.println("***널 포인터 예외 발생");
			e2.printStackTrace();
		} catch (Exception e) {
			System.out.println("***예외 발생");
		} finally {
			System.out.println("***모든 것이 ok\n\n");
		}

		Library library = new Library();

		// 책 생성
		Book book1 = new Book("자바", "강감찬", 1995, "12");
		Book book2 = new Book("파이썬", "이순신", 2008, "9");
		Book book3 = new Book("C#", "을지문덕", 2008, "8");
		Book book4 = new Book("자료구조", "연개소문", 1994, "45");
		Book book5 = new Book("리액트", "김춘추", 1999, "7");
		Book book6 = new Book("스프링", "홍길동", 2025, "99");

		try {
			library.addBook(book1);
			library.addBook(book2);
			library.addBook(book3);
			library.addBook(book4);
			library.addBook(book5);

			// 용량 초과 -> 예외 발생
			library.addBook(book6);
		} catch (OverflowException e) {
			System.out.println("***오버플로우 예외 발생: " + e.getMessage());
		}

		// 현재 도서 목록 출력
		library.printBooks("\n현재 도서 목록:");

		// 책 다 삭제
		try {
			for (int i = 0; i < 6; i++) {
				Book removed = library.removeBook();
				System.out.println("삭제된 책: " + removed);
			}
		} catch (UnderflowException e) {
			System.out.println("***언더플로우 예외 발생: " + e.getMessage());
		}

		// 최종 도서 목록 출력
		library.printBooks("\n최종 도서 목록:");
	}
}