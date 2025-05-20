package com.ruby.java.ch08.ex2222;

class Item { // 제품
    private String name; // 제품명
    private double price; // 제품 가격
    private int stockQuantity; // 재고량
    
   
	public Item(String name, double price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
	// 재고 감소 메소드
    public void reduceStock(int quantity) {
    	if(stockQuantity >= quantity) {
    		stockQuantity -= quantity;
    	} else {
    		System.out.println("재고 부족:" + name);
    	}
    }
    // 재고 증가 메소드
    public void increaseStock(int quantity) {
    	stockQuantity += quantity;
    }
    public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
    
	
	
	
class Customer {
    private String cname;
    private String city;
    private int age;
     
    //리스트- 생성자(필수정보있어서)
    public Customer(String cname, String city, int age) {
		super();
		this.cname = cname;
		this.city = city;
		this.age = age;
	}
    
    //정보 출력 메소드
    public void show() {
        System.out.println("이름" + cname + "도시"+city+"나이"+age);
    }
    @Override
    public String toString() {
    	return "이름: " + cname + ",도시 : "+ city + ", 나이: " + age;
    }
        
    }

class Order {
    private Customer customer; // 고객
    private Item[] items; // 주문 제품들
    private int[] quantities; // 주문 제품 수량들
    private String []orderDates;
    private int count; // 아이템 개수

    public Order(Customer customies, int maxItems) {
		this.customer = customer;
		this.items = new Item[maxItems];
		this.quantities = new int[maxItems];
		this.orderDates = new String[maxItems];
		this.count = 0;
	}







public class 객체생성 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
