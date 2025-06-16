package data_structure_ex;

import java.util.*;

// 퀸이 놓인 위치를 기억하기 위한 클래스 
class Point {
	// 체스판의 행과 열 
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}

public class Eight_Queen {
	// 체스판의 크기 설정 (8*8)
	static final int SIZE = 8;
	// 퀸 배치 성공 횟수 
	static int numberOfSolutions = 0;

	// 가로줄에 퀸이 이미 있는지 확인하는 함수 
	public static boolean checkRow(int[][] chess, int row) {
		for (int col = 0; col < SIZE; col++) {
			// 퀸이 이미 있으면 놓을 수 없음 
			if (chess[row][col] == 1) return false;
		}
		// 퀸이 없으면 ok 
		return true;
	}

	// 세로줄에 퀸이 이미 있는지 확인하는 함수 
	public static boolean checkCol(int[][] chess, int col) {
		for (int row = 0; row < SIZE; row++) {
			if (chess[row][col] == 1) return false;
		}
		return true;
	}
	
	// ↗↙ 방향 대각선에 퀸이 있는지 확인
	public static boolean checkDiagSW(int[][] chess, int x, int y) {
		// 좌표 기준 아래 ↙ 확인
		for (int i = 1; x + i < SIZE && y - i >= 0; i++)
			if (chess[x + i][y - i] == 1) return false;
		// 좌표 기준 위 ↗ 확인
		for (int i = 1; x - i >= 0 && y + i < SIZE; i++)
			if (chess[x - i][y + i] == 1) return false;
		return true;
	}

	// ↖↘ 방향 대각선에 퀸이 있는지 확인
	public static boolean checkDiagSE(int[][] chess, int x, int y) {
		// 좌표 기준 아래 ↘ 확인
		for (int i = 1; x + i < SIZE && y + i < SIZE; i++)
			if (chess[x + i][y + i] == 1) return false;
		// 좌표 기준 위 ↖ 확인
		for (int i = 1; x - i >= 0 && y - i >= 0; i++)
			if (chess[x - i][y - i] == 1) return false;
		return true;
	}
	
	// (x, y)에 퀸을 놓을 수 있는지 확인
	public static boolean checkMove(int[][] chess, int x, int y) {
		return checkRow(chess, x) && checkCol(chess, y) && checkDiagSW(chess, x, y) && checkDiagSE(chess, x, y);
	}

	// 다음 열 중에서 퀸을 놓을 수 있는 곳을 찾음 
	public static int nextMove(int[][] chess, int row, int startCol) {
		for (int col = startCol; col < SIZE; col++) {
			// 안전하면 그 열 리턴
			if (checkMove(chess, row, col)) return col;
		}
		// 놓을 수 있는 곳 없음
		return -1;
	}

	// 퀸이 놓인 모습을 출력 
	public static void showQueens(int[][] chess) {
		// 몇 번째 해인지 출력
		System.out.println("Solution #" + (++numberOfSolutions));
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				// 퀸 있으면 Q, 없으면 .
				System.out.print(chess[i][j] == 1 ? "Q " : ". ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void EightQueen(int[][] chess) {
		// 개요1 . 스택을 사용하여 백트래킹을 구현합니다.
		Stack<Point> st = new Stack<>(); // 퀸의 위치를 기억하는 스택 만들기
		int ix = 0, iy = 0; // 처음 시작은 (0,0)
		int count = 0; // 쓴 변수지만 사용되진 않음

		// 개요2. 퀸을 한 줄씩 배치한 후, 유효한지 확인하고, 다음 줄로 이동합니다.
		// 퀸을 한 줄씩 놓기
		while (true) {
			while (ix < SIZE) {
				// 알고리즘2. 체스판의 각 열에 대해 가능한 위치를 확인하며 퀸을 배치하고, 충돌이 없다면 다음 행으로 이동
				int nextCol = nextMove(chess, ix, iy); // 놓을 수 있는 열을 찾기
				if (nextCol == -1) break; // 놓을 데가 없으면 멈추기
				chess[ix][nextCol] = 1; // 퀸을 놓음
				
				//알고리즘1.  스택을 이용하여 백트래킹을 구현하기 때문에, 현재 상태를 스택에 저장합니다. 스택의 각 원소는 퀸의 배치를 나타냅니다.
				st.push(new Point(ix, nextCol)); // 그 위치 기억하기
				ix++; // 다음 줄로 가기
				iy = 0;  // 새 줄이니까 열은 처음부터 보기
			}
			
			// 개요3. 유효하지 않으면 스택을 이용해 이전 상태로 돌아가서 다른 경로를 시도합니다.
			// 알고리즘4. 퀸 8개 배치에 성공하면 해를 저장
			if (ix == SIZE) {
				// 8개 다 놓았으면 정답
				showQueens(chess); // 퀸 위치 보여주기
				Point p = st.pop(); // 마지막 퀸 빼고
				ix = p.x; // 이전 줄로 돌아가기
				iy = p.y + 1;  // 다음 열부터 다시 시작
				chess[ix][p.y] = 0; // 퀸 치우기
			} else {
				// 알고리즘3. 더 이상 유효한 위치가 없으면 스택에서 이전 상태로 돌아가 새로운 경로 탐색
				// 놓을 곳 없어서 되돌아가기
				if (st.isEmpty()) break; // 스택 비었으면 끝
				Point p = st.pop();
				ix = p.x;
				iy = p.y + 1;
				chess[ix][p.y] = 0;
			}
		}
	}

	public static void main(String[] args) {
		int[][] data = new int[SIZE][SIZE]; // 체스판 만들기 (8x8)
		EightQueen(data);  // 8퀸 문제 풀기
		System.out.println("총 해 수: " + numberOfSolutions); // 몇 개의 해가 있는지 보여주기
		
	}
}
