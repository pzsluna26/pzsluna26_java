package review;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 5단부터 7단까지 반복
		for (int dan = 5; dan <= 7; dan++) {
			System.out.println(dan+"단");
			
			// 1부터 9까지 곱하기
			for (int i = 1; i <= 9; i++) {
				System.out.println(dan + "*" + i + "=" + (dan * i));
			}
			
			// 줄바꿈
			System.out.println(); 
			
		}
		// 스캐너 닫기
		scanner.close();
	}

}
