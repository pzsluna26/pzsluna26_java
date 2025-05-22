package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.Iterator;

public class Test02 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("서울"); list.add("북경"); list.add("상해");
		list.add("서울"); list.add("도쿄"); list.add("뉴욕");
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("====================");
	
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		//확장for: 배열안의 전체 내용을 출력할때는 확장for문 쓰는게 좋음.
		System.out.println("====================");
		for(String c : list) {
			System.out.println(c);
		}
		
		System.out.println("====================");
		//거꾸로 출력되게 해보기
		for(int i = list.size()-1; i >=0;i--) {
			System.out.println(list.get(i));
		}
		
	}
}
