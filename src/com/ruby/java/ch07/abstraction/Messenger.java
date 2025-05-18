package com.ruby.java.ch07.abstraction;
//상속 = 단일상속(부자 클래스는 단일 상속만 가능)
//다중상속(Messenger, Workfile 을 다중상속 받는 갤럭시와 아이폰)


public interface Messenger {
	// 부모클래스 변수 선언 및 추상메서드 선언(자녀 메서드에서 구현해야함)
	public static final int MIN_SIZE =1;
	public static final int MAX_SIZE =104857600;
	
	public abstract String getMessage();
	
	public abstract void setMessage(String msg);
	
	public default void setLogin(boolean login) {
		log();
		if(login) {
			System.out.println("로그인 처리합니다.");
		} else {
			System.out.println("로그아웃 처리합니다.");
		}
	}
	public static void getConnection() {
		System.out.println("network에 연결합니다. ");
	}
	
	private void log() {
		System.out.println("start job!");
	}
}
