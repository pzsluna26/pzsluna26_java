package com.ruby.java.ch08.ex2222;

public class 연결리스트와배열 {
	private Node head;
	public 연결리스트와배열() {
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
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
		} else {
			Node next = head;
			while(next.link != null) {
				next = next.link;
			} next.link = newNode;
		}
	}
	
	//printList() 결과는 A -> B -> C 등으로 출력한다
	public void printList() {
		Node next = head;
		while(next != null) {
			System.out.println(next.data);
		 if(next.link != null) {
			System.out.println("->");
		} next = next.link;
		}
	}
	
	public void delete(String data) {
		if(head == null) return;
		
		Node next =head;
		Node pre = null;
		
		while(next.link != null) {
			if(data.equals(next.data)) {
				pre.link = next.link;
			} pre = next;
			pre.link = next.link;
		}
	}
	
	
	public static void main(String[] args) {
		연결리스트와배열 myList = new 연결리스트와배열();
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
