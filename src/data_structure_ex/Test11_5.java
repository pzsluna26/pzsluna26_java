package data_structure_ex;

import java.util.Arrays;
import java.util.Scanner;

// 최단거리
//1. 벨만포드
//2. 다익스트라
//3. 무방향
//4. 행렬

class Graph5 {
    private static final int NMAX = 10;
    private static final int MAX_WEIGHT = 999999;
    private int[][] length = new int[NMAX][NMAX]; // 10x10
    private int[] dist = new int[NMAX]; // 현재까지 확정된 최단거리들(시작정점에서 해당정점까지)
    									//최단거리 => 최대값
    private final int n; // ?????? => main 확인
    
    private boolean[] s = new boolean[NMAX]; // s??????
 
    
    //생성자 가장 큰 역할 => 필드 초기화(주어진게 int, boolean)
    public Graph5(int nodeSize) {
    	this.n =nodeSize;
    	// 그래프 초기화
    	for(int i = 0; i<n; i++) {
    		Arrays.fill(length[i], MAX_WEIGHT);
    		// 자기 자신한테 가는 거리 0
    		length[i][i] = 0;
    	}
    }

    // 간선 추가 메서드 (방향그래프 + 가중치그래프)
    public void insertEdge(int start, int end, int weight) {
    	length[start][end] = weight;
    
    }
    
    // 인접행렬 출력 메서드
    public void displayConnectionMatrix() {
    	for(int i = 0; i < n; i++) {
    		for(int j =0; j < n; j++) {
    			if(length[i][j] == MAX_WEIGHT) {
    				// '못간다' 기호로 표시
    				System.out.print(" ∞");
    				
    			} else {
    				System.out.print(length[i][j]+" ");
    			}
    		}
    		System.out.println();
    	}
    }
    
    // 다익스트라 사용할 수 있는지 미리 판단하는 메서드 (간선 가중치 음수인지 아닌지 확인)
    // 다익스트라 알고리즘은 음수 간선 비허용
    // 음수가 있으면 벨만-포드 알고리즘 사용해야함
    public boolean isNonNegativeEdgeCost() {
    	for(int i = 0; i < n; i++) {
    		for(int j =0; j < n; j++) {
    			//음수를 찾았음 => false
    			if(length[i][j] != MAX_WEIGHT && length[i][j] < 0) {
    				return false;
    			}
    		}
    	}
    	return true;
    }

    // 핵심메서드
    public void shortestPath(int startNode) {
    	// 최단거리 미확정
        Arrays.fill(s, false);
        // 시작 정점에서 각 정점까지의 초기 거리를 length 배열에서 가져옴
        for (int i = 0; i < n; i++) { // i => 몇 번째 정점을 확정 중인가?
            dist[i] = length[startNode][i];
            // a정점(시작정점/고정)에서 b,c,d ... 정점으로 가는 거리
        }
        // 시작 정점은 이미 최단 경로가 확정됐다고 표시
        s[startNode] = true;
        // 시작 정점에서 자기 자신까지의 거리는 0
        dist[startNode] = 0;
        
        // 전역탐색 => 최단거리 알고리즘(다익스트라)
        for (int i = 0; i < n - 1; i++) {
        	// 아직 방문하지 않은 정점 중 최단 거리(dist)가 가장 짧은 정점 선택
        	int  u = choose();
        	// 그 정점의 최단 거리를 확정
        	s[u] = true;
        	for(int j = 0; j<n; j++) { // j => 정점 u에서 정점 j로 가는 거리가 더 짧은가?
        		if(!s[j] && dist[u] + length[u][j] < dist[j]) {
        			// 더 짦은 거리로 갱신
        			dist[j] = dist[u]+length[u][j];
        		}
        	}
        	//s=[t,f,f]
        	//dist=[0,4,2]
        	//가장 작은 값을 가져와야함 (choose)
        	//최단거리를 합산해서 기록
        }
        printDistances(startNode);
    }

    // 아직 방문 안 한 곳 중에 출발점에서 가장 가까운곳이 어딘지 찾는 메서드
    private int choose() {
    	// 가장 작은 거리 후보를 아주 큰 값으로 초기화 (MAX_WEIGHT는 큰 수)
        int minDist = MAX_WEIGHT;
        // 최소 거리인 정점 위치를 아직 못 찾았으니까 -1로 초기화
        int minPos = -1;
        for(int i = 0; i<n; i++) {
        	// s[i]가 false면 아직 최단 거리 확정 안 된 정점
            // dist[i]가 현재까지 알려진 시작점에서 i까지의 거리
        	if(!s[i] && dist[i] < minDist) { 
        		minDist = dist[i]; // 더 작은 거리 발견하면 갱신
        		minPos = i; // 그 정점 번호도 저장
        	}
        }
        return minPos; // 최종적으로 가장 가까운 정점 번호 반환
    }

    private void printDistances(int startNode) {
        System.out.print("출발노드 " + startNode + ": ");
        for (int i = 0; i < n; i++) {
        	System.out.print("->("+i+")");
            System.out.print((dist[i] == MAX_WEIGHT ? "∞" : dist[i]) + " ");
        }
        System.out.println();
    }
}
public class Test11_5 {
	static void showMatrix(int[][] m) {
		System.out.println("Adjacency matrix:");
		for (int[] row : m) {
			for (int num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
    public static int[][] makeGraph1() {
        return new int[][]{
            {0, 6, 5, 7, 0, 0, 0},
            {6, 0, -2, 0, -1, 0, 0},
            {5, -2, 0, -2, 1, 0, 0},
            {7, 0, -2, 0, 0, -1, 0},
            {0, -1, 1, 0, 0, 0, 3},
            {0, 0, 0, -1, 0, 0, 8},
            {0, 0, 0, 0, 3, 8, 0}
        };
    }

    public static int[][] makeGraph2() {
        return new int[][]{
            {0, 300, 1000, 0, 0, 0, 0, 1700},
            {300, 0, 800, 0, 0, 0, 0, 0},
            {1000, 800, 0, 1200, 0, 0, 0, 0},
            {0, 0, 0, 1200, 1500, 1000, 0, 0},
            {0, 0, 0, 1500, 0, 250, 0, 0},
            {0, 0, 0, 1000, 250, 0, 900, 1400},
            {0, 0, 0, 0, 0, 900, 0, 1000},
            {1700, 0, 0, 0, 0, 1400, 1000, 0}
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph5 g = null;

        System.out.println("1: 그래프(가중치 마이너스), 2: 그래프(도시간 거리)");
        int select = scanner.nextInt();
        if (select == 1) {
            int[][] matrix = makeGraph1();
            showMatrix(matrix);
            g = new Graph5(7);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] != 0) {
                        g.insertEdge(i, j, matrix[i][j]);
                    }
                }
            }
        } else if (select == 2) {
            int[][] matrix = makeGraph2();
            showMatrix(matrix);
            g = new Graph5(8);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] != 0) {
                        g.insertEdge(i, j, matrix[i][j]);
                    }
                }
            }
        } else {
            System.out.println("Invalid input. Exiting.");
            scanner.close();
            return;
        }

        while (true) {
            System.out.print("\nCommands: 1: Display Matrix, 2: Dijkstra (non-negative), 3: Quit => ");
            select = scanner.nextInt();
            if (select == 3) break;

            switch (select) {
                case 1:
                    g.displayConnectionMatrix();
                    break;
                case 2:
                    if (g.isNonNegativeEdgeCost()) {
                        System.out.print("Start node: ");
                        int startNode = scanner.nextInt();
                        g.shortestPath(startNode);
                    } else {
                        System.out.println("Negative edge가 존재하므로 Bellman-Ford 알고리즘 사용해야 한다.");
                    }
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
        scanner.close();
    }
}
