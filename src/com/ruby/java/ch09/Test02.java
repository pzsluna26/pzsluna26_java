package com.ruby.java.ch09;

public class Test02 {
	/*
	 * ==, s1.equals(s2)
	 */
public static void main(String[] args) {
	System.out.println("=== 407페이지- String 클래스 ===");
	String s1 = new String("java");//heap에 객체 생성
	String s3 = new String("java");//객체 생성자 호출

	// s1,s3 는 heap에 객체 생성, s2,s4는 stack에 생성후 참조.
	String s2 = "java";//컴파일러가 static 영역에 데이터 생성한 후에 참조
	String s4 = "java";//String Constant Pool (문자열 상수 풀)에 저장
	System.out.println("-----------------------------------------------------");
	System.out.println("=== 409페이지- 문자열 비교 ===");
	//객체를 식별하는 해시코드야. 
	System.out.println("s1,s3의 해시코드 비교>>  " +System.identityHashCode(s1)+":" + System.identityHashCode(s3));//같은 값
	System.out.println("s1, s3의 출력값 비교>>  " + s1 + " : "+ s3.toString());
	System.out.println("s2,s4의 해시코드 비교>>  " +s2.hashCode()+":" + s4.hashCode());//s2, s4 : 같은 값
	if (s1 == s3) {//s1, s3은 다른 값이다			
		System.out.println("s1 == s3::동일 객체이다.");
	} else {
		System.out.println("s1 == s3::다른 객체이다.");
	}
	System.out.println("-----------------------------------------------------");
	System.out.println(System.identityHashCode(s2)+":" + System.identityHashCode(s4));//같은 값
	//객체의 참조값을 기반으로 한 해시값을 반환
	//Object 클래스의 원래 hashCode()와 동일하게 동작
	//System.identityHashCode()
	//이 메서드는 객체의 클래스에서 hashCode() 메서드를 오버라이드했는지 여부와 상관없이, 
	//원래 Object 클래스에서 제공하는 기본 hashCode() 값을 반환해.
	System.out.println(s2.hashCode()+":" + s4.hashCode());//같은 값
	//s2.hashCode()는 "java"라는 문자열의 내용에 기반한 해시값을 반환
	
	if (s2 == s4) {
		System.out.println("s2 == s4::동일 객체이다.");
	} else {
		System.out.println("s2 == s4::다른 객체이다.");
	}
	
	if (s1.equals(s3)) {//Object의 equal()를 overriding - hash code가 아닌 값으로 비교하도록 String class에서 재정의한 것
		System.out.println("s1.equals(s3)::동일 문자열을 가집니다.");
	} else {
		System.out.println("s1.equals(s3)::다른 문자열을 가집니다.");
	}
	
	if (s1 == s3) {
		System.out.println("s1 ==s3 ::동일 문자열을 가집니다.");
	} else {
		System.out.println("s1 != s3::다른 문자열을 가집니다.");
	}
	
	System.out.println("s1 = " + s1 + ", s2 = " + s2);
	String s5 = "JAVA";

	if (s1.equals(s5)) {
		System.out.println("s1.equals(s5)::동일 문자열을 가집니다.");
	} else {
		System.out.println("s1.equals(s5)::다른 문자열을 가집니다.");
	}
	//equalsIgnoreCase()란?
	//equalsIgnoreCase()는 String 클래스의 메서드로, 두 문자열의 내용을 비교할 때 대소문자의 차이를 무시하고 비교해요.
	//즉, "Hello"와 "hello"는 이 메서드를 사용하면 같다고 판단해요.
	if (s1.equalsIgnoreCase(s5)) {
		System.out.println("s1.equalsIgnoreCase(s5)::동일 문자열을 가집니다.");
	} else {
		System.out.println("s1.equalsIgnoreCase(s5)::다른 문자열을 가집니다.");
		}
		
	}
}

/*
 이 예제의 핵심은:

== 연산자는 두 객체가 같은 메모리 주소를 참조하는지 확인해.
.equals() 메서드는 두 객체의 내용이 같은지 확인해.
자바에서는 문자열을 비교할 때 ==보다 .equals()를 사용하는 것이 일반적이야.
왜냐하면 ==는 객체의 참조(주소)를 비교하고, .equals()는 객체의 내용을 비교하기 때문이야.
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
 * 
 * 
 * */
 