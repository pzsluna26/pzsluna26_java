package com.ruby.java.ch06;

public class ArmorTest2 {

	public static void main(String[] args) {
	Armor suit = new Armor();
	/* 참조변수 끊기 (객체와 연결끊김 = 아무값도 가지지 않는다) 
	suit = null;
	*/
	suit.setName("mark6");
	suit.setHeight(180);
	
	System.out.println(suit.getName() + ":" + suit.getHeight());
	}
}
