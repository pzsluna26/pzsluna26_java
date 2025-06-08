package data_structure_ex;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class Point5 {
	private int ix;
	private int iy;
	
	public Point5(int ix, int iy) {
		super();
		this.ix = ix;
		this.iy = iy;
	}

	@Override
	public String toString() {
		return ix + ", " + iy;
	}
}


class CircularQueue {
	static int QUEUE_SIZE = 0;
	Point5[] que;//배열로 객체원형 큐 구현
	int front, rear;
	boolean isEmptyTag;
	
	//--- 실행시 예외: 큐가 비어있음 ---//
	public static class EmptyQueueException extends RuntimeException {
			public EmptyQueueException() {
				super("큐가 비어있음 ");
			}
		}

	//--- 실행시 예외: 큐가 가득 찼음 ---//
	public static class OverflowQueueException extends RuntimeException {
			public OverflowQueueException() {
				super("큐가 가득 찼음 ");
			}
		}
		
	public CircularQueue(int count) {
		front = rear = 0;
		que = new Point5[count];
		isEmptyTag = true;
		//다음 2개 field 가 필요한지 확인 필요 
		QUEUE_SIZE = count;
	}
	
	
	public void push(Point5 it) throws OverflowQueueException{
		if(isFull()) {
			throw new OverflowQueueException(); 
		}
		que[rear] = it;
		rear = (rear+1) % QUEUE_SIZE;
		isEmptyTag = false;
	}

	public Point5 pop() throws EmptyQueueException{
		if(isEmpty()) {
			throw new EmptyQueueException(); 
		}
		Point5 it= que[front];
		front = (front +1) % QUEUE_SIZE;
		if(front == rear) {
			isEmptyTag = true;
		}
		return it;
	}

	 public void clear() throws EmptyQueueException{
		if(isEmpty()) {
				throw new EmptyQueueException(); 
		}		 
		front = rear = 0;
		isEmptyTag = true;
	}

 	//--- 큐의 크기를 반환 ---//
	public int getCapacity() {
		return QUEUE_SIZE;
	}

	//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
	public int size() {//front, rear를 사용하여 갯수를 size로 계산
		if(isEmptyTag) {
			return 0; 
		} else if (rear >= front) {
			return rear - front;
		} else { 
			return QUEUE_SIZE - front + rear;
		}
	}
	//--- 원형 큐가 비어있는가? --- 수정 필요//
	public boolean isEmpty() {
		return isEmptyTag;
	}

	//--- 원형 큐가 가득 찼는가? --- 수정 필요//
	public boolean isFull() {
		return (front == rear) && !isEmptyTag;
	}

	public void dump() throws EmptyQueueException{
		if (isEmpty())
				throw new EmptyQueueException();
		else {
			int size = size();
			for (int i=0; i < size; i++) {
				int idx =(front + i) % QUEUE_SIZE;
				System.out.println(que[idx]);
			}
		}
	}
	public Point5 peek() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException(); // 큐가 비어있음
		}
		return que[front];
}
}
public class Test04_3_4 {
public static void main(String[] args) {
	Scanner stdIn = new Scanner(System.in);
	CircularQueue oq = new CircularQueue(4); // 최대 4개를 인큐할 수 있는 큐
	Random random = new Random();
	int rndx = 0, rndy = 0;
	Point5 p = null;
	while (true) {
		System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
		System.out.printf("현재 데이터 개수: %d / %d\n", oq.size(), oq.getCapacity());
		System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(5) clear  (0)종료: ");
		int menu = stdIn.nextInt();
		if (menu == 0)
			break;
		switch (menu) {
		case 1: // 인큐

			rndx = random.nextInt(20);

			rndy = random.nextInt(20);
			System.out.print("입력데이터: (" + rndx + ", " + rndy + ")");
			p = new Point5(rndx,rndy);
			try {
				oq.push(p);
				System.out.println("push: size() = "+ oq.size());
			} catch(CircularQueue.OverflowQueueException e) {
				System.out.println("queue이 full입니다." + e.getMessage());
				e.printStackTrace();
			}
			break;

		case 2: // 디큐
			try {
				p = oq.pop();
				System.out.println("pop: size() = "+ oq.size());
			} catch (CircularQueue.EmptyQueueException e) {
				System.out.println("queue이 비어있습니다." + e.getMessage());
				e.printStackTrace();
			}
			break;

		case 3: // 피크
			try {
				p = oq.peek();
				System.out.println("피크한 데이터는 " + p + "입니다.");
			} catch (CircularQueue.EmptyQueueException e) {
				System.out.println("queue이 비어있습니다." + e.getMessage());
				e.printStackTrace();
			}
			break;
		case 4: // 덤프
			try {
				oq.dump();
			} catch (CircularQueue.EmptyQueueException e) {
				System.out.println("queue이 비어있습니다." + e.getMessage());
				e.printStackTrace();
			}
			break;
		case 5: //clear
			try {
				oq.clear();
			} catch (CircularQueue.EmptyQueueException e) {
				System.out.println("queue이 비어있습니다." + e.getMessage());
				e.printStackTrace();
			}			
			break;
	}
	}
}
}
	

