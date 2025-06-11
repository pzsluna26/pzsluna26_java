package data_structure_ch05;

public class MagicSquare {

    public static void main(String[] args) {
        int n = 3; // 마방진의 크기
        int[][] magicSquare = new int[n][n];

        // 마방진 생성 알고리즘 (루벤스의 방법)
        int row = 0, col = n / 2; // 시작 위치
        for (int num = 1; num <= n * n; num++) {
            magicSquare[row][col] = num; // 현재 위치에 숫자 배치
            // 다음 위치 계산(북동쪽 = 위로 한 칸, 오른쪽으로 한 칸)
            int nextRow = row -1;
            int nextCol = col +1;
            
            if(nextRow < 0) nextRow = n - 1;
            if(nextCol >= n) nextCol = 0;
            
            // 이미 숫자가 있는 경우: 현재 위치의 아래로 이동
            if(magicSquare[nextRow][nextCol] != 0) {
            	row = row + 1;
            } else {
            	row = nextRow;
            	col = nextCol;
            }
        }

        // 마방진 출력
        showSquare(magicSquare);

        // 마방진의 합 확인
        int magicSum = n * (n * n + 1) / 2;
        System.out.println("가로, 세로, 대각선의 합 =  " + magicSum );
        System.out.println("마방진 검사 = " + checkSquare(magicSquare, magicSum));
    }

    // 마방진 출력 메서드
    static void showSquare(int[][] magicSquare) {
    	for(int[] row : magicSquare) {
    		for(int num : row) {
    			System.out.printf("%2d",num);
    		}
    		System.out.println();
    	}
    }
    	
    // 마방진 유효성 검증 메서드 (magicSqure 의 열,행,양 대각선 들의 합이 15가 맞는지 확인하는 메서드)
    static boolean checkSquare(int[][] magicSquare, int magicSum) {
    int n = magicSquare.length;
    	// 행 검사
    	for(int i=0; i<n; i++) {
    		int rowSum = 0;
    		for(int j=0; j<n; j++) {
    			rowSum += magicSquare[i][j];
    		}
    		if(rowSum != magicSum) {
    			return false;
    		}
    	}
    		
    	// 열 검사
    	for(int j=0; j<n; j++) {
    		int colSum = 0;
    		for(int i=0; i<n; i++) {
    			colSum += magicSquare[i][j];
    		}
    		if(colSum != magicSum) {
    			return false;
    		}
    	}
    

    	// 주 대각선 검사 (0,0),(1,1),(2,2)
    	int diag1 = 0;
    	for(int i=0; i<n; i++) {
    		diag1 += magicSquare[i][i];
    	}
    	if (diag1 != magicSum) {
    		return false;
    	}
    	
    	// 반대 대각선 검사
    	int diag2 = 0;
    	for(int i=0; i<n; i++) {
    		diag2 += magicSquare[i][n-1-i];
    	}
    	if (diag2 != magicSum) {
    		return false;
    	}
    	
    	return true;
}
}