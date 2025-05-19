package com.ruby.java.ch08.ex;
// 동적바인딩 (할인 포함한 주문 처리 시스템)
/* 문제 요약 
 
 * Item은 추상 클래스: 제품의 공통 속성(name, price, stock)과 공통 메서드 포함
 * Electronics, Clothing: Item 상속 — 각각 고유 필드와 show() 오버라이드
 * Discountable: 인터페이스 — getDiscountedPrice() 메서드만 선언
 * SeasonalDiscount: Discountable 구현 — 시즌 할인을 적용
 * Order: 제품 배열, 수량 배열 등을 가지고 주문을 처리하는 클래스. 할인 적용도 해야 함
 * Customer: 추상 클래스 — 고객 할인 정책을 위해 applyDiscount()를 정의
 * RegularCustomer, PremiumCustomer: 각각 다른 할인율로 고객 할인 적용*/

/* Tip: 포인트 요약

Item의 show() 메서드는 추상 메서드 → 동적 바인딩을 보여줌
Discountable 인터페이스로 시즌 할인 구현
Customer 추상 클래스는 고객별 할인율 차이 구현
Order 클래스는 SeasonalDiscount를 상속받아 두 가지 할인 모두 적용 가능
main()은 전체 흐름을 테스트*/


abstract class Item {
    private String name; // 제품명
    private double price; // 제품 가격
    private int stockQuantity; // 재고량

    public Item(String name, double price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void reduceStock(int quantity) {
        if (stockQuantity >= quantity) {
            stockQuantity -= quantity;
        } else {
            System.out.println("재고 부족: " + name);
        }
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

    public abstract void show();
}

class Electronics extends Item {
    int madeYear;

    public Electronics(String name, double price, int stockQuantity, int madeYear) {
        super(name, price, stockQuantity);
        this.madeYear = madeYear;
    }

    @Override
    public void show() {
        System.out.println("[전자제품] " + getName() + " | 가격: " + getPrice() + " | 재고: " + getStockQuantity() + " | 제조년도: " + madeYear);
    }
}

class Clothing extends Item {
    int size;

    public Clothing(String name, double price, int stockQuantity, int size) {
        super(name, price, stockQuantity);
        this.size = size;
    }

    @Override
    public void show() {
        System.out.println("[의류] " + getName() + " | 가격: " + getPrice() + " | 재고: " + getStockQuantity() + " | 사이즈: " + size);
    }
}

interface Discountable {
    double getDiscountedPrice(double price);
}

class SeasonalDiscount implements Discountable {
    private double discountRate = 0.1; // 10% 할인

    @Override
    public double getDiscountedPrice(double price) {
        return price * (1 - discountRate);
    }
}

class Order extends SeasonalDiscount {
    private final int N = 20;
    private Customer customer;
    private Item[] items;
    private int[] quantities;
    private String[] orderDates;
    private int count = 0;

    public Order(Customer customer) {
        this.customer = customer;
        this.items = new Item[N];
        this.quantities = new int[N];
        this.orderDates = new String[N];
    }

    public void addItem(Item item, int quantity, String date) {
        if (count >= N) {
            System.out.println("최대 주문 수량 초과");
            return;
        }
        this.items[count] = item;
        this.quantities[count] = quantity;
        this.orderDates[count] = date;
        item.reduceStock(quantity);
        count++;
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            double price = items[i].getPrice();
            int quantity = quantities[i];
            total += price * quantity;
        }
        return total;
    }

    public void printOrderSummary() {
        System.out.println("주문 요약:");
        for (int i = 0; i < count; i++) {
            System.out.println("- " + items[i].getName() + " x" + quantities[i] + " (" + orderDates[i] + ")");
        }
        System.out.println("총액 (할인 전): " + calculateTotal());
    }

    public void printDiscountDetails() {
        double total = 0;
        System.out.println("할인 내역:");
        for (int i = 0; i < count; i++) {
            double original = items[i].getPrice();
            double seasonal = getDiscountedPrice(original); // 10% 시즌 할인
            double finalPrice = customer.applyDiscount(seasonal); // 고객 할인 추가
            double lineTotal = finalPrice * quantities[i];

            System.out.printf("- %s: 정가 %.2f -> 시즌할인 %.2f -> 고객할인 %.2f * %d개 = %.2f\n",
                    items[i].getName(), original, seasonal, finalPrice, quantities[i], lineTotal);

            total += lineTotal;
        }
        System.out.printf("총 지불 금액: %.2f\n", total);
    }
}

abstract class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    abstract double applyDiscount(double totalAmount);

    public String getName() {
        return name;
    }
}

class RegularCustomer extends Customer {
    static final double REGULAR_DISCOUNT_RATE = 0.03;

    public RegularCustomer(String name) {
        super(name);
    }

    @Override
    double applyDiscount(double totalAmount) {
        return totalAmount * (1 - REGULAR_DISCOUNT_RATE);
    }
}

class PremiumCustomer extends Customer {
    static final double PREMIUM_DISCOUNT_RATE = 0.1;

    public PremiumCustomer(String name) {
        super(name);
    }

    @Override
    double applyDiscount(double totalAmount) {
        return totalAmount * (1 - PREMIUM_DISCOUNT_RATE);
    }
}

public class Ex_01{
    static void showItemsStock(Item[] items) {
        for (Item item : items) {
            item.show(); // 동적 바인딩
        }
    }

    public static void main(String[] args) {
        Item[] items = new Item[4];

        items[0] = new Electronics("노트북", 1500, 100, 2023);
        items[1] = new Clothing("티셔츠", 50, 100, 95);
        items[2] = new Electronics("휴대폰", 800, 100, 2024);
        items[3] = new Clothing("청바지", 80, 100, 90);

        showItemsStock(items);

        Customer regularCustomer = new RegularCustomer("홍길동");
        Customer premiumCustomer = new PremiumCustomer("강감찬");

        Order regularOrder = new Order(regularCustomer);
        regularOrder.addItem(items[0], 1, "240901");
        regularOrder.addItem(items[1], 2, "240902");

        regularOrder.printOrderSummary();
        regularOrder.printDiscountDetails();

        Order premiumOrder = new Order(premiumCustomer);
        premiumOrder.addItem(items[1], 1, "240901");
        premiumOrder.addItem(items[3], 2, "240903");

        premiumOrder.printOrderSummary();
        premiumOrder.printDiscountDetails();

        showItemsStock(items);
    }
}

