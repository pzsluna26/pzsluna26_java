package data_structure_ex;

import java.util.Stack;

// 방향을 나타내는 열거형 (북, 북동, 동, 남동, 남, 남서, 서, 북서)
enum Directions { N, NE, E, SE, S, SW, W, NW }

// 스택에 넣을 위치 정보 클래스
class Items {
    int x;
    int y;
    int dir;

    public Items(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}

// 이동 방향 오프셋 저장 클래스
class Offsets {
    int a;
    int b;

    public Offsets(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Maze {

    static Offsets[] moves = new Offsets[8]; // 8방향 이동 정의

    public static void path(int[][] maze, int[][] mark, int m, int p) {
        Stack<Items> stack = new Stack<>();
        int i = 1, j = 1, dir = 2; // 시작 위치와 방향(동쪽)

        stack.push(new Items(i, j, dir));

        while (!stack.isEmpty()) {
            Items temp = stack.pop();
            i = temp.x;
            j = temp.y;
            dir = temp.dir;
            mark[i][j] = 1;

            while (dir < 8) {
                int g = i + moves[dir].a;
                int h = j + moves[dir].b;

                if (g == m && h == p) { // 도착했으면
                    mark[i][j] = 1;
                    mark[g][h] = 1;
                    System.out.println("path found!");
                    return;
                }

                if (maze[g][h] == 0 && mark[g][h] == 0) {
                    stack.push(new Items(i, j, dir + 1)); // 다음 방향을 위해 현재 위치 저장
                    i = g;
                    j = h;
                    dir = 0;
                    mark[i][j] = 1;
                } else {
                    dir++;
                }
            }
        }
        System.out.println("No path found");
    }

    public static void show(String title, int[][] mat) {
        System.out.println(title);
        for (int[] row : mat) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] maze = new int[14][17];
        int[][] mark = new int[14][17];

        int[][] input = { // 12 x 15
                { 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
                { 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
                { 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
                { 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
                { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
                { 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
                { 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }};

        for (int i = 0; i < 8; i++)
            moves[i] = new Offsets(0, 0);

        moves[0] = new Offsets(-1, 0);  // N
        moves[1] = new Offsets(-1, 1);  // NE
        moves[2] = new Offsets(0, 1);   // E
        moves[3] = new Offsets(1, 1);   // SE
        moves[4] = new Offsets(1, 0);   // S
        moves[5] = new Offsets(1, -1);  // SW
        moves[6] = new Offsets(0, -1);  // W
        moves[7] = new Offsets(-1, -1); // NW

        // input[][] -> maze[][]로 복사 (1칸씩 여유)
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 15; j++) {
                maze[i + 1][j + 1] = input[i][j];
            }
        }

        show("초기 maze:", maze);
        show("초기 mark:", mark);

        path(maze, mark, 12, 15);

        show("결과 maze:", maze);
        show("결과 mark:", mark);
    }
}
