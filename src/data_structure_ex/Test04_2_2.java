package data_structure_ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Point2 {
	private int ix;
	private int iy;

	public Point2(int x, int y) {
		ix = x;
		iy = y;
	}

	@Override
	public String toString() {
		return  ix +","+iy;
	}

	@Override
	public boolean equals(Object p) {
		if(this == p) return true;
		if(p instanceof Point2) {
			Point2 other = (Point2)p;
			return this.ix == other.ix && this.iy == other.iy;
		}
		return false;
	}
}

class ObjectStack{
	
	// generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	public class EmptyGenericStackException extends Exception {
		public EmptyGenericStackException() {
			super("스택이 비어 있습니다.");
		}
	}

	//--- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException() {
			super("스택이 가득 찼습니다. ");
		}
	}

    private List<Point2> data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	//--- 생성자(constructor) ---//
	public ObjectStack(int capacity) {
		this.top=0;
		this.capacity=capacity;
		this.data=new ArrayList<>(capacity);
		}

	//--- 스택에 x를 푸시 ---//
	//스택에 데이터 넣기. 꽉 차 있으면 예외 발생
	public boolean push(Point2 x) throws OverflowGenericStackException {
		if(top >= capacity) {
			throw new OverflowGenericStackException();
	} 
		data.add(x);
		top++;
		return true;
	}

	//--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	//스택에서 데이터를 꺼냄. 비어 있으면 예외
    public Point2 pop() throws EmptyGenericStackException {
        if (isEmpty()) throw new EmptyGenericStackException();
        top--;
        return data.remove(top);
    }


    //--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
    public Point2 peek() throws EmptyGenericStackException {
        if (isEmpty()) throw new EmptyGenericStackException();
        return data.get(top - 1);
    }


    //--- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

	//--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(Point2 x) {
		for(int i=top-1; i>=0; i--) {
			if(data.get(i) == x)
				return i;
		}
		return -1;
	}

	//--- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

	//--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

	//--- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

	//--- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

	//--- 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력 ---//
	public void dump() {
		if(isEmpty()) {
			System.out.println("스택이 비어있습니다.");
		} else { 
			for(int i=0; i<top; i++) {
				System.out.println(data.get(i)+" ");
			}
		}
	}
}

public class Test04_2_2 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		ObjectStack s = new ObjectStack(8); // 최대 8 개를 push할 수 있는 stack
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point2 p = null;
		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			switch (menu) {
			case 1: // 푸시
				System.out.print("데이터: ");
				rndx = random.nextInt(20);
				rndy = random.nextInt(20);
				p = new Point2(rndx,rndy);
				try {
					s.push(p);
				} catch(ObjectStack.OverflowGenericStackException e) {
					System.out.println("stack이 가득찼있습니다.");
				}
				break;

			case 2: // 팝
				try {
					p = s.pop();
					System.out.println("pop한 데이터는 " + p + "입니다.");
				} catch(ObjectStack.EmptyGenericStackException e) {
					System.out.println("stack이 비어있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = s.peek();
					System.out.println("peek한 데이터는 " + p + "입니다.");
				} catch (ObjectStack.EmptyGenericStackException e) {
					System.out.println("stack이 비어있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;
			}
		}
	}
}
