package com.ruby.java.ch07.abstraction;
// 복합상속 = 아이폰클래스는 그래픽클래스에게 상속받고, 인터페이를 함께 상속받는 구조 
public class GraphicIOS {
	public void draw_textBox() {
		System.out.println("텍스트 상자를 그린다. ");
	}
	public void draw_submitButton() {
		System.out.println("전송버튼을 그린다. ");
	}
}
