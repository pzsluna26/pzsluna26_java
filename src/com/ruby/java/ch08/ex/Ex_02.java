package com.ruby.java.ch08.ex;
// 내부클래스구현
public class Ex_02 {
	private Node head;
	public Ex_02() { //생성자
		head = null;
	}
	private class Node { //내부클래스
		private String data;
		private Node link;

		public Node(String data) {//내부클래스 생성자
			this.data = data;
			this.link = null;
		}
	}
	
	// add 하는 알고리즘 > 자료구조 + 알고리즘 => 문제 해결을 위한 논리적 사고 훈련
	public void add(String data) { 
		Node temp = new Node(data);
		Node p = head;
		Node q = null;
		while (p != null) {
			q = p;
			p = p.link;
		}
		q.link = temp;
		
		if(p == null) {
			head =p;
			return;
		}
	}
	public void printList() {
		//printList() 결과는 A -> B -> C 등으로 출력한다
	}
	public void delete(String data) {

	}
	
	
	public static void main(String[] args) {
		Ex_02 myList = new Ex_02();
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

}
