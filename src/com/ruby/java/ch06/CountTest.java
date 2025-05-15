package com.ruby.java.ch06;

	// 정적 멤버 선언 (static member) - 스테틱 변수 
	class Count {
		public static int totalCount;
		int count;
	}
	
	
public class CountTest {
	public static void main(String[] args) {
		Count c1 = new Count();
		Count c2 = new Count();
		Count c3 = new Count();
		
		c1.count++;
		Count.totalCount++;
		
		c2.count++;
		Count.totalCount++;
		
		c3.count++;
		Count.totalCount++;

		
		System.out.println(Count.totalCount+":"+c1.count);
		System.out.println(Count.totalCount+":"+c2.count);
		System.out.println(Count.totalCount+":"+c3.count);
		
		/*정적 맴버 즉 스테틱맴버는 공유하는 것. 그래서 totalCount는 3, 인스턴스변수는 1이다. */
	}
}
