package com.ruby.java.ch08.polymorphism;

public class MyLinkedList {

	private Node head = null;
	private Object data;
	
	// 내부클래스
	private class Node {
		private String data;
		private Node link;
	
		
		public Node(String data) {
			this.data = data;
		}
	}
	
	public void add(String data) {
		Node newNode = new Node(data);
		// JAVA : head == null 
		if(head == null) {
			head = newNode;
		
		// JSP : next = JAVA & next.link == null
		} else {
			Node next = head;
			
			// Servlet : JSP 링크 != null
			while(next.link != null) {
				next = next.link;
			}
			
			next.link = newNode;
		}
	}
	
	public void remove(String data) {
		if (head == null) return;
		
		Node next = head;
		Node pre = null;
		while(next.link != null) {
	
			if (data.equals(next.data)) {
				pre.link = next.link;
				break;
			}
		pre = next;
		next = next.link;
	}		
	}
	
	public void print() {
		if(head == null) {
			System.out.println("등록된 데이터가 없습니다. ");
		} else {
			System.out.println("등록된 데이터는 다음과 같습니다.");
			Node next = head;
			while(next != null) {
				System.out.println(next.data);
				next = next.link;
			}
		}
	}	
}
