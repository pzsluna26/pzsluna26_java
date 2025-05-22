package com.ruby.java.ch10;

import java.util.HashSet;
import java.util.Random;

public class Test10_1 {

	public static void main(String[] args) {
		//hashset객체를 만들기
		HashSet<Integer> lotto = null;
		//랜덤객체 만들기(씨드넘버)
		Random number = new Random(199611);
		//반복문 조건: 셋안에 저장된 데이터 갯수가 6이아닌동안 돌기
		for(int i =0; i<6;i++) {
			lotto.add(number.nextInt(45+1));
		}
			//랜덤객체 1~45 데이터를 생성해서 셋안에 저장
		
		//반복문 빠져나온 셋안에 저장된 데이터 출력하기

	
	}
}
