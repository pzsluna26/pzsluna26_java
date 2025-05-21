package com.ruby.java.ch09;
	/*
	 * 교재 397 - 405 실습 코드> 아래 코드를 이해할 수 있어야 한다.
	 * 메모장 원본 수정필요(tostring에 인자 없애기)
	 */
class MyObject2 {
	public MyObject2() {} //객체 만들때 호출됨 : 아무것도 안하는 기본 생성
	public String toString() { //투스트링 오버라이딩 : 이 객체 sysout하면 이 문장이 출력됨 
		return "오버라이딩 결과: MyObject2";
	}
}

public class Test01 {
	public static void main(String[] args) {
		Object obj1 = new Object(); //부모클래스의 그냥객체 생성 
		Object obj2 = new Object(); //부모클래스의 그냥객체 생성2 
		Object obj3 = new MyObject2(); //다형성. 자식클래스를 품음 
		System.out.println(obj3); //myobject의 tostring 오버로딩 된게 출력됨 
		
		System.out.println("========================397페이지- 해시코드=====================");
		System.out.println("obj1.hashCode()=" + obj1.hashCode());//object객체의 메모리 주소 출력됨 
		System.out.println(Integer.toHexString(obj1.hashCode()));//obj1의 해쉬코드를 16진수로 변환 후 출력 
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());
		
		System.out.println("=======================398페이지- 클래스정보=====================");
//		obj3.getClass()
		Class c = obj3.getClass();//c는 객체이고 myobject2의 toString()이 있음
		System.out.println(c); // 어떤 클래스에서 만들어 졌는지 알려주는 메서
		System.out.println("객체의 클래스 이름:: " + c.getName());
		if ((c.getName()).compareTo("MyObject2")== 1)//클래스 이름에 패키지 이름도 있으므로
			System.out.println("클래스는 " + c.getName()); 
//		String st= 'hello';
//		if(st.compareTo("hello")==0) {}
			
		System.out.println("======================399페이지- 문자열로 표현====================");
//		obj1.toString()의 용도는?
//		Object obj5 = new Object();
		
		System.out.println(obj1);//toString() 결과와 같은 이유는 자동적인 타입 캐스팅 때문임 > 정수를 hexa로 변경한 것
		System.out.println(obj1.toString());//399 페이지 하단의 클래스 이름이 string
		System.out.println(obj2);
		System.out.println(obj3);//재정의된 toString() 호출
		
		System.out.println("=======================403페이지- 같은지 비교=====================");
		MyObject2 obj4 = new MyObject2();
		System.out.println(obj4);
		MyObject2 obj5 = new MyObject2();
		//obj4.equals(obj5) //MyObject의 equals()가 실행됨
		if (obj4.equals(obj5)) {//hashcode가 다르면 다른 객체로 본다 -기준은 hashcode를 갖고 판단한다
			System.out.println("동일 객체이다.");//MyObject 클래스에서 equals()를 재정의한 경우
		} else {
			System.out.println("다른 객체이다.");//Object의 equal() 사용시에는, 403페이지 내용 
		}
		System.out.println(obj4.hashCode() + ":" + obj5.hashCode());
		if (obj4 == obj5) {
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다.");
		}
		System.out.println("obj4 = " + obj4);
		MyObject2 mo2 = new MyObject2();//402페이지의 toString() 오버라이딩
		System.out.println(mo2);
	}
}




/*✅ 이 예제가 알려주려는 핵심 포인트 3가지
	① Object 클래스란?
		: 자바에서 모든 클래스의 엄마! 전부 이걸 상속받음
	② toString(), hashCode(), equals()	
		: 이건 자바 객체가 가지는 기본 기능들이야
	③ 다형성 + 오버라이딩	
		: 부모 타입으로 자식을 다루고, 자식이 기능을 바꿔 쓸 수 있음
	③ 해쉬코드가 다르면 다른 객체로 본다 
 * 
 * 
 *✅ 이해안되는 부분 
		if ((c.getName()).compareTo("MyObject2")== 1)//클래스 이름에 패키지 이름도 있으므로
			System.out.println("클래스는 " + c.getName()); 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
 