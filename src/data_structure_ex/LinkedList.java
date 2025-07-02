package data_structure_ex;

import java.util.Comparator;

public class LinkedList<T> {
	private final Node<T> head; //final 해드지키기 고정값!
	private int size;
	
	public LinkedList() {
		this.head = new Node<>(null); //head에 아무것도 없는 거 넣기(null) => dummy노드 : 아무것도 안하는 노드
		this.head.setPrev(head);
		this.head.setNext(head);
		this.size = 0;
	}
	
	public int size() {
		return size;
		
	}
	
	public boolean isEmpty() {
		return head.getNext() == head;
	}
	
	public void addFirst(T obj) {
		Node<T> newNode = new Node<>(obj);
		Node<T> first = head.getNext();
		// o <- A
		newNode.setPrev(head);
		newNode.setNext(first);
		head.setNext(NewNode);
		first.setPrev(newNode);
		
		size++;
		
	}
	
	// 1. final이 있을때 = head가 고정값일때 / 이게 더 좋은방법
	public void addLast(T obj) {
		Node<T> newNode = new Node<>(obj);
		Node<T> last = head.getNext();
		newNode.setPrev(last);
		newNode.setNext(head);
		last.setNext(newNode);
		head.setPrev(newNode);
		size++;
	}
	

	
	// 2. final 뺐을때 //addLast() 해보기
//	public void addLast(T obj) {
//		Node<T> newNode = new Node<>(obj);
//		
//		if(head ==null) {
//			head =newNode;
//		} else {
//			Node<T> current = head;
//			while(current.getNext() != null) {
//				current = current.getNext();
//				
//			}
//			
//			current.setNext(newNode);
//			current.setPrev(current);
//			
//		}
//		size++;
//	}
	

	
	public void delete(T obj, Comparator<? super T > c) {
									// 뭐가들어올지몰라(?) 단, 상위객체가 T타입이여야해
									// T 가 상위객체 = T가 젤 작은 타입
		// Node<T> current(현재노드)
			Node<T> current = head.getNext();
		// 반복구문을 사용해서 current 이동
			while (current != head) {
		// 만약에 obj와 Node<T>가 같으면 삭제
				if(c.comepare(current.getData(), obj) == 0){
					//응 같아
					current.getPrev().setNext(current.getNext());
					//현재나 -> 앞에 아이야 ->응 -> 링크걸어라 -> 현재애 옆에로
					//나를기준으로 헤드방향이 prev
					current.getNext().setPrev(current.getPrev());
					size--;
					System.out.println("삭제완료:"+obj);
					return;
				}
		// 아니면 return 해야 됨
				current = current.getNext();
				//아니 달라
			}
			System.out.println("삭제할 데이터를 찾을 수 없습니다:" + obj);
	}
	
	public LinkedList<T> mergeNewList(LinkedList<T> lst2, Comparator<? super T> cc){
		LinkedList<T> lst3 = new LinkedList<>();
		
		Node<T> ai = head.getNext();
		Node<T> bi = lst2.head.getNext();
		
		// 크기가 같으면 반복돌고, 크기가 다르면 퀵소트 처럼 반복돌고 남은거 붙여야함
		// 사이즈 건들지마라 
		while (ai != head && bi != lst2.head) {
			// 해드로가지마라.
			if (cc.compare(ai.getData(), bi.getData())<= 0) {
				//ai가 bi 보다 작음
				// 추가해야함(add last 이용해서 추가) ai
				lst3.addLast(ai.getData());
				ai = ai.getNext();
			// else
			// 추가해야함(add last 이용해서 추가) bi
			} else {
				lst3.addLast(bi.getData());
				bi.getNext();
			}
		}
		// ai에 남은 LinkedList를 순회해서 뒷부분에 추가
		while(ai != head) {
			lst3.addLast(ai.getData());
			ai = ai.getNext();
		}
		// bi에 남은 LinkedList를 순회해서 뒷부분에 추가
		while(bi != lst2.head) {
			lst3.addLast(bi.getData());
			bi.getNext();
		}
		return lst3;
		}
//	public void add(T obj, Comparator<? super SimpleObject2> c) {
//		Node<T> newNode = new Node<>(obj);
//		Node<T> current = head.getNext();
//		
//		// 정렬된 위치를 찾아야 함
//		while(current != head && c.compare(obj, current.getData())> 0) {		
//			current = current.getNext();
//		}
//		// current 기준으로 앞에 삽입
//		newNode.setPrev(current.getPrev());
//		newNode.setNext(current);
//		current.getPrev().setNext(newNode);
//		current.setPrev(newNode);
//	
////	}		
//	

	public void add(T obj) {
	@SuppressWarnings("unchecked")
	Comparable<T> comparableObj = (Comparable<T>) obj;
	add(obj, (a,b) -> comparableObj.compareTo(b));
}
	
	
}
