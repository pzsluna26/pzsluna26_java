package programmas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// DFS 문제
class RecurSolution {
	public int solution(int[] numbers, int target) {
		return dfs(numbers, target, 0, 0);
	}
    // ✅ DFS 로직 메서드: 클래스 안에 있지만 State 바깥
    public int solution(int[] numbers, int target, int index, int currentSum) {
        int count = 0;
        if (index == numbers.length) {
           return currentSum == target ? 1 : 0;
            }
          
        }
        dfs(numbers, target, index+1, currentSum + numbers[index])
        return count;
    }
}
	
	//-1+1+1+1+1 = 3
    //+1-1+1+1+1 = 3
    //+1+1-1+1+1 = 3
    //+1+1+1-1+1 = 3
    //+1+1+1+1-1 = 3

    //numbers	target	return
    //[1, 1, 1, 1, 1]	3	5
    //[4, 1, 2, 1]	4	2
	// ✅ 클래스 정의 중복 방지 위해 아래 class를 분리 또는 통합해야 함
	
	
	
class QueueSolution {
    int index;
    int currentSum;

    public QueueSolution (int index, int currentSum) { // ✅ 생성자 추가
        this.index = index;
        this.currentSum = currentSum;
    }
}

public class Solution43165Test {
	
    public static void main(String[] args) {
        int[][] testNumbers = {
            {1, 1, 1, 1, 1},
            {4, 1, 2, 1}
        };
        int[] testTarget = {3, 4};
        int[] expectedResults = {5, 2};

        Solution43165 queueSol = new Solution43165(); // ✅ 인스턴스 필요

        for (int i = 0; i < testNumbers.length; i++) {
            int[] numbers = testNumbers[i];
            int target = testTarget[i];
            int expectResult = expectedResults[i];

           int stackResult = queueSol.solution(numbers, target);
           if (expectResult == queueResult) System.out.println("solution43165");
        }
    }
}
