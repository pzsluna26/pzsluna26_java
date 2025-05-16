package com.ruby.java.ch07.inheritance;
//상속-부모클래스
public class Person {
	private String name;
	private int age;
	
	public Person() {
		System.out.println("Person 생성자 실행!");
	}
	public Person(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	/*toString() 메서드는 Person 객체를 "이름:나이" 문자열 형식으로 표현하도록 정의된 메서드다.
	이런 메서드를 사용하면 나중에 오버라이드(덮어쓰기) 재정의 하면 그때그때 원하는 형식으로 쉽게 출력할 수 있다.
	*/
	public String toString() {
		return name + ":" + age;
	}
	
}
