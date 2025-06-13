package data_structure_ch08;
//단순한 linked list에서 insert, delete하는 알고리즘을 코딩: 1단계

import java.util.Random;
import java.util.Scanner;

import org.w3c.dom.Node;

class Node1 {
	int data;
	Node1 next;

	public Node1(int element) {
		data = element;
		next = null;
	}
}

class LinkedList1 {
    Node1 first;

    public LinkedList1() {
        first = null;
    }

    public int Delete(int element) {
        if (first == null)
            return -1; // 리스트 비어 있음

        Node1 p = first;
        Node1 q = null;

        while (p != null) {
            if (p.data == element) {
                if (q == null) {
                    first = p.next; // 첫 번째 노드 삭제
                } else {
                    q.next = p.next;
                }
                return 1; // 삭제 성공
            }
            q = p;
            p = p.next;
        }
        return 0; // 삭제할 값 없음
    }

    public void Show() {
        Node1 p = first;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public void Add(int element) {
        Node1 newNode = new Node1(element);
        Node1 p = first;
        Node1 q = null;

        while (p != null && p.data < element) {
            q = p;
            p = p.next;
        }

        if (q == null) {
            newNode.next = first;
            first = newNode;
        } else {
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    public boolean Search(int data) {
        Node1 p = first;
        while (p != null) {
            if (p.data == data)
                return true;
            p = p.next;
        }
        return false;
    }

    public void Merge(LinkedList1 b) {
        Node1 p = this.first;
        Node1 q = b.first;
        Node1 head = null;
        Node1 tail = null;

        while (p != null && q != null) {
            Node1 selected;
            if (p.data <= q.data) {
                selected = p;
                p = p.next;
            } else {
                selected = q;
                q = q.next;
            }

            if (head == null) {
                head = tail = selected;
            } else {
                tail.next = selected;
                tail = selected;
            }
        }

        if (p != null) tail.next = p;
        if (q != null) tail.next = q;

        this.first = head;
    }
}

public class Test08_1 {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Merge("합병"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values()) // m = menu의 벨류를 출력한 객체
				if (m.ordinal() == idx) // m.ordinal 은 벨류를 인덱스로 변환하는 메서드
					return m;
			return null;
		}
		//"Add" 상수가 정의될 때 Menu("삽입") 생성자가 호출되어 message 필드가 "삽입"으로 초기화
		//생성자는 각 상수가 정의될 때 호출되며, 해당 상수의 message 필드를 초기화하는 역할
		//enum 상수가 언제 정의되는가를 찾아 보아야 한다 
		Menu(String string) { // 생성자(constructor)가 언제 호출되는지 파악하는 것이 필요하다 
			message = string;
			System.out.println("\nMenu 생성자 호출:: " + string);
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				//n%3은 3으로 나누어 나머지를 계산한다 
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())//메뉴 출력시에 다음행에 출력하라는 의미
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();//메뉴 선택 번호로 입력된 값이 key이다 
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());//입력된 key가 음수이거나 Exit에 대한 enum 숫자보다 크면 다시 입력받는다 
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴 참조 변수일 뿐이다 
		Random rand = new Random();
		LinkedList1 l = new LinkedList1();
		Scanner sc = new Scanner(System.in);
		System.out.println("추가할 난수 숫자 개수::");
		int count = sc.nextInt(); //난수 생성 갯수

		int data = 0;
		do {
			switch (menu = SelectMenu()) {//Menu 생성자 호출 - menu 객체를 리턴한다 
			case Add: // 난수를 삽입하는데 올림차순으로 정렬되도록 구현
				for (int i =0; i < count; i++) {
					data = rand.nextInt(100);
					l.Add(data);
				}
				break;
			case Delete:
				System.out.println("삭제할 값을 입력: ");
				data = sc.nextInt();
				int tag = l.Delete(data);
				System.out.println("삭제 결과: " + switch (tag) {
					case 1 -> "삭제 성공!";
					case 0 -> "삭제할 값이 없습니다.";
					case -1 -> "리스트가 비어 있습니다.";
					default -> "알 수 없는 오류";
				});
				break;
			case Show: //리스트 전체를 출력
				l.Show();
				break;
			case Search: //입력 숫자 n을 검색한다.
				int n = sc.nextInt();
				boolean result = l.Search(n);
				if (!result)
					System.out.println("검색 값 = " + n + " 데이터가 없습니다.");
				else
					System.out.println("검색 값 = " + n + " 데이터가 존재합니다.");
				break;
			case Merge://리스트 l과 l2를 합병하여 올림차순 정렬이 되게 구현한다 
				LinkedList1 l2 = new LinkedList1();
				for (int i =0; i < count; i++) {
					data = rand.nextInt(20);
					l2.Add(data);
				}
				System.out.println("리스트 l::");
				l.Show();
				System.out.println("리스트 l2::");
				l2.Show();
				l.Merge(l2);//merge 실행후 show로 결과 확인 - 새로운 노드를 만들지 않고 합병 - 난이도 상
				System.out.println("병합 리스트 l::");
				l.Show();
				break;
			case Exit: // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}
