package com.rudy.java.ch05;

public class Test04  {
	public static void main(String[] args) {
		System.out.println(addNumber(1));
		System.out.println(addNumber(1,2));
		System.out.println(addNumber(1,2,3));
		System.out.println(addNumber(1,2,3,4));
	}
		
	
	private static int addNumber(int ...v) {
		System.out.print(v.length + ":");
		int sum = 0;		
		for (int x : v) {
		    sum += x;
			System.out.print(x + " ");
	}
			System.out.print("==>");
			return sum;
	}
}
	