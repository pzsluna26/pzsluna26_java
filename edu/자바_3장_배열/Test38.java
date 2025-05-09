package edu.자바_3장_배열;

import java.util.Random;

public class Test38 {

	public static void main(String[] args) {

		int[][]arr = new int[5][5];
		Random rnd = new Random();
		for(int i=0; i<arr.length; i++)
			for(int j=0; j<arr[0].length; j++) {
				arr[i][j]=rnd.nextInt(100);
			}
		for(int i=0; i<arr.length; i++) 
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			} System.out.println();
			
				
		//2차원 배열에서 확장형 for문 사용(위의 것 더 간략하게 만듬)
		for (int[] row : arr) { //int[] row는 각 행을 나타낸다
			for (int v : row) { //row 변수가 각 행이므로 1차원 배열이다
				System.out.print(v+" ");
			}
			System.out.println();
		}

}
}