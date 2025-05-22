package com.ruby.java.ch10;

import java.util.HashSet;
import java.util.Iterator;

class User{
	String ssn;
	String name;
	
	User(String ssn, String name){
		this.ssn=ssn;
		this.name=name;
	}
	@Override
	public String toString() {
		return ssn + ":" + name;
	}
}

public class Test11 {

	public static void main(String[] args) {
		User u1 = new User("123","김푸름");
		User u2 = new User("123","김푸름");
		
		HashSet<User> users = new HashSet<User>();
		
		users.add(u1);
		users.add(u2);

		Iterator<User> iter = users.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
	}
}
