package com.ruby.java.ch12;

import java.io.FileInputStream;
import java.io.FileReader;

public class Test01_1 {

	public static void main(String[] args) {
		try(FileInputStream fi = new FileInputStream("tt.txt")){
			int c = 0;
			while((c = fi.read()) != -1) {
				System.out.println(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("-".repeat(10));
		try(FileReader fr = new FileReader("tt.txt")){
			int c = 0;
			while((c= fr.read())!= -1) {
				System.out.println(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
}
