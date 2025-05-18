package com.ruby.java.ch07.ex01;

//Item 클래스
class Item2 {
	private String name;
	private double price;
	private int stockQuantity;
	
	public Item2(String name, double price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	public void reduceStock(int quantity) {
		if ( stockQuantity >= quantity) {
			stockQuantity -= quantity;
		} else { 
			System.out.println("재고 부족: " + name);
		}
	}

	public void increaseStock(int quantity) {
		stockQuantity += quantity;
	}
	
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}
	public void show() {
		System.out.println("제품명: " + name + ", 가격: " + price + ", 재고: " + stockQuantity);
	}

	@Override
	public String toString() {
		return "제품명: " + name + ", 가격: " + price + ", 재고: " + stockQuantity;
	
}
}

//Electronics 클래스 (Item 클래스를 상속)
class Electronics extends Item2 {
	private int warranty; // 제품 보증 기간
	
	public Electronics(String name, double price, int stockQuantity, int warranty) {
		super(name, price, stockQuantity);
		this.warranty = warranty;
	}

	@Override
	public void show() { 
		super.show();
		System.out.println(", 보증기간: " + warranty + "개월 ");

	}

	@Override
	public String toString() {
		 return super.toString()+ ", 보증기간: " + warranty + "개월 ";
	}		
	}


//Clothing 클래스 (Item 클래스를 상속)
class Clothing extends Item2 {
	private String size;
	private String color;

	public Clothing(String name, double price, int stockQuantity, String size, String color) {
		super(name, price, stockQuantity);
		this.size = size;
		this.color = color;
	}
	
	@Override
	public void show() {
		super.show();
		System.out.println(", 사이즈: "+size+"색상: "+color);
		
	}

	@Override
	public String toString() {
		return super.toString() + ", 사이즈: " + size + " 색상: " + color;		
	}
}


//Customer 추상 클래스 정의
abstract class Customer2 {
	private String cname;
	private String city;
	private int age;
	
	public Customer2(String cname, String city, int age) {
		this.cname = cname;
		this.city = city;
		this.age = age;
	}

	public void show() {
		System.out.println("고객명: "+ cname + "도시: "+ city + "나이: " + age);
	}

	@Override
	public String toString() {
		return "고객명: "+ cname + "도시: "+ city + "나이: " + age;
	}

	abstract double applyDiscount(double totalAmount);
		
}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer extends Customer2 {
	static final double REGULARDISCOUNT_RATE = 0.03;

	public RegularCustomer(String name, String city, int age) {
		super(name, city, age);
	}

	@Override
	double applyDiscount(double totalAmount) {
		// 일반 고객 할인 적용
		return totalAmount * (1 - REGULARDISCOUNT_RATE);
	}
}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer extends Customer2 {
	static final double PREMIUMDISCOUNT_RATE = 0.1;

	public PremiumCustomer(String name, String city, int age) {
		super(name, city, age);
	}

	@Override
	double applyDiscount(double totalAmount) {
		return totalAmount * (1 - PREMIUMDISCOUNT_RATE);
	}
}


//Order 클래스
class Order2 {
	private Customer2 customer;
	private Item2[] items;
	private int[] quantities;
	private int itemCount;
	
	public Order2(Customer2 customer, int maxItems) {
		this.customer = customer;
		this.items = new Item2[maxItems];
		this.quantities = new int[maxItems];
		this.itemCount = 0;
	}


	public void addItem(Item2 item, int quantity) {
		if(itemCount < items.length) {
    		items[itemCount] = item;
    		quantities[itemCount] = quantity;
    		item.reduceStock(quantity);
    		itemCount++; 
    	} else {
    		System.out.println("주문 가능한 아이템 수 초과 ");
    	}
    }

	public double calculateTotal() {
		double total = 0;
		for(int i=0; i<itemCount; i++) {
			total += items[i].getPrice() * quantities[i];
		}
		return total;
	}

	public double calculateDiscountedTotal() {
		double total = calculateTotal();
		return customer.applyDiscount(total);
	}
	
	public void printOrderSummary() {
		System.out.println("고객정보: " + customer);
		for (int i = 0; i < itemCount; i++) {
			System.out.println("제품: " + items[i].toString() + ", 수량: " + quantities[i] + ", 금액: " + (items[i].getPrice() * quantities[i]));
		}
		double total = calculateTotal();
		double discountedTotal = calculateDiscountedTotal();
		System.out.println("총액: " + total);
		System.out.println("할인된 총액: " + discountedTotal);
		System.out.println("할인 금액: " + (total - discountedTotal));
		System.out.println("--------------------------------------");
	}
	}
		/*
		 * 할인된 가격의 합계 출력 할인 금액 합계 출력
		 */
public class Ex_02 {
	public static void main(String[] args) {
		// 의류 및 전자제품 생성
		Item2 laptop = new Electronics("노트북", 1200.00, 10, 24);
		Electronics phone = new Electronics("휴대폰", 800.00, 30, 12);
		Clothing tshirt = new Clothing("티셔츠", 20.00, 50, "M", "Blue");
		Clothing jacket = new Clothing("자켓", 80.00, 20, "L", "Black");

		// 고객 생성
		PremiumCustomer premiumCustomer = new PremiumCustomer("홍길동", "부산", 30);
		RegularCustomer regularCustomer = new RegularCustomer("계백", "양산", 25);

		// 주문 생성
		Order2 order1 = new Order2(premiumCustomer, 4);
		order1.addItem(laptop, 1);
		order1.addItem(tshirt, 2);

		Order2 order2 = new Order2(regularCustomer, 4);
		order2.addItem(phone, 1);
		order2.addItem(jacket, 1);

		// 주문 요약 출력
		System.out.println("Premium Customer Order:");
		order1.printOrderSummary();

		System.out.println("Regular Customer Order:");
		order2.printOrderSummary();
	}
}
