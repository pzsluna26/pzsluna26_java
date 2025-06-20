package data_structure_ex;

import java.util.Random;
import java.util.Scanner;

interface MaxHeap {
    public void Insert(int x);
    public int DeleteMax();
}

class Heap implements MaxHeap {
    final int heapSize = 100;
    private int[] heap;
    private int n;        // 현재 heap에 들어 있는 원소 수
    private int maxSize;  // heap의 최대 크기

    public Heap(int sz) {
        this.maxSize = sz;
        heap = new int[maxSize + 1]; // 인덱스 1부터 사용
        this.n = 0; // 요소 개수 
    }

    public void display() {
        System.out.println("Index: Value");
        for (int i = 1; i <= n; i++) {
            System.out.println(i + ": " + heap[i]);
        }
    }

    @Override
    public void Insert(int x) {
    	//1. isfull? 자리있어? (힙이 가득찼는지 확인)
        if (isFull()) {
            HeapFull();
            return;
        }
        
    	//2. 공간을 생성해야 함 (힙 크기 증가 및 마지막 위치 준비)
        n++; // 새로운 숫자 +1
        int i = n;  // 마지막 인덱스에 넣을 준비
        
    	//3. 재배치를 시작 (힙 성질을 유지하도록 위로 올라가며 재배치)
        // i 값 수정
        while (i > 1 && heap[i / 2] < x) { // 부모보다 크면 swap
        	// x는 insert하려는 값 => 최종적으로 heap[i] 에 넣어야함
        	// 힙의 루트 노드위치는 항상 1번 인덱스
        	// 자식노드 왼쪽 자리로 가려면 1보다 커야함 
            heap[i] = heap[i / 2]; // 넣은 값이랑 자리바꿈
            i = i / 2; // 위치를 부모 노드로 한칸 올라가기
        }
        
        // 결론적으로 insert로 하고싶은 것
        heap[i] = x; // 더이상 부모보다 크지 않으면 stop
    }

    // 최대값을 삭제하고 반환
    @Override
    public int DeleteMax() {
    	
        if (n == 0) {
            HeapEmpty();
            return -1;
        }
    	// x는 최대값
 		// 1. 공간을 작게 만들어야한다. 삭제했으니까위에꺼
        	int max = heap[1];
        	int last = heap[n--];
 		// 2. i,j 루트와 왼쪽을 정해야함
        	int i = 1;
        	int j = 2; //왼쪽자식
 		// 3. 재배치를 시작
 		// 3-1. 오른쪽 자식이 존재하고, 오른쪽 자식보다 큰가?
        	while(j <= n) {
        		if(j < n && heap[j] < heap[j+1]) 
        			j++;
 		// 3-2. 마지막 원소가 자식보다 크거나 같은가?
        		if(last >= heap[j]) {
        			break;
        		}
 		// 3-3. 자식을 위로 이동시켜야함
        		heap[i]=heap[j];
        		i=j;
        		j=2*i; 
        }
        // 결론적으로 delete로 하고 싶은 것
        heap[i] = last;
        return max;
    }
    
    public boolean isEmpty() {
    	return n == 0;
    }
    
    public boolean isFull() {
    	return n == maxSize;
    }
    
    // getSize() 보다 더 가독성있는 이름 사용하기 => size()
    public int size() {
    	return n;
    }
    
    public int peek() {
    	// [0]인덱스 사용자는
    	if(isEmpty()) {
    	System.out.println("아무것도 없어요");
    }
    return heap[1];
    }
   
    private void HeapEmpty() {
    	 // throw new FullException("가득 참")
        System.out.println("Heap Empty");
    }

    private void HeapFull() {
        System.out.println("Heap Full");
    }
}

public class Test06_4 {
    static void showData(int[] d) {
        System.out.print("Numbers: ");
        for (int i = 1; i < d.length; i++) {
            System.out.print(d[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        int select = 0;
        Scanner stdIn = new Scanner(System.in);
        Heap heap = new Heap(20);

        final int count = 10;
        int[] x = new int[count + 1];    // x[0]은 사용하지 않음
        int[] sorted = new int[count];

        do {
            System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
            select = stdIn.nextInt();
            switch (select) {
                case 1:
                    for (int i = 1; i <= count; i++) {
                        x[i] = rnd.nextInt(100); // 0~99
                        heap.Insert(x[i]);
                    }
                    showData(x);
                    break;

                case 2:
                    heap.display();
                    break;

                case 3:
                    for (int i = 0; i < count; i++) {
                        sorted[i] = heap.DeleteMax(); // 가장 큰 값부터 뽑음
                    }
                    System.out.print("Sorted (Descending): ");
                    for (int i = 0; i < count; i++) {
                        System.out.print(sorted[i] + " ");
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;
            }
        } while (select < 5);
    }
}
