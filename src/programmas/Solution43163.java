package programmas;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class BFSQueueSolution {
	private static class State{
		String word;
		int depth;
		Set<String> visited;
		public State(String word, int depth, Set<String> visited) {
			super();
			this.word = word;
			this.depth = depth;
			this.visited = visited;
		}
	}
    public int solution(String begin, String target, String[] words) {
    	if(Arrays.asList(words).contains(target)) {
    		return 0;
    	}
    	Queue<State> queue = new LinkedList<>();
    	Set<String> visited = new HashSet<>();
    	queue.offer(new State(begin, 0, visited));
    	visited.add(begin); //초기화
    	
    	while (!queue)
        int answer = 0;
        return answer;
    }
}


public class Solution43163 {
    public static void main(String[] args) {
        String[][] testWords = {
            {"hot", "dot", "dog", "lot", "log", "cog"},
            {"hot", "dot", "dog", "lot", "log"}
        };

        String[] testBegin = {"hit", "hit"};
        String[] testTarget = {"cog", "cog"};
        int[] expectedResults = {4, 0};

        BFSQueueSolution bfsSol = new BFSQueueSolution();

        for (int i = 0; i < testWords.length; i++) {
            String[] words = testWords[i];
            String begin = testBegin[i];
            String target = testTarget[i];
            int expectResult = expectedResults[i];

            int result = bfsSol.solution(begin, target, words);
            System.out.println("테스트 " + (i + 1) + ": " +
                    (result == expectResult ? "✅ 성공" : "❌ 실패") +
                    " (기대값: " + expectResult + ", 결과: " + result + ")");
        }
    }
}
