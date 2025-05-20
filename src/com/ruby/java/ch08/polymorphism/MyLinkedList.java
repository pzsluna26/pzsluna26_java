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
	
	// 앞 노드가 '삭제대상노드의 다음 노드'를 가리키게 만들기.
	public void remove(String data) {
		if (head == null) return;
		
		Node next = head; // 맨 앞 노드부터 시작
		Node pre = null; // 이전 노드를 기억해둘 변수
		while(next.link != null) { 
			 // 현재 노드의 값이 삭제하고 싶은 값인지 확인
			if (data.equals(next.data)) {
				// 이전 노드가 현재 노드의 다음 노드를 가리키게 해서
		        // 현재 노드를 건너뜀 (즉, 삭제한 효과)
				pre.link = next.link;
				break;
			}
			// 다음으로 이동
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
