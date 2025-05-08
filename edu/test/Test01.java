package edu.test;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		//1~100까지 홀수 합, 짝수 합, 전체 합
		// 1. 짝수 합을 저장할 변수 선언
		// 2. 홀수 합을 저장할 변수 선언
		// 3. 전체 합을 저장할 변수 선언
		// 4. 1에서 100까지 for 루프를 돌면서 짝수는 짝수합에 더하고 홀수는 홀수 합에 더하고, 전체합에 무조건 더하고
		// 5. 각 합 결과를 출력
		Scanner scanner = new Scanner(System.in);
		System.out.print("num:");
		int num = scanner.nextInt();

		
		int a = 0;
		int b = 0;
		int c = 0;

		for(int i = a; i < num; i++) {
			if((i%2) == 0) 
				a += i;
			else 
				b += i;
			c += i;
		}
	
			System.out.println("짝수 합:" + a);
			System.out.println("홀수 합:" + b);
			System.out.println("전체 합:" + (a + b));
	}
}
