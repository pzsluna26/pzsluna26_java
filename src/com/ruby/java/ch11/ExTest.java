package com.ruby.java.ch11;

//ch11.실습과제
/*전체 흐름 요약
 * 


역할:
도서관에 책 5개 추가 → 6번째 추가해서 예외 발생

책 6개 삭제 시도 → 예외 발생

각 예외를 try-catch문으로 처리해서 프로그램이 멈추지 않게 하기



예외 처리로 잘못된 동작을 안정적으로 방지

정렬, 검색 기능으로 도서 관리 가능
 * */
import java.util.ArrayList;
import java.util.Arrays;

//사용자 정의 예외 : 도서 추가 시 용량 초과
//Overflow 예외 클래스
class OverflowException extends RuntimeException { // 교재 553

}

//사용자 정의 예외: 도서 삭제 시 빈 목록
//Underflow 예외 클래스
class UnderflowException extends RuntimeException {

}

// Book 클래스 : 책 정보를 저장하는 클래스
class Book implements Comparable<Book> { 
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;
	
	//생성자
	public Book(String title, String author, int publicationYear, String isbn) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}
	
	//제목 기준 정렬을 위한 compareTo 구현
	public int compareTo(Book b) { //추상 메소드를 구현 - Comparable 인터페이스
		return title.compareTo(b.title);
	}
	
	//책 정보를 문자열로 반환
	@Override
	public String toString() {
		return String.format("도서명:\t%s\t저자:\t%s\t출판연도:\t%d\tISBN:\t%s", title, author, publicationYear, isbn);
	}

}


//도서관 클래스: 최대 5구너의 책을 관리
//Library는 최대 5권의 책을 관리하며, 초과/삭제 시 예외 발생
class Library {
	private ArrayList<Book> books;
	static final int CAPACITY = 5; // 기본 용량을 5로 설정
	
	int top;
	public Library() {
	this.books = new ArrayList<Book>(CAPACITY);
	 top = 0;
	}
		
	// 책 추가: 예외 발생시 처리
	//(용량 초과 시 OverflowException 발생)
	public void addBook(Book book) {
		if(top > CAPACITY) {
			throw new OverflowException();
			
		} else {
			books.add(book);	
		} top++;
	}

	// 책 삭제: 예외 발생시 처리
	//(빈 목록에서 삭제 시 UnderflowException 발생)
	public Book removeBook() {
		if (books.isEmpty()) {
			throw new UnderflowException();
		}
		return books.remove(top-1);
	}
	
	// 책 목록 출력
	public void printBooks(String msg) {
		System.out.println(msg);
		for(Book book : books) {
			System.out.println(book);
		}
	}
	
	//제목 기준 정렬
	public void sortBooksByTitle() {
		books.sort(null);

	}
	
	//isbn 기준 정렬
	public void sortBooksByISBN() {
		books.sort();
	}
	
	//제목으로 책 검색
	public Book searchBookByTitle(String title) {
		for(Book book : books) {
			if()
		}
	}
}

public class ExTest {
	public static void main(String[] args) {
			try {
				//문자열 객체 생성
				String s = new String("java"); 
				//문자열 길이 출력: 4
				System.out.println(s.length());
				//참조 제거
				s = null;
				System.out.println(s.length());
				//nullpointerexception 발생
				int[] arr = new int[2];
				//arrayindexoutofboundsexception 발생
				arr[2] = 10;
			} catch (ArrayIndexOutOfBoundsException e1) {// 교재534
				System.out.println("***배열 색인 예외 발생");
				System.out.println(e1.getMessage());
			} catch (NullPointerException e2) {
				System.out.println("***널 포인터 예외 발생");
				e2.printStackTrace();
			} catch (Exception e) {
				System.out.println("***예외 발생");
			} finally {
				System.out.println("***모든 것이 ok\n\n");// 교재 543
				// 할당된 자원을 자동으로 해제가 아니고 close(file)을 포함해야 한다
			}
			
			//도서관 객체 생성
			Library library = new Library();

			// 5개의 Book 객체 초기화
			Book book1 = new Book("자바", "강감찬", 1995, "12");
			Book book2 = new Book("파이썬", "이순신", 2008, "9");
			Book book3 = new Book("C#", "을지문덕", 2008, "8");
			Book book4 = new Book("자료구조", "연개소문", 1994, "45");
			Book book5 = new Book("리액트", "김춘추", 1999, "7");
			Book book6 = new Book("스프링", "홍길동", 2025, "99");
			// 예외 처리를 적용한 책 추가 및 삭제
			try {
				library.addBook(book1);
				library.addBook(book2);
				library.addBook(book3);
				library.addBook(book4);
				library.addBook(book5);
				library.addBook(book6);

				// 도서관의 용량을 초과하여 책을 추가 (예외 발생)
			} catch (OverflowException e) {
				System.out.println("용량 초과입니다");

			}

			// 도서 목록 출력
			library.printBooks("\n\n현재 도서 목록:");

			try {
				for (int i=0; i < 6;i++) {
					//5권 삭제 성공, 6번째 삭제 시 underflowexception
					library.removeBook();
				}
				// 빈 도서관에서 책을 삭제 (예외 발생)

			} catch (UnderflowException e) {
				System.out.println("도서가 비어있습니다");
			}

			// 최종 도서 목록 출력
			library.printBooks("\n최종 도서 목록:");
		}
}