package com.ruby.java.ch07.abstraction;

abstract class Employee {
	String name;
	int salary;
	
	public abstract void calcSalary();
	public abstract void calcBonus();
}

class Salesman extends Employee{

	@Override //상속 + 추상메서드 구현
	public void calcSalary() {
		System.out.println("Salesman 급여 = 기본급 + 판매수당");
	}
	@Override
	public void calcBonus() {
		System.out.println("Salesman 보너스 = 기본급 * 12 * 4");
	}
	}

class Consultant extends Employee{
	//상속 + 추상메서드 구현
	@Override
	public void calcBonus() {
		System.out.println("Consultant 보너스 = 기본급 * 12 * 2");
	}
	@Override
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 컨설팅 특별 수당");	
	}
	}

abstract class Manager extends Employee{
	public void calcSalary() {
		System.out.println("Director 보너스 = 기본급 * 12 * 6");
	}
	}
class Director extends Manager{
	public void calcBonus() {
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
	}
}

public class HRSTest {
	public static void main(String[] args) {
		Salesman s = new Salesman();
		Consultant c = new Consultant();
		Director d = new Director();
	

		s.calcBonus();
		
		c.calcBonus();
		
		d.calcSalary();
	}

}
