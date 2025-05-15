package com.ruby.java.ch06;

public class ArmorTest {
	public static void main(String[] args) {
		// 인스턴스 생성 후 참조변수를 통해 인스터스를 사용하기 
		
		// 객체 생성 (인스턴스 생성) 
		Armor suit1 = new Armor();
		Armor suit2 = new Armor();
		Armor suit3 = new Armor();
		
		// 객체 (인스턴스) 사용 - 세터메소드 (값 저장)
		suit1.setName("mark6");
		suit1.setHeight(180);
		
		suit2.setName("mark16");
		suit2.setHeight(220);
		
		suit3.setName("mark38");
		suit3.setHeight(200);
		
		// 객체(인스턴스) 출력 - 게터메소드 (값 꺼냄) 
		System.out.println(suit1.getName() + ":" + suit1.getHeight());
		System.out.println(suit2.getName() + ":" + suit2.getHeight());
		System.out.println(suit3.getName() + ":" + suit3.getHeight());

	}
}
		/* Tip
		Armor 클래스 필드에서 이미 게터세터를 정의 했기때문에,
		참조변수로 가져와서 객체를 생성하고 게터세터를 쓸 수 있었음. 
		게터세터 실행은 메인에서 해야함. 
		*/