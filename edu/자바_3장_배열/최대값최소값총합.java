package edu.자바_3장_배열;

public class 최대값최소값총합 {
	public static void main(String[] args) {
		int []arr = new int[5];
		arr[0] = 11;
		arr[1] = 22;
		arr[2] = 33;
		arr[3] = 19;
		arr[4] = 29;
		
		int sum = 0;
		int smin = 0;
		int smax = 99;
		
		for (int j=0; j < 5; j++) {
			if (smin > arr[j])
				smin = arr[j];
			if (smax < arr[j])
				smax = arr[j];
			sum += arr[j];
		}
		System.out.println("최대값: "+ smax);
		System.out.println("최소값: "+ smin);
		System.out.println("총합: "+ sum);
		
	}
}
	
	//위의 식에서 최대값, 최소값 구하기
    //최대값:
	//최소값:
	//총합: 
