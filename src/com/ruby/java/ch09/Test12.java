package com.ruby.java.ch09;
/*
 * 교과서 p.429 실습 - 스트링의 정렬 
 */
import java.util.Arrays;
public class Test12 {
	static void showData(String[]arr) {
		System.out.println();
		for (String st: arr)
			System.out.print(st + " -> ");
}
static void sortData(String[]arr, int[]arrInt) {
	for (int i = 0; i< arr.length;i++)
	{
		arrInt[i] = Integer.parseInt(arr[i]);
	}
	Arrays.sort(arrInt);
}
static void showNumber(int[]arr) {
	System.out.println();
	for (int n: arr)
		System.out.print(n + " -> ");
}
public static void main(String[] args) {
	// string 정렬의 문제 
	String arr[] = {"12", "9", "222", "5", "888", "112"};
	// 정수 배열이 아님
	showData(arr);
	Arrays.sort(arr);
	showData(arr);
	
	int n1 = 10;
	Integer obj1 = n1; // Integer.valueOf(n1)
	//왼쪽과 오른쪽이 타입이 다름. 그래서 위 integer.valueof로 자동으로 객체로 만들어줌
	
	//obj1.* - methods를 사용하기 위해
	//parseInt 문자열을 int로 바꿔줌!
	Integer obj2 = Integer.parseInt("20");// "9", "12" 정렬시에는 12,9가 온다 이때 필요:432페이지 표
	               		//파스: 문자를 숫자로 바까줌
	int n2 = obj2; // obj2.intValue()
	//obj2.hashCode();
	
	Integer obj3 = 30; // new Integer(30)

	int n3 = obj3 + 40;

	System.out.println("\n" + n1 + " : " + obj1);
	System.out.println(obj2 + " : " + n2);
	System.out.println(n3);
	//정수로 배열로 변환후 정렬 
		int []arrInt = new int[arr.length];
		sortData(arr, arrInt);
		showNumber(arrInt);

	}
}
/*
 * 
 * 🧠 이 예제의 핵심 포인트

문자열 배열 정렬의 한계: 문자열 배열을 정렬하면 숫자의 크기 순서가 아닌 사전순으로 정렬됩니다.
문자열을 정수로 변환하여 정렬: 문자열을 정수로 변환한 후 정렬하면 숫자의 크기 순서대로 정렬할 수 있습니다.
Integer 클래스와 오토박싱: 기본형 int와 객체형 Integer 간의 변환과 관련된 개념을 이해할 수 있습니다.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
