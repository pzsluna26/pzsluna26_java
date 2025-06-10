package data_structure_ch05;
/*
 * 실습 5-1 : 팩토리얼 값을 재귀적으로 구함 - 직접 입력하여 실습
 * recursive relation을 이해
 */

import java.util.Scanner;

class Factorial_01 {
 //--- 음이 아닌 정수 n의 팩토리얼 값을 반환 ---//
 static int factorial(int n) {
return (n>0) ? n*factorial(n-1):1; //삼항 연산자
//     if (n > 0) {
//    	 System.out.println("return " + n + " * factorial(" + n + " - 1);");
//         return n * factorial(n - 1); //n! = n x (n-1)!
//     }
//     else {
//    	 System.out.println("return 1");
//         return 1;
//     }
 }

 public static void main(String[] args) {
     Scanner stdIn = new Scanner(System.in);

     System.out.print("정수를 입력하세요 : ");
     int x = stdIn.nextInt();

     System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
 }
}