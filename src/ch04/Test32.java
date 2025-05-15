package ch04;

public class Test32 {
	public static void main(String[] args) {
		
		// 배열 선언과 초기값 생성 그리고 초기화
			/* 배열을 사용해 아래 처럼 출력하라.
			 * 10
			 * 20
			 * 30
			 * 40
			 * 50
			 */
		
		// 문제 풀이 구상
			/* 1차원 배열 ,줄바꿈 출력 
			 */
		
		int arr [] = new int[5];
		arr[0]=10;
		arr[1]=20;
		arr[2]=30;
		arr[3]=40;
		arr[4]=50;
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
	}
}
