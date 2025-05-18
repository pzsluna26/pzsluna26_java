package com.ruby.java.ch07.abstraction;
//상속 = 단일상속(부자 클래스는 단일 상속만 가능)
//다중상속(Messenger, Workfile 을 다중상속 받는 갤럭시와 아이폰)

public class MessengerTest {

	public static void main(String[] args) {
		
		IPhoneMessenger iphone = new IPhoneMessenger();
		GalaxyMessenger galaxy = new GalaxyMessenger();
		
		System.out.println("메신저 최소문자 크기" + Messenger.MIN_SIZE);
		System.out.println("메신저 최대문자 크기" + Messenger.MAX_SIZE);
		
		iphone.setLogin(true);
		iphone.getMessage();
		iphone.setMessage("hello");
		iphone.clearMessage();
		
		iphone.draw_submitButton();
		iphone.draw_textBox();
		
		galaxy.setLogin(true);
		galaxy.getMessage();
		galaxy.setMessage("hi");
		galaxy.changeKeyboard();
		
		galaxy.fileDownload();
		galaxy.fileUpload();

	}

}
