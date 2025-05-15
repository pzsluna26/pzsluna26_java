package com.ruby.java.ch06;

public class ThisTest {
	int i = 1;
	
	public void first() {
		int i = 2;
		int j = 3;
		this.i = i+j;
		//5
		second(4);
		System.out.println(this.i);
		//9
	}	
	
	public void second(int i) {
		int j = 5;
		this.i = i+j;
	}
	
	public static void main(String[] args) {
		ThisTest exam = new ThisTest();
		exam.first();
	}
}
