package com.ruby.java.ch06;

	// 정적 멤버 선언 (static member) - 스테틱 메소드 
public class StaticMethodTest {
	
	public static void print1() {
		System.out.println("hello ");
	}
	public void print2() {
		System.out.println("java ");
	}	
	
		
	public static void main(String[] args) {	
		StaticMethodTest.print1();
		/*StaticMethodTest.print2(); 
		 prin2 는 인스턴스 변수 이기 때문에, 객체변수는 호출하려면 객체 생성을 해야됨. 따라서 오류가남.
		 그래서 아래처럼 변수선언을 하면 정상 실행됨 */
		StaticMethodTest a = new StaticMethodTest();
		a.print2();
	}
}