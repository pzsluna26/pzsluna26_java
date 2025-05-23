package com.ruby.java.ch11;
//catch된 객체를 출력하는 실습

public class Test01 {
public static void main(String[] args) {
	
	int arr2[] = new int[3];
	//arr2[3] = 0;
	
//	int n =10;
//	n = n/0;
	
	String st = "hello";
	st = null;
	System.out.println(st.length()); //st가 null이라서 길이도 null 예외발생. > jvm 처리 - 종료

	try {
		String s = new String("java");
		int len = s.length();
		s = null;
		s.length(); // new NullPointerException() > throw
		int arr[] = new int[3];
		arr[3] = 30; // new ArrayIndexOutOfBoundsException()
		System.out.println("OK");
	}
	
	
	catch (ArrayIndexOutOfBoundsException e1) {
		e1.printStackTrace();// 교재 542
		e1.getMessage();//throwable 인터페이스 의 메소드
		System.out.println(e1.getMessage());// 교재 542
	} 
	catch (NullPointerException e2) {
		e2.printStackTrace();
		System.out.print(e2.getMessage());
		System.out.println();
	} 
	catch (Exception e) {// 순서상 마지막에 와야
		System.out.println("오류 발생 : " + e);// e.toString()
	} 
	catch(Exception e) { //unreachable - 상위 클래스로서 모두 여기서 capture하기 때문이다
		System.out.println("Exception 처리"); 
	}
	finally {// try block에서 할당된 자원의 해제 처리
		System.out.println("GOOD");
		}
	}
}


