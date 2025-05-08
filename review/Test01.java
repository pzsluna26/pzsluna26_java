package review;

import java.util.Scanner;

public class Test01 {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("시작 숫자를 입력하세요:");
	int start = scanner.nextInt();
	
	System.out.println("끝 숫자를 입력하세요:");
	int end = scanner.nextInt();

	int oddSum = 0;
	int evenSum= 0;
	
	for (int i = start; i <= end; i++) {
		  if (i % 2 == 0) {
			  evenSum += i;
		} else {
				oddSum += i;
		}
	}
	
	int totalSum = oddSum + evenSum;
	
	System.out.println("홀수의 합:" + oddSum);
	System.out.println("짝수의 합:" + evenSum);
	System.out.println("전체 합:" + totalSum);
	
	scanner.close();
}
}
