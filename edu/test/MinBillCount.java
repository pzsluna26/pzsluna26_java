package edu.test;

import java.util.Scanner;

public class MinBillCount {

	public static void main(String[] args) {
		// 최초지폐수계산

		// 상품 가격 167,000원을 지불하기 위해 필요한 최소 지폐 장수는 아래와 같다
		// 5만원 * 3장
//		1만원 * 1장
//		5천원 * 1장
//		1천원 * 2장
//		천원 미만은 할인하고 임의의 금액을 지불하기 위해 필요한 지폐장수를 구하는 프로그램을 작성하세요.

		Scanner scanner = new Scanner(System.in);
		System.out.print("총액:");
		int bill = scanner.nextInt();
		// 1. 5만원권이 몇장 필요한지 확인 : 167000/50000=3
//		2. 총액에서 5만원권만큼 제하고:17000
//		3. 1만원권이 몇장 필요한지 확인
//		4. 잔액에서 1만원권만큼 제하고
//		5. 5천원권이 몇장 필요한지 확인
//		6. 잔액에서 ~
//		7. 1천원권이 몇장 필요한지 확인
		int a = bill / 50000;
		// bill-= (a+50000);
		bill %= 50000;

		int b = bill / 10000;
		bill %= 10000;

		int c = bill / 5000;
		bill %= 5000;

		int d = bill / 1000;
		bill %= 1000;

		System.out.println("5만원권:" + a);
		System.out.println("1만원권:" + b);
		System.out.println("5천원권:" + c);
		System.out.println("1천원권:" + d);
	}
}
