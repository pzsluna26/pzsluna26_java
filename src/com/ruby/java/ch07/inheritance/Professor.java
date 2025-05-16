package com.ruby.java.ch07.inheritance;
//상속과 인터페이스(접점)
public class Professor extends Person{
						//부모클래스 상속
	
	// 부모필드 + 현재필드
	private String subject;
	
	// 부모생성자 호출
	public Professor() {
		super();
		System.out.println("Professor 생성자 실행!");
	}
	
	public Professor(String name, int age, String subject) {
		super(name, age);
		this.subject=subject;
		System.out.println("Professor(name, age, dept) 생성자 실행!");
	}
	
	// (부모메서드) + 현재메서드
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	// (부모메서드) + 현재메서드 : toString 메서드(부모필드.저장)
	public String toString() {
		return super.toString()+":"+subject;
	}
}
