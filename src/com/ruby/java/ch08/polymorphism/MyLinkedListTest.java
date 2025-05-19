package com.ruby.java.ch08.polymorphism;

public class MyLinkedListTest {

	public static void main(String[] args) {
		MyLinkedList myList = new MyLinkedList();
		myList.print();
		
		myList.add("JAVA");
		myList.add("JSP");
		myList.add("Servlet");
	    myList.print();
	    
	    System.out.println("-".repeat(10));
	    // 응용문제
	    // add처럼 메서드 선언하기.
	    
	    myList.remove("JSP");
	    myList.print();
	}
}
