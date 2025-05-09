package edu.자바_2장_데이터활용;

public class Test7 {

	private static int snum;

	public static void main(String[] args) {
		int a = 10;
		int b,c;
	
		b = a++;
		c = ++a;
		System.out.println("a="+ a +",b="+ b +",c=" + c);
		
		int num = -a;//negation 연산자 
		System.out.println("num="+num);
		short sunm = -10;
		short num2 = (short) -snum;//negation연산 결과는 int숫자이다.
		
		
		//부정연산자
		boolean isOn = false;
		boolean result = !isOn; //부정연산자
		while (!isOn) {

	}

}
