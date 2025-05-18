package com.ruby.java.ch07.ex01;
import java.time.LocalDate;
class Item { // 제품
	
	// class설계 (아이템 생성)
 
    private String name; // 제품명
    private double price; // 제품 가격
    private int stockQuantity; // 재고량
    
    public Item(String name, double price, int stocQantity) {
    	this.name = name;
    	this.price = price;
    	this.stockQuantity = stocQantity;
    }
    
    // 재고 감소 메소드
    public void reduceStock(int quantity) {
    	if(stockQuantity >= quantity) {
    		stockQuantity -= quantity;
    	} else {
    		System.out.println("재고 부족: " + name);
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
    
}


//class설계 {고객 생성)
class Customer {//고객 
    private String cname;
    private String city;
    private int age;
    
    //리스트-생성자(필수정보있어서)
    public Customer(String cname, String city, int age) {
    	this.cname = cname;
    	this.city = city;
    	this.age = age;
    }
  
    //정보 출력 메소드
    public void show() { 
    	System.out.println(" 이름:  " + cname + "도시: " + city + "나이: " + age);
    }     
    @Override
    // toString은 사용한 클래스 customer을 호출하면 반환값을 줌. 
    public String toString() {
        return "이름: " + cname + ", 도시: " + city + ", 나이: " + age;
    }

}


//class설계 {주문 생성)
class Order {
    private Customer customer; // 고객
    private Item[] items; // 주문 제품들
    private int[] quantities; // 주문 제품 수량들
    private LocalDate[] orderDates;
    private int count; // 아이템 개수

    public Order(Customer customer, int maxItems) {
    	this.customer = customer;
    	this.items = new Item[maxItems]; //주문할 물건 칸  (채워야함) 
    	this.quantities = new int[maxItems];//주문할 물건갯수 칸   
    	this.orderDates=new LocalDate[maxItems];
    	this.count = 0; //물건 갯수 
    }
	// 아이템 추가 메소드
    /*만약에 물건 최대 칸 수가 남아 있으면, 
     *물건칸에 추가해도 돼,
     *몇개 샀는지도 추가해도 ,
     *오늘의 날짜를 기록해
     *물건 넣었으니까, 숫자 하나 올려줘. 다음 물건칸에 들어가야하니깐
     *그게아니라면 
     *이제 못넣어요! 라고말해줘  */
    public void addItem(Item item, int orderQuantity) {
    	if(count < items.length) {
    		items[count] = item;
    		quantities[count] = orderQuantity;
    		orderDates[count] = LocalDate.now();
    		count++; 
    	} else {
    		System.out.println("주문 가능한 아이템 수 초과 ");
    	}
    }
 
    // 총액 계산 메소드
    public double calculateTotal() {
    double total = 0;
    /* i를 변수라고 생각하지말고, count(개수) 만큼 반복한다! 고 해석하기 
     * items[i] = i번째 물건의 가격
     * quantities[i] = i번째 물건의 갯수  
     * 예를 들어, 사과를(1000원)  2개 샀으면
     * 사과가격 * 개수 = 사과 구매 총액 
     * 총액 + total= total(모든 구매 총액의 변수 )
     * 다 더하고 나서 그 결과를 돌려줘 ! 
     */
    for(int i=0; i<count; i++) {
    	total += items[i].getPrice() * quantities[i];
    } 
    return total;
    }
    
    // 주문 요약 출력 메소드
    public void printOrderSummary() {
    	System.out.println("고객정보:" + customer);
        for (int i = 0; i < count; i++) {
            System.out.println("제품명: " + items[i].getName()+
            		", 단가:"+ items[i].getPrice() +
            		", 개수:"+ quantities[i] +
            		" ==> 가격: " + (items[i].getPrice() * quantities[i])+
            		", 주문일: " + orderDates[i]);
            				}
        System.out.println("총액: " + calculateTotal());
        System.out.println("-------------------------------------------------------------------");
    
    }
}
    
 public class Ex_01 {
    public static void main(String[] args) {
        // 아이템 생성
        Item laptop = new Item("노트북", 1200.00, 10);
        Item tshirt = new Item("티셔츠", 20.00, 50);
        Item phone = new Item("휴대폰", 800.00, 30);
        Item headphones = new Item("헤드폰", 150.00, 20);
        Item mouse = new Item("마우스", 30.00, 15);

        // 고객 생성
        Customer boy = new Customer("홍길동", "부산", 21);
        Customer girl = new Customer("계백", "양산", 22);

        // 주문 생성
        Order order1 = new Order(boy, 5); // 최대 5개 아이템
        order1.addItem(laptop, 1);
        order1.addItem(tshirt, 2);
        order1.addItem(phone, 1);
        order1.addItem(headphones, 1);
        order1.addItem(mouse, 1);

        Order order2 = new Order(girl, 5); // 최대 5개 아이템
        order2.addItem(laptop, 1);
        order2.addItem(tshirt, 1);
        order2.addItem(phone, 1);
        order2.addItem(headphones, 1);
        order2.addItem(mouse, 1);

        // 주문 요약 출력
        order1.printOrderSummary();
        order2.printOrderSummary();
    }
 }

    
    



