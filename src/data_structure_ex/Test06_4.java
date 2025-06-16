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
    private int MaxSize;  // heap의 최대 크기

    public Heap(int sz) {
        MaxSize = sz;
        heap = new int[MaxSize + 1]; // 인덱스 1부터 사용
        n = 0;
    }

    public void display() {
        System.out.println("Index: Value");
        for (int i = 1; i <= n; i++) {
            System.out.println(i + ": " + heap[i]);
        }
    }

    @Override
    public void Insert(int x) {
        if (n == MaxSize) {
            HeapFull();
            return;
        }

        n++;
        int i = n;
        while (i > 1 && x > heap[i / 2]) { // 부모보다 크면 swap
            heap[i] = heap[i / 2];
            i = i / 2;
        }
        heap[i] = x;
    }

    @Override
    public int DeleteMax() {
        if (n == 0) {
            HeapEmpty();
            return -1;
        }

        int max = heap[1];
        int last = heap[n--]; // 마지막 노드를 가져옴
        int i = 1, j = 2;

        while (j <= n) {
            if (j < n && heap[j] < heap[j + 1]) j++; // 더 큰 자식 선택
            if (last >= heap[j]) break;

            heap[i] = heap[j];
            i = j;
            j = 2 * i;
        }
        heap[i] = last;
        return max;
    }

    private void HeapEmpty() {
        System.out.println("Heap Empty");
    }

    private void HeapFull() {
        System.out.println("Heap Full");
    }
}

public class Test06_4 {
    static void showData(int[] d) {
        System.out.print("Generated Numbers: ");
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
