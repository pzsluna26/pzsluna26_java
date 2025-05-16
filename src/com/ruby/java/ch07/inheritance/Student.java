package com.ruby.java.ch07.inheritance;
//상속과 인터페이스(접점)
public class Student extends Person{
					//부모클래스 상속
	// 부모필드 + 현재필드
	private String major;
	
	// 부모생성자 호출
	public Student() {
		super();
		System.out.println("Student 생성자 실행!");
	}
	
	public Student(String name, int age, String major) {
		super(name, age);
		this.major = major;
		System.out.println("Student(name, age, dept) 생성자 실행!");
	}
	
	// (부모메서드) + 현재메서드
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	// (부모메서드) + 현재메서드 : toString 메서드(부모필드.저장)
	public String toString() {
		return super.toString()+ ":"+ major;
	}
}
