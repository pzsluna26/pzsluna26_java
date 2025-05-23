package com.ruby.java.ch10_11111;

import java.util.ArrayList;

public class Test01 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("서울"); list.add("상해"); list.add("뉴욕");
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
