package com.ruby.java.ch10_11111;

import java.util.HashMap;

public class Test06 {

	public static void main(String[] args) {
		String word[]= {"BUMBLEBEE","HAVEN","ALTHOUGH ","WODER "};
		String meaning[] = {"꿀벌과에 속하는 호박벌","천국","그럼에도 불구하고","호기심이 들다"};
		
		/*단어와 뜻이 있는 배열 객체를 두개 생성 했고,
		 *나는 이 두개의 배열을 묶어서 각각의 인덱스와 값을 한 쌍으로 출력하고 싶어.
		 *그래서 키와 값을 가지는 인터페이스 맵계열의 해쉬맵이라는 클래스를 생성하여 그 클래스의 메서드를 사용해 출력할거야.
		*/
		HashMap<String,String> dic = new HashMap<String,String>(); 
		
//		dic.put("BUMBLEBEE", "꿀벌과에 속하는 호박벌 ");
//		dic.put("HEAVEN", "천국 ");
//		dic.put("ALTHOUGH", "그럼에도 불구하고 ");
//		dic.put("WONDER ", "호김심이 들다 ");
		
		for(int i =0; i<word.length; i++) {
			dic.put(word[i], meaning[i]);
		}
		System.out.println(dic);
		//dic.langth 와 dic.size 가 헷깔리는데, 랭스는 배열인덱스 갯수 이고 사이즈는 컬렉션의 요소갯수야 
		System.out.println(dic.size());
		//set=집합 
		System.out.println(dic.keySet());
		System.out.println(dic.values());
		
		//dic.get(매개변수 ) : 괄호안에 들어간 키값의 밸류를 출력함 
		System.out.println("HAVEN: "+ dic.get("HAVEN"));
		//dic.replace(매개변수1 , 매개변수2) : 키의 값을 변경
		dic.replace("HAVEN","아주 행복한 감정 ");
		System.out.println("HAVEN: " +dic.get("HAVEN"));
		//dic.put(매개변수1, 매개변수2) : 매개변수를 받은 키와 값으로 추가 
		dic.put("HAVEN", "이상적인세상" );
		System.out.println("HAVEN: "+dic.get("HAVEN"));
		System.out.println(dic.containsKey("BUMBLEBEE"));
		System.out.println(dic.containsValue("자장가 "));
		
		dic.remove("HAVEN");
		System.out.println(dic.containsKey("HAVEN"));
		
		dic.clear();
		System.out.println(dic.isEmpty());
		System.out.println(dic.size());
		
		
		
		
		
		
	}

}
