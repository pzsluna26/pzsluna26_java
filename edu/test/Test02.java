package edu.test;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		// 구구단 5단부터 7단까지 출력하는 프로그램
		 
		Scanner scanner = new Scanner(System.in);
		System.out.print("num:");
		int num = scanner.nextInt();
		
		int n1 = 0;
		int n2 = 0;
		
		for(int i = n1; i <= n2; i++) {
			for(int j = 1; j < 10; j++) {
				System.out.println(i + "*" + j + "=" +(i*j));		
			}
			}
			System.out.println("\n"); // 한 줄 바꿈
	}
}
