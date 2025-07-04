package data_structure_ex;

import java.util.*;

class Edge3 implements Comparable<Edge3> {
    int src;
    int dest;
    int weight;

    public Edge3(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public Edge3() {}

    @Override
    public String toString() {
        return "Edge3 [src = " + src + ", dest=" + dest + ", weight" + weight + "]";
    }

    @Override
    public int compareTo(Edge3 e) {
        return Integer.compare(this.weight, e.weight);
    }
}

// Disjoint Set을 위한 클래스
class Sets3 {
    int[] parent;

    public Sets3(int n) {
        parent = new int[n];
        Arrays.fill(parent, -1);
    }

    // 경로 압축 포함한 find
    public int find(int x) {
        if (parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }

    // 연결 여부 확인
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    // 단순 union
    public void simpleUnion(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY)
            parent[rootY] = rootX;
    }
}

public class Test11_3 {
    static void KruskalMST(int[][] matrix) {
        int n = matrix.length;

        List<Edge3> listEdges = new ArrayList<>();

        // 모든 간선을 리스트에 추가
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // 중복 제거를 위해 j = i+1
                if (matrix[i][j] != 0) {
                    listEdges.add(new Edge3(i, j, matrix[i][j]));
                }
            }
        }

        System.out.println("==간선 출력==");
        for (Edge3 edge : listEdges) {
            System.out.println(edge);
        }

        // Arrays.sort()를 사용하여 간선을 가중치 기준으로 정렬
        Collections.sort(listEdges);

        // Kruskal 알고리즘을 위한 Disjoint Set 초기화
        Sets3 ds = new Sets3(n);
        List<Edge3> mst = new ArrayList<>();
        int totalWeight = 0;

        // 인접리스트로 변경
        for (Edge3 edge : listEdges) {
            // 연결되어 있지 않으면
            if (!ds.connected(edge.src, edge.dest)) {
                ds.simpleUnion(edge.src, edge.dest);
                mst.add(edge);
                totalWeight += edge.weight;

                if (mst.size() == n - 1) {
                    break;
                }
            }
        }

        // MST 출력
        if (mst.size() != n - 1) {
            System.out.println("No spanning tree found.");
        } else {
            System.out.println("Minimum Spanning Tree:");
            for (Edge3 edge : mst) {
                System.out.println(edge);
            }
            System.out.println("총 비용: " + totalWeight);
        }
    }

    static final int N = 7;

    static int[][] makeGraph() {
        return new int[][]{
            {0, 28, 0, 0, 0, 10, 0},
            {28, 0, 16, 0, 0, 0, 14},
            {0, 16, 0, 12, 0, 0, 0},
            {0, 0, 12, 0, 22, 0, 18},
            {0, 0, 0, 22, 0, 25, 24},
            {10, 0, 0, 0, 25, 0, 0},
            {0, 14, 0, 18, 24, 0, 0},
        };
    }

    static void showMatrix(int[][] m) {
        System.out.println("adjacency matrix::");
        for (int[] row : m) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = makeGraph();
        showMatrix(matrix);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n명령선택:: 1. Adjacency Lists 출력, 2. spanningTree (Kruskal), 3: Quit => ");
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    showMatrix(matrix);
                    break;
                case 2:
                    System.out.println("\nMinimal Spanning Tree 작업 시작");
                    KruskalMST(matrix); // 수정된 부분
                    break;
                case 3:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }
    }
}
