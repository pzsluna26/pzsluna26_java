package com.ruby.java.ch10_11111;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;



public class Set {

	public static void main(String[] args) {
	
		lotto_generator(5); 
		//set을 활용하여 로또 번호 생성해보기
		/* 이용하는이유? 중복되면 안되고, 순서가 없어야하니까.(랜덤) 
		 * 해쉬셋 클래스로 셋을 구현하고,
		 * 객체 생성,난수(1~45), 반복문으로 객체 속성 참조변수 만들기 
		 *  메서드를 사용해서 출력을 해야함
		 *  */
		
		}
	public static void lotto_generator(int n) {
		Random rd = new Random();
		HashSet<Integer>lotto=null;
		
		for(int i=0; i < n; i++) {
			lotto = new HashSet<Integer>();
			
		for(int j=0; lotto.size() <= 6; j++){
			lotto.add(rd.nextInt(45)+1);
		}
		List<Integer> L = new ArrayList<Integer>(lotto);
		Collections.sort(L);
		System.out.println(L);
		
	
}
}
}
