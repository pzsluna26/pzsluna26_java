package com.ruby.java.ch08.ex;
// 인터페이스다형성 실습

/*출력답안
 * Truck: weight=33
Car: vehicleOccupants=4
Taxi: mileage =0
Truck: weight=22
MotorCycle =12000
Vehicle: 익명 클래스 */


interface Vehicle {
	public abstract void showVehicle();
}

class Truck implements Vehicle {
	int weight;

	public Truck(int weight) {
		this.weight = weight;
	}

	public void showVehicle() {
		System.out.println("Truck: weight=" + weight);
	}
}

class Car implements Vehicle {
	int vehicleOccupants;

	public Car(int vehicleOccupants) {
		this.vehicleOccupants = vehicleOccupants;
	}

	public void showVehicle() {
		System.out.println("Car: passengers=" + vehicleOccupants);
	}
}

class Taxi extends Car {
	int mileage;

	public Taxi(int vehicleOccupants, int mileage) {
		super(vehicleOccupants); // Car 생성자 호출
		this.mileage = mileage;
	}

	@Override
	public void showVehicle() {
		super.showVehicle(); // Car의 showVehicle 호출
		System.out.println("Taxi: mileage=" + mileage);
	}
}

class MotorCycle implements Vehicle {
	int price;

	public MotorCycle(int price) {
		this.price = price;
	}

	public void showVehicle() {
		System.out.println("MotorCycle: price=" + price);
	}
}

public class Ex_04 {
	public static void displayVehicles(Vehicle[] a) {
		for (Vehicle v : a) {
			v.showVehicle(); // 동적 바인딩
		}
	}

	public static void main(String[] args) {
		Vehicle[] arr = new Vehicle[5];
		arr[0] = new Truck(33);
		arr[1] = new Car(4);
		arr[2] = new Taxi(2, 9000); // Taxi는 super() 호출
		arr[3] = new Truck(22);
		arr[4] = new MotorCycle(12000);

		displayVehicles(arr);

		Vehicle v = new Vehicle() { // 익명 클래스
			public void showVehicle() {
				System.out.println("Vehicle: 익명 클래스 ");
			}
		};
		v.showVehicle();
	}
}
