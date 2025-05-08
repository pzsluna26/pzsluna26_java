package edu.자바_2장_데이터활용;

public class Test3 {

	public static void main(String[] args) {
		long totalSales;
		totalSales= 2147483648L;
		//단순 숫자는 int literal로 인식.
		//L은 Long int literal로 인식하게 한다.
		System.out.println(totalSales);

		//실수
		float exchangeRate = 11346.50f;//메모리크기 때문에 오류발생
		
		//참조
		String name = "Amy";
		String greet = "Hello, how are you! I am fine!";
		System.out.println("greet의 길이 = " + greet.length());
		
	}
}
