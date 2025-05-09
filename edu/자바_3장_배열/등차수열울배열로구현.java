package edu.자바_3장_배열;

public class 등차수열울배열로구현 {

	public static void main(String[] args) {
		// 등차수열 배열로 구현
//		int []arr = new int[5];
//		arr[0] = 11;
//		arr[1] = 22;
//		arr[2] = 33;
//		arr[3] = 19;
//		arr[4] = 29;
		
		//ar
		System.out.print('[');
		int[]arr = new int[10]; //등차수열 10개를 만들고
		for(int i = 0; i < 10; i++) {  
			arr[i]=3+(i+1-1)*2; //an = 3+(n-1)2
				if (i == 9)//마지막 쉼표 제거

					System.out.print(arr[i]);//마지막 쉼표 제거
				
				else
					System.out.print(arr[i]+", ");//쉼표
			}
			System.out.print("]");
		} 
}


