package ch04;

public class Test35 {

	public static void main(String[] args) {
		// for확장문 (+배열선언생성초기화 되어있는 상태)
			/* 배열을 사용해 아래 처럼 출력하라.
			 * 10
			 * 20
			 * 30
			 * 40
			 * 50
			 */
		
		// 문제 풀이 구상
			/* 1.1차원 배열선언생성초기화
			 * 2.for확장문 : for((데이터타입)참조변수 : 배열변수){실행문;)
			 * 3.출력 
			 */
		
		 int arr [] = {10,20,30,40,50};
		 for(int num : arr) {
			 System.out.println(num);
		
		// 여기서 num은 arr[0]~[4]까지를 가리키는 변수임
	 		/*
	 		 num = arr[0]; → num = 10 → 출력: 10
	  		 num = arr[1]; → num = 20 → 출력: 20
			 num = arr[2]; → num = 30 → 출력: 30
			 num = arr[3]; → num = 40 → 출력: 40
			 num = arr[4]; → num = 50 → 출력: 50
			 */
			 
		 }
	}

}
