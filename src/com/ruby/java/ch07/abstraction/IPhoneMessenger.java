package com.ruby.java.ch07.abstraction;

public class IPhoneMessenger implements Messenger {
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
