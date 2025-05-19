package com.ruby.java.ch08.ex2222;

import com.ruby.java.ch08.polymorphism.MyLinkedList.Node;

public class 내부클래스 {
	
	private Node head;
	public 내부클래스() { //생성자
		head = null;
	}
	private class Node {
		private String data;
		private Node link;

		public Node(String data) {
			this.data = data;
		}
	}
	public void add(String data) {
		Node newNode = new Node(data); //이줄 이해안감
		if(head == null) {
			head = new Node(data);
		} else {
			Node next = head;
			while(next.link != null) {
			}
			next.link = newNode;
		}
	}
	
	public void printList() {
		if(head == null) {
			System.out.println("등록된 데이터가 없습니다.");
	} else {
		System.out.println("등록된 데이터는 다음과 같습니다. ");
		Node next = head;
		while(next != null) {
			System.out.println(next.data);
			next = next.link;
		}
	}
	}
		
	public void delete(String data) {
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
	
	
public static void main(String[] args) {
		내부클래스 myList = new 내부클래스();
		myList.printList();

		myList.add("JAVA");
		myList.add("HTML");
		myList.add("CSS");
		myList.add("Javascript");
		myList.printList();
		myList.delete("CSS");
		myList.printList();
	}
}
