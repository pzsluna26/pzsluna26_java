package data_structure_ch05;

import java.util.Stack;

enum knightMoves {NW, NE, EN, ES, SE, SW, WW, WN}

class Offsets4 {
	int a;
	int b;
	public Offsets4(int a, int b) {
		this.a = a; this.b = b;
	}
}
public class KnightTracking {
	static Offsets4[] moves = new Offsets4[8];//static을 선언하는 이유를 알아야 한다
    static final int N = 5;

	
    // 체스판 배열
    private static int[][] board = new int[N][N];

    // Point 객체로 나이트의 위치를 저장
    static class Point {
        int x, y, moveToward;

        Point(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.moveToward = move;
        }
    }

    /* 체스판을 초기화 (-1로 설정) 
     * => for 반복문으로 체스판 전부 -1로 바꿔주기 */
    private static void initializeBoard() {
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			board[i][j] = -1;
    		}
    	}
    }

    // 체스판의 범위 내에서 유효한 움직임인지 확인 => 아직 안밟은 칸인지 확인하기
    private static boolean isSafe(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    // 나이트 투어 알고리즘 (비재귀적으로 스택 사용)=> 8가지
    private static boolean solveKnightTracking(int startX, int startY) {
    	for (int ia = 0; ia < 8; ia++)
    		moves[ia] = new Offsets4(0, 0);//배열에 Offsets4 객체를 치환해야 한다.
    	moves[0].a = -2;	moves[0].b = -1;//NW으로 이동
    	moves[1].a = -2;	moves[1].b = 1;//NE
    	moves[2].a = -1;	moves[2].b = 2;//EN
    	moves[3].a = 1;		moves[3].b = 2;//ES
    	moves[4].a = 2;		moves[4].b = 1;//SE
    	moves[5].a = 2;		moves[5].b = -1;//SW
    	moves[6].a = -1;	moves[6].b = -2;//WS
    	moves[7].a = 1;		moves[7].b = -2;//WN
        // 나이트가 이동할 수 있는 8가지 방향
        
        Stack<Point> stack = new Stack<>();

    
        // 시작 위치를 스택에 푸시
        stack.push(new Point(startX, startY, 0));
        board[startX][startY] = 0; // 시작 위치는 첫 번째 이동

        	while (!stack.isEmpty()) {
            //현재 위치를 꺼내고,(pop말고 peek쓰는 이유: pop은 제거라서)
        	Point cur = stack.peek();
        	
        	//현재 몇번째 방향을 시도했는지 확인해라
        	int i = cur.moveToward;
        	boolean moved = false;
        		
        	
        	// 8가지 방향으로 나이트 이동 시도
        	while(i<8) {
        	// 현재위치에서 i번째 방향으로 이동한 다음 좌표를 계산해라.
        		int nextX = cur.x + moves[i].a;
        		int nextY = cur.y + moves[i].b;
        	// 이동한 칸이 체스판 안에 있고, 아직 안 밟은 칸이면
        		if (isSafe(nextX, nextY)) {
        	// 이동 성공시: 다음 방향 정하고, 이동하고, 방문 순서 스택에 저장하고(인덱스번호 -1), 반복문 종료
        		cur.moveToward = i+1;
        		stack.push(new Point(nextX,nextY,0));
        		board[nextX][nextY] = stack.size()-1;
        		moved = true;
        		break;
        		
        	}
        		i++;
    		
    		 }
        	// 이동 실패하면, 이전 칸으로 되돌아감(백트래킹) 초기화시에 방문하지 않은 칸은 -1 로 약속했었음  
        	if(!moved) {
        		board[cur.x][cur.y] = -1;
        		stack.pop();
        	}
        	
            // 스택 크기가 체스판 크기 만큼 되면 모든 칸을 방문 완료 -> 성공!
        	if(stack.size() == N * N){
        		return true;
        	}
        
        }	// 더 이상 이동할 곳이 없을 경우 폴스 리턴
        	return false;
    }

    // 결과 출력
    private static void showTracking() {
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			System.out.printf(board[i][j]+" ");
    		}
    		System.out.println();
    	}
    	
    }

    public static void main(String[] args) {

        initializeBoard();

        // 나이트가 (0, 0)에서 시작
        if (solveKnightTracking(0, 0)) {
            showTracking();
        } else {
            System.out.println("해결할 수 없습니다.");
        }
        
    }
}
