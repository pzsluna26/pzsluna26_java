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
        int i = 1, j = 1, dir = 0;  // 시작 지점과 방향
        mark[i][j] = 1; // 시작 위치 마킹
        stack.push(new Items(i, j, dir));  // 시작 위치를 스택에 저장

        //막다른곳을 저장해놓기
        while (!stack.isEmpty()) {
            Items temp = stack.pop();
            i = temp.x;
            j = temp.y;
            dir = temp.dir;
        
            //8가지 방향중에서 남은 방향에 대하여
            while (dir < 8) {
            	//현재 위치 (i,j)에 대하여 이동 방향 계산
                int g = i + moves[dir].a; //예를 들어 dir = 0이면 → moves[0].a = -1 => i행을 -1 이동 
                int h = j + moves[dir].b;
                // 배열 범위 체크 추가
                if (g < 0 || g >= maze.length || h < 0 || h >= maze[0].length) {
                    dir++;
                    continue;
                }
                if (g == m && h == p && maze[g][h] == 0) {// 도착했으면
                    mark[g][h] = 1;//도착후 좌표 방문표시
                    System.out.println("path found!");
                    return;
                }
                // 미로 길이 있고, 가본적이 없으면 => 가보자
                if (maze[g][h] == 0 && mark[g][h] == 0) {
                    mark[g][h] = 1;
                    stack.push(new Items(i, j, dir + 1));  // 현재 좌표와 다음 방향 저장
                    i = g;
                    j = h;
                    dir = 0; // 새 위치에서는 다시 방향 0부터
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

        // 이동 방향 설정
        moves[0] = new Offsets(-1, 0);  // N
        moves[1] = new Offsets(-1, 1);  // NE
        moves[2] = new Offsets(0, 1);   // E
        moves[3] = new Offsets(1, 1);   // SE
        moves[4] = new Offsets(1, 0);   // S
        moves[5] = new Offsets(1, -1);  // SW
        moves[6] = new Offsets(0, -1);  // W
        moves[7] = new Offsets(-1, -1); // NW

        // input을 maze에 복사 (1칸씩 여유 있게)
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 15; j++) {
                maze[i + 1][j + 1] = input[i][j];
            }
        }

        show("초기 maze:", maze);
        show("초기 mark:", mark);

        path(maze, mark, 12, 15); // 목표 좌표는 (12,15)

        show("결과 maze:", maze);
        show("결과 mark:", mark);
    }
}
