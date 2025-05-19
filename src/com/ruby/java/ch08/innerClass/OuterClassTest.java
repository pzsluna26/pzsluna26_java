package com.ruby.java.ch08.innerClass;

public class OuterClassTest {

	public static void main(String[] args) {
		Messenger test = new Messenger() {

			@Override
			public String getMessage() {
				return "Test";
			}

			@Override
			public void setMessage(String msg) {
				System.out.println("test에 메시지를 설정합니다.:" + msg);
			}
			};
			
			System.out.println(test.getMessage());
			test.setMessage("have a nice day!");
		}
	}

