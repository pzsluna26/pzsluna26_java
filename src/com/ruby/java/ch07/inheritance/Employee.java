package com.ruby.java.ch07.inheritance;
//상속과 인터페이스(접점)
public class Employee extends Person {
					//부모클래스 상속
	// (부모필드) + 현재필드
	private String dept;
	
	// 부모생성자 호출
	public Employee() {
		super();
		System.out.println("Employee 생성자 실행!");
	}
	
	public Employee(String name, int age, String dept) {
		super(name, age);
		this.dept=dept;
		System.out.println("Employee(name, age, dept) 생성자 실행!");
	}

	// (부모메서드) + 현재메서드
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	// 부모클래스의 toString 오버라이딩(부모필드.저장)
	/*public String toString() {
		return name + ":" + age + dept;
	  }

	  위 처럼 부모클래스의 toString을 오버라이딩 하려고 하면, 오류가 뜬다.
	  그 이유는, 접근제한자 때문이다. 부모클래스의 필드(name, age)가 private이기 때문이다.
	  그렇다면, private로 선언된 필드는 게터로 리턴받을 수 있다.
	 */
	public String toString() {
		return super.toString()+ ":" + dept;
}
}