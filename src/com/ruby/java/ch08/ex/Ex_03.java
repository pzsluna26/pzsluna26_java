package com.ruby.java.ch08.ex;
// 연결 리스트와 배열

class Node3 {
	int data;
	Node3 link;

	public Node3(int data) {
		this.data = data;
		this.link = null;
	}
}

class LinkedList3 {
	Node3 first;

	// 리스트 끝에 추가
	void append(int data) {
		Node3 newNode = new Node3(data);
		if (first == null) {
			first = newNode;
			return;
		}
		Node3 p = first;
		while (p.link != null) {
			p = p.link;
		}
		p.link = newNode;
	}

	// 리스트 출력
	void showList() {
		System.out.println("\n연결리스트:");
		Node3 p = first;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.link;
		}
		System.out.println();
	}

	// 오름차순 정렬 삽입
	void insert(int data) {
		Node3 newNode = new Node3(data);
		Node3 p = first, q = null;

		while (p != null && p.data < data) {
			q = p;
			p = p.link;
		}

		if (q == null) {
			newNode.link = first;
			first = newNode;
		} else {
			newNode.link = q.link;
			q.link = newNode;
		}
	}
}

public class Ex_03 {
	// 배열 생성
	static int getList(int[] data) {
		int count = 0;
		int mid = data.length / 2;
		for (int i = 0; i <= mid; i++) {
			data[i] = i * 5;
			count++;
		}
		return count;
	}

	// 배열 출력
	static void showList(int[] data) {
		System.out.println("\n배열:");
		for (int i = 0; i < data.length; i++) {
			System.out.print(" " + i + " ");
		}
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			if (data[i] < 10)
				System.out.print(" ");
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

	// 배열 삽입 (오름차순 유지)
	static int insertList(int[] data, int count, int x) {
		if (count >= data.length) {
			System.out.println("배열이 가득 찼습니다!");
			return count;
		}
		int i = count - 1;
		while (i >= 0 && data[i] > x) {
			data[i + 1] = data[i];
			i--;
		}
		data[i + 1] = x;
		return count + 1;
	}

	public static void main(String[] args) {
		int[] list = new int[10];
		int count = 0;

		System.out.println("배열로 리스트::");
		count = getList(list);
		showList(list);

		count = insertList(list, count, 3);
		showList(list);

		count = insertList(list, count, 7);
		showList(list);

		LinkedList3 ll = new LinkedList3();
		ll.append(5);
		ll.append(10);
		ll.append(15);
		ll.append(20);
		ll.append(25);
		ll.showList();

		ll.insert(3);
		ll.showList();

		ll.insert(7);
		ll.showList();
	}
}