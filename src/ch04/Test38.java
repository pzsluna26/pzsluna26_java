package ch04;

public class Test38 {

	public static void main(String[] args) {
		// 2차원 배열 순회 (배열+반복문+행열length)  
		/* 1. 2차원 배열 선언생성초기화
		 * 2. 반복문을 중첩 (행 반복문, 열 반복문) 
		 * */
		 
		
		int arr [][] = new int[5][5];
		int num =1;
		
		// 첫번째 for문 의 i,j(지역변수) : 배열순회를 위한 변수 
		for(int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				arr[i][j]= num++;
			}
		}
		
		// 두번째 for문 의 i,j:출력순회를 위한 변수 
		for(int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+"\t");
		} 
			System.out.println();
		}
	}
}

		/* Tip
		1. for문의 변수들은 지역변수라서, 밖에서 쓸 수 없음. 따라서 for문 출력은 다시 하나 더 써야함.
			즉, 첫번째 for문에 i,j 는 계산하기 위한 지역변수이고 
			   두번째 for문에i,j 는 출력하기 위한 지역변수 이다. 
		2. fpr문의 작동방식은, i반복문 에서 넘어가 j반복문이 끝난다음, 다시 1로 넘어감. 따라서 줄바꿈은 j반복문 밖에 하면 행이 바
		*/
