package com.ruby.java.ch06;

public class Armor {
	// 클래스와 객체생성
	
	//필드 선언 
	private String name;
	private int height;
	
	//게터세터 메서드 선언 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public static void main(String[] args) {
	// 객체 생성 
	Armor person = new Armor();
	
	// 세터에 값 저장 
	person.setName("luna");
	person.setHeight(158);
	
	// 게터로 값 출력
	System.out.println("제 이름은"+person.getHeight()+"입니다. ");
	System.out.println("제 키는"+person.getName()+"입니다. ");
	

	}

}
