package edu.자바_2장_데이터활용;

public class Test14 {

	public static void main(String[] args) {
		//page.91 test14
		char c = 'A';
		int nc = c;
		System.out.println("nc="+nc);
		c ^=(1<<5);
		System.out.println(c);
		nc = c;
		System.out.println(nc);
		
		//삼항 연산자
		int a = 10;
		int b = 20;
		int max = (a > b)? a:b;
		System.out.println(max);
	
		//직접타입변경
		byte i = 10;
		byte j = 20;
		byte k = i+j;//자바에서 덧셈은 int 정수 기반 결과를 만든다.
	}

}
