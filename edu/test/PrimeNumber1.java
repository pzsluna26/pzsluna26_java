package edu.test;

import java.util.Scanner;

public class PrimeNumber1 {

	public static void main(String[] args) {
		//소수판단
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Number[0:eit]");
			int num = sc.nextInt();
			if (num == 0) break;
			if(isPrime(num) == true)
				System.out.println(num + " is a Prime.");
			else 
				System.out.println(num + " is not a Prime.");
		}
			sc.close();
			System.out.println("Done!");
		
		// num이 소수면 true, 그렇지 않으면 false를 리턴
	public static boolean isPrime(int num) {
		for(int i = 2; i < num; i++) {
			if(num)
		}
		 
	}
		
	}

}
