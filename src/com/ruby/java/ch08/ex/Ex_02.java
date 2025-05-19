package com.ruby.java.ch08.ex;
// 내부클래스구현
/*전체 개요

이 예제는 "귤(Mandarin)의 종류"를 enum으로 정의하고, 해당 enum에 가격 정보(정수)를 붙여서 다음을 보여줍니다:
enum 생성자 실행 시점
enum 상수들(금귤, 한라봉, …)이 객체처럼 어떻게 동작하는지
사용자에게 귤 종류를 선택받고, 해당 정보를 출력*/

import java.util.Scanner;

// 귤 종류를 enum으로 정의하고, 각 종류에 가격을 부여
enum Mandarin {
	금귤(600), 한라봉(500), 레드향(300), 천혜향(400), 황금향(800);

	private int price;

	// enum 생성자: 각 enum 상수마다 한 번씩 호출됨
	Mandarin(int p) {
		price = p;
		System.out.println("enum 생성자 실행:: price = " + price);
	}

	int getPrice() {
		return price;
	}

	// ordinal 값으로 해당 enum 상수를 찾아 반환
	static Mandarin MandarinAt(int idx) {
		for (Mandarin m : Mandarin.values())
			if (m.ordinal() == idx)
				return m;
		return null;
	}
}

public class Ex_02 {
	static Scanner stdIn = new Scanner(System.in);

	// 사용자로부터 귤 종류를 선택받는 메뉴 메서드
	static Mandarin selectMenu() {
		int key;
		do {
			for (Mandarin m : Mandarin.values()) {
				System.out.print(m.ordinal() + ". ");
				System.out.println(m + " (" + m.getPrice() + ")");
			}
			System.out.print("선택: ");
			key = stdIn.nextInt();
		} while (key < Mandarin.금귤.ordinal() || key > Mandarin.황금향.ordinal());

		return Mandarin.MandarinAt(key);
	}

	public static void main(String[] args) {
		Mandarin m; // 생성자 호출하지 않음

		// enum 상수 사용 → enum 클래스 생성자들이 한 번씩 호출됨
		Mandarin ma = Mandarin.한라봉;
		System.out.println(ma.toString());
		System.out.println("===enum 객체 생성전===");

		// ordinal 기반 비교
		System.out.println("황금향과 비교: " + ma.compareTo(Mandarin.레드향));

		// 상수 직접 사용 및 이름 기반 생성
		Mandarin m2 = Mandarin.금귤;
		Mandarin ma2 = Mandarin.valueOf("레드향");
		System.out.println(ma2);

		// 전체 enum 상수 출력
		Mandarin list[] = Mandarin.values();
		System.out.println("== 귤의 종류 ==");
		for (Mandarin m3 : list)
			System.out.println(m3 + ": " + m3.getPrice());

		// 사용자 선택
		Mandarin mSelected = selectMenu();
		System.out.println(mSelected + ": selectedMenu: " + mSelected.getPrice());
	}
}
