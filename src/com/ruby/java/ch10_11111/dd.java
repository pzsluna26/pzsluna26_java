package com.ruby.java.ch10_11111;

import java.util.HashMap;

public class dd {

	public static void main(String[] args) {
		HashMap<String,String> dic = new HashMap<String,String>();
		dic.put("BUMBLEBEE", "꿀벌과에 속하는 호박벌 ");
		dic.put("HEAVEN", "천국 ");
		dic.put("ALTHOUGH", "그럼에도 불구하고 ");
		dic.put("WONDER ", "호김심이 들다 ");
		
		//반복문 사용해서 출력.
		for(String key:dic.keySet()) {
			System.out.println(String.format("%s : %s", key, dic.get(key)));
		}
	}
	

}
