package com.ruby.java.ch04배열;

/*
 * 배열 사용없이 변수 5개를 사용하여 5명 점수의 평균 구하기
 * int score1,score2,score3, score4, score5;
 */
public class 실습_4_1_변수를사용 {
	public static void main(String[] args) {
	//5명 점수를 score1 등의 변수로 초기화: 49, 91, 87, 67, 73
	//최대 점수, 최소 점수, 평균 점수 계산하는 코드 구현
	
	//1. 변수 5개 선언
	int score1 = 49; 
	int score2 = 91; 
    int score3 = 87;
    int score4 = 67;
    int score5 = 73;
    
    
    System.out.println("평균: " + avg(score1, score2, score3, score4, score5));
    System.out.println("최대: " + max(score1, score2, score3, score4, score5));
    System.out.println("최소: " + min(score1, score2, score3, score4, score5));
   
	}
	static int avg(int... v) {
		int sum = 0;
		for(int x : v) {
			sum += x;
		}		
		return sum/v.length;
	 	}
	static int max(int... v) {
		int smax = 0;
		for(int x : v) {
			if (smax < x) {
				smax = x;
			}
		}		
		return smax;
		}
	static int min(int... v) {
		int smin = 100;
		for(int x : v) {
			if(smin > x) {
				smin = x;
			}
		}		
		return smin;
		}
	}
	
  
    
