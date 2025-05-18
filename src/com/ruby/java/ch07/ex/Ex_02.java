package com.ruby.java.ch07.ex;

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

	
	/* 추상메서드
	 * 상속받는 클래스가 이 메서드를 반드시 구현하게 하려고 쓴다.
	 * 부모클래스(Customer2)가 틀만 정해 주고,
	 * 자식클래스(레귤러, 프리미엄) 가 각자 다르게 할인로직을 구현하기 위함이다! 
	 */
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

	/* 할인계산
	 * 10000 * 0.1 = 1000원 (할인되는 금액)
	 * 10000 * (1-0.1) = 9000원 (할인적용된 금액)
	 */
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


	/* 쇼핑 장바구니를 구현하는 메서드
	 * itemCount는 지금까지 담은물건 개수이고, 
	 * items.length는 장바구니에 담을 수 있는 최대 개수야 !
	 * 
	 *  아직 장바구니에 자리가 있으면,
	 *  items[] 배열에 물건을 넣고, 
	 *  quantities[] 배열에 수량도 넣어.
	 *  그리고 item.reduceStock(quantity); 로 재고에서 해당 수량만큼 빼줘
	 *  마지막으로 itemCount 를 1증가 시켜서 배열의 다음칸으로 이동할 준비를 해.
	 */
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
	
	/* 장바구니에 담긴 물건 전체 가격을 계산하는 메서드!
	 * total이라는 돈주머니에 처음엔 0원이 들어있었음!
	 * 반복문으로 장바구니에 들어있는 각 물건의 가격*수량을 계산해서,
	 * total에 하나씩 더해줘
	 * 마지막에 total을 반환해서 전체 금액을 알려주는거야!
	 * */
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
