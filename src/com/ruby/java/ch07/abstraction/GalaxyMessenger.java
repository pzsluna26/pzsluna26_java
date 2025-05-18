package com.ruby.java.ch07.abstraction;
// 상속 = 단일상속(부자 클래스는 단일 상속만 가능)
// 다중상속(Messenger, Workfile 을 다중상속 받는 갤럭시와 아이폰)

public class GalaxyMessenger implements Messenger, Workfile {
	public String getMessage() {
		return "galaxy";
	}
	
	public void setMessage(String msg) {
		System.out.println("galaxy에서 메시지늘 설정합니다 : " + msg);
	}
	
	public void changeKeyboard() {
		System.out.println("키보드아이콘 터치후 키보드를 변경합니다");
	}

	public void setLogin(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fileUpload() {
		System.out.println("file을 업로드 합니다. ");
	}

	@Override
	public void fileDownload() {
		System.out.println("file을 다운로드 합니다. ");
	}
}
