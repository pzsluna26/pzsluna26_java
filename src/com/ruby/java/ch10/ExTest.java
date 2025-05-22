package com.ruby.java.ch10;
//교수님이 총정리 해주신다고 만든 예제
//array list, hashmap

import java.util.ArrayList;
import java.util.HashMap;

class Item{
	String name;
	Integer pid;
	public Item(String name, Integer pid) {
		this.name =name;
		this.pid = pid;
	}
	@Override
	public String toString() {
		return name + ":" + pid;
	}
}

class ItemA extends Item {
	String size;
	public ItemA(String name, Integer pid, String size) {
		super(name,pid);
		this.size = size;
	}
	@Override
	public String toString() {
		return super.toString()+":"+size;
	}
}

class ItemB extends Item {
	String color;
	
	public ItemB(String name, Integer pid, String color) {
		super(name, pid);
		this.color = color;
	}
	@Override
	public String toString() {
		return super.toString()+":"+color;
	}
}

public class ExTest {
	public static void main(String[] args) {
		System.out.println("============ARRAY LIST==============");
		ArrayList<Item> list = new ArrayList<>();
		list.add(new ItemA("Name",100,"XXL"));
		list.add(new ItemB("Name",100,"RED"));
		
		for(Item item : list){
			System.out.println(item);
		}
		System.out.println("============HASH STRING=============");
		HashMap<String, Item>map =new HashMap<>();
		map.put("itemA", new ItemA("NAME",100,"XXL"));
		map.put("itemB", new ItemB("NAME",100,"RED"));
		
		map.get("itemB");
		System.out.println(map.get("itemB"));
		
		System.out.println("============HASH INTEGER============");
		HashMap<Integer, Item> map1 =new HashMap<>();
		map1.put(1, new ItemA("NAME",100,"XXL"));
		map1.put(2, new ItemB("NAME",100,"RED"));
		
		map1.get("itemB");
		System.out.println(map1.get(1));
	}
}
