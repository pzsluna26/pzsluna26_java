package edu.자바_3장_배열;

public class Test32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[11,22,33,19,29] 를 만들어 보시오

		int []arr = new int[5];
		arr[0] = 11;
		arr[1] = 22;
		arr[2] = 33;
		arr[3] = 19;
		arr[4] = 29;
		
		
		//for문
		System.out.print("[");//괄호 열기
		for(int i = 0; i < 5; i++) {
			if (i == 4)//마지막 쉼표 제거
				System.out.println(arr[i]);//마지막 쉼표 제거
			else
				System.out.print(arr[i]+", ");//쉼표
		}
		System.out.println("]");//괄호 닫기
		
		//위의 식에서 최대값, 최소값 구하기
	    //최대값:
		//최소값:
		//평균: 

		
	}

}
