package com.ruby.java.ch07.ex01;

class Item { // 제품
    private String name; // 제품명
    private double price; // 제품 가격
    private int stockQuantity; // 재고량

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	// 재고 감소 메소드
    public void reduceStock(int quantity) {
    }
    
    // 재고 증가 메소드
    public void increaseStock(int quantity) {
    }

    // 정보 출력 메소드
    public void show() {
    }
}
