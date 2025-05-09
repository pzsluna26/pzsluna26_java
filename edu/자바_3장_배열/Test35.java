package edu.자바_3장_배열;

public class Test35 {

	public static void main(String[] args) {
		double []arr = {1.1,2.2,3.3,4.4,5.5};
		//for문 확장 : 배열의 모든 요소 다
		for (double x: arr)
			System.out.print(x + " ");
		System.out.println();
		
		
		//for문 + if : 배열 속에서 조건이 있을 때
		for (int i=0; i<arr.length; i++) {
			if(arr[i] > 3.3)
				System.out.print(arr[i] + " ");
		}
	}

}
