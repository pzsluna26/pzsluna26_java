package data_structure_ch04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// 리스트로 구현한 정수형 선형 큐
class ListQueue {
    private List<Integer> queue;
    private int capacity;

    // 생성자
    public ListQueue(int maxlen) {
        capacity = maxlen;
        queue = new ArrayList<>();
    }

    // 예외: 큐가 비어있음
    public static class EmptyQueueException extends RuntimeException {
        public EmptyQueueException(String s) {
            super(s);
        }
    }

    // 예외: 큐가 가득 참
    public static class OverflowQueueException extends RuntimeException {
        public OverflowQueueException(String s) {
            super(s);
        }
    }

    // 인큐: 큐에 데이터 추가
    public void enque(int x) {
        if (isFull()) throw new OverflowQueueException("큐가 가득 찼습니다.");
        queue.add(x);
    }

    // 디큐: 큐에서 데이터 제거
    public int deque() {
        if (isEmpty()) throw new EmptyQueueException("큐가 비어있습니다.");
        return queue.remove(0); // 리스트의 맨 앞에서 제거
    }

    // 피크: 맨 앞 데이터 확인
    public int peek() {
        if (isEmpty()) throw new EmptyQueueException("큐가 비어있습니다.");
        return queue.get(0);
    }

    // 큐를 비움
    public void clear() {
        queue.clear();
    }

    // 큐에 있는 데이터 개수
    public int size() {
        return queue.size();
    }

    // 큐의 최대 용량
    public int getCapacity() {
        return capacity;
    }

    // 큐가 비었는지 확인
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // 큐가 가득 찼는지 확인 (ArrayListsms 용량 제한없이 늘어나기때문에 isfull()이라는 메서드 없음)
    public boolean isFull() {
        return queue.size() >= capacity;
    }

    // 큐 내용을 모두 출력
    public void dump() {
        if (isEmpty()) {
            System.out.println("큐가 비어있습니다.");
        } else {
            System.out.println("큐 데이터: " + queue);
        }
    }
}
