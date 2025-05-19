package com.ruby.java.ch08.polymorphism;

abstract class Employee {
	String name;
	int salary;
	
	public abstract void calcSalary();
	public abstract void calcBonus();
}

class Salesman extends Employee{
	int annual_sales;
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
	int num_project;
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

class Manager extends Employee{
	int num_team;
	public void calcSalary() {
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
	}

	@Override
	public void calcBonus() {
		System.out.println("Consultant 보너스 = 기본급 * 12 * 6");
	}
	}
class Director extends Manager{
	public void calcBonus() {
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
	}
}

public class HRSTest {
	
	public static void calcTax(Employee e) {
		System.out.println("소득세를 계산합니다. ");
	}
	public static void main(String[] args) {
		Salesman s1 = new Salesman();
		Employee s2 = new Consultant();
		Object s3 = new Director();
		
		Object m1 = new Manager();
		Employee m2 = new Manager();
		Manager m3 = new Manager();
		
		Object arr[] = new Object[6];
		arr[0] = s1;
		arr[1] = s2;
		arr[2] = s3;
		arr[3] = m1;
		arr[4] = m2;
		arr[5] = m3;
		
		for (int i=0; i <arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
