package com.ruby.java.ch13;

public class GenMethodTest {
	
	static <T extends Number, V extends T> boolean isInclude(T num, V[] array) {
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == num)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Integer[] inum = {1,2,3,4,5};
		Double[] dnum = {1.0,2.0,3.0,4.0,5.0};
		String[] snum = {"one","two","three","four","five"};
		
		boolean b1 =isInclude(3, inum); //여기에 젠메서드테스트 안붙은 이유는 자기 클래스안이라서 생략가능
		System.out.println("결과 : " +b1);
		
		boolean b2=isInclude(5.0,dnum);
		System.out.println("결과 : "+b2);
		//isInclude("one", snum)
		
		GenMethodTest.<Integer, Integer>isInclude(3, inum);
		GenMethodTest.<Double, Double>isInclude(5.0, dnum);
		//GenMethodTest.<String, String>isInclude("one", snum);
	}
}
