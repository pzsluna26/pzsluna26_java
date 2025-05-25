package com.ruby.java.ch09;

public class MyObject {

	int num;
	
	MyObject(int num){
		this.num =num;
		
	}
	public String toString() {
		return "MyObject";
	}
	public boolean equals(Object obj) {
		boolean result = false;
		MyObject arg = (MyObject) obj;
		if(this.num == arg.num) {
			result = true;
		}
		return result;
	}
}
/*이 코드는 Java에서 equals() 메서드를 오버라이드하여 
 * 두 객체의 num 값이 같은지를 비교하는 예제입니다.  
 * 여기서 핵심은 다운캐스팅(downcasting)의 사용입니다.*/
