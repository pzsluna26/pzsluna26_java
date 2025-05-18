package com.ruby.java.ch07.ex01;
class Item2 {
	private String name;
	private double price;
	private int stockQuantity;

	public void reduceStock(int quantity) {
		if ( stockQuantity >= quantity) {
			stockQuantity -= quantity;
		} else { 
			System.out.println("재고 부족: " + name);
		}
	
	}

	public void increaseStock(int quantity) {

	}
}











public class Ex_02 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
