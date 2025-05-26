package com.ruby.java.ch11;

//함수에 throw절을 추가하는 경우 - 함수내에서 throw할 수 있고 호출하는 코드에서 예외를 반드시 처리해야 한다
import java.io.*;

public class Test04 {

	public static void main(String[]args) {
		FileInputStream fi = null;
		try {
			fi = new FileInputStream("a.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int c = 0;
		try {
			c = fi.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println((char)c);
	}
}
