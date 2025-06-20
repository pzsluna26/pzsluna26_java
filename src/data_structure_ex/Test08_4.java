// 전체코드 (주석 포함해서 초등학생도 이해할 수 있게 작성)
package data_structure_ex;

import java.util.Comparator;
import java.util.Scanner;

// 간단한 회원 객체 클래스
class SimpleObject3 {
	static final int NO = 1; // 회원 번호 입력 여부
	static final int NAME = 2; // 이름 입력 여부

	private String no;
	private String name;
	String expire;

	public String toString() {
		return "(" + no + ") " + name;
	}

	public SimpleObject3(String no, String name) {
		this.no = no;
		this.name = name;
	}

	public SimpleObject3() {
		this.no = null;
		this.name = null;
	}

	void scanData(String guide, int sw) {
		Scanner sc = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요." + sw);
		if ((sw & NO) == NO) {
			System.out.print("번호: ");
			no = sc.next();
		}
		if ((sw & NAME) == NAME) {
			System.out.print("이름: ");
			name = sc.next();
		}
	}

	public static final Comparator<SimpleObject3> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject3> {
		public int compare(SimpleObject3 d1, SimpleObject3 d2) {
			return d1.no.compareTo(d2.no);
		}
	}

	public static final Comparator<SimpleObject3> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject3> {
		public int compare(SimpleObject3 d1, SimpleObject3 d2) {
			return d1.name.compareTo(d2.name);
		}
	}
}

// 노드 클래스
class Node3 {
	SimpleObject3 data;
	Node3 link;

	public Node3(SimpleObject3 element) {
		data = element;
		link = null;
	}
}

// 원형 연결 리스트 클래스
class CircularList {
	Node3 first;

	public CircularList() {
		SimpleObject3 data = new SimpleObject3(); // 더미(head) 노드
		first = new Node3(data);
		first.link = first;
	}

	public void Add(SimpleObject3 element, Comparator<SimpleObject3> cc) {
		Node3 newNode = new Node3(element);
		Node3 current = first;
		while (current.link != first && cc.compare(current.link.data, element) < 0) {
			current = current.link;
		}
		newNode.link = current.link;
		current.link = newNode;
	}

	public int Delete(SimpleObject3 element, Comparator<SimpleObject3> cc) {
		Node3 prev = first;
		Node3 current = first.link;
		while (current != first) {
			if (cc.compare(current.data, element) == 0) {
				prev.link = current.link;
				return 1; // 삭제 성공
			}
			prev = current;
			current = current.link;
		}
		return -1; // 삭제 실패
	}

	public boolean Search(SimpleObject3 element, Comparator<SimpleObject3> cc) {
		Node3 current = first.link;
		while (current != first) {
			if (cc.compare(current.data, element) == 0) {
				return true;
			}
			current = current.link;
		}
		return false;
	}

	public void Show() {
		Node3 current = first.link;
		while (current != first) {
			System.out.println(current.data);
			current = current.link;
		}
	}

	public void Merge(CircularList b, Comparator<SimpleObject3> cc) {
		Node3 aCur = first.link;
		Node3 bCur = b.first.link;
		Node3 aPrev = first;

		while (bCur != b.first) {
			Node3 nextB = bCur.link;
			while (aCur != first && cc.compare(aCur.data, bCur.data) < 0) {
				aPrev = aCur;
				aCur = aCur.link;
			}
			bCur.link = aCur;
			aPrev.link = bCur;
			aPrev = bCur;
			bCur = nextB;
		}
	}
}

// 메인 클래스
public class Test08_4 {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인시"), Search("검색"), Merge("합병"), Exit("종료");
		private final String message;
		static Menu MenuAt(int idx) {
			for (Menu m : Menu.values())
				if (m.ordinal() == idx) return m;
			return null;
		}
		Menu(String string) { message = string; }
		String getMessage() { return message; }
	}

	static Menu SelectMenu() {
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu;
		CircularList l = new CircularList();
		CircularList l2 = new CircularList();
		SimpleObject3 data;
		int count = 3;

		do {
			switch (menu = SelectMenu()) {
			case Add:
				data = new SimpleObject3();
				data.scanData("입력", 3);
				l.Add(data, SimpleObject3.NO_ORDER);
				break;
			case Delete:
				data = new SimpleObject3();
				data.scanData("삭제", SimpleObject3.NO);
				int result = l.Delete(data, SimpleObject3.NO_ORDER);
				System.out.println("삭제 결과: " + result);
				break;
			case Show:
				l.Show();
				break;
			case Search:
				data = new SimpleObject3();
				data.scanData("탐색", SimpleObject3.NO);
				System.out.println("검색 결과: " + l.Search(data, SimpleObject3.NO_ORDER));
				break;
			case Merge:
				for (int i = 0; i < count; i++) {
					data = new SimpleObject3();
					data.scanData("병합", 3);
					l2.Add(data, SimpleObject3.NO_ORDER);
				}
				System.out.println("리스트 l:"); l.Show();
				System.out.println("리스트 l2:"); l2.Show();
				l.Merge(l2, SimpleObject3.NO_ORDER);
				System.out.println("병합된 리스트 l:"); l.Show();
				break;
			case Exit:
				break;
			}
		} while (menu != Menu.Exit);
	}
}
