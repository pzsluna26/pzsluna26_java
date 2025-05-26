package com.ruby.java.ch11;
//catch된 객체를 출력하는 실습

public class Test01 {
public static void main(String[] args) {


	try {
	String s = new String ("Java");
	int len=s.length();
	s = null;
	s.length();
	int arr[]=new int[3];
	arr[3]=30;
	System.out.println("OK");
	} catch(ArrayIndexOutOfBoundsException e1) {
		System.out.println(e1.getMessage());
	} catch(NullPointerException e2) {
		e2.printStackTrace();
	} catch(Exception e) {
		System.out.println("오류 발생: " +e);
	}
	System.out.println("Good");	
}
}

