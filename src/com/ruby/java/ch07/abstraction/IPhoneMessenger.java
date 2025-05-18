package com.ruby.java.ch07.abstraction;
//상속 = 단일상속(부자 클래스는 단일 상속만 가능)
//인터페이스 = 다중상속(Messenger, Workfile 을 다중상속 받는 갤럭시와 아이폰)
//복합상속 = 아이폰클래스는 그래픽클래스에게 상속받고, 인터페이를 함께 상속받는 구조 

public class IPhoneMessenger extends GraphicIOS implements Messenger {
/* '이 클래스는(IPhoneMessenger) 인터페이스(Messenger)를 상속한다'
 *     클래스: 나                  인터페이스 : 계약서
 *     나는 계약을 체결함. 법적 책임(정의된 메서드 구현)을 져야함.                 
 * ----> 클래스가 인터페이스에 정의된 메서드를 구현해야한다. */
	
	
	//인터페이스에 정의된 메서드 구현
	@Override
	public String getMessage() {
		return "iPhone";
	}

	public void setMessage(String msg) {
		System.out.println("좌우로 흔들어 문자열을 지웁니다.");		
	}
	
	public void clearMessage() {
		System.out.println("좌우로 흔들어 문자열을 지웁니다. ");
	}
}
