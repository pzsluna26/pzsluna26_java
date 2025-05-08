package edu.자바_2장_데이터활용;

public class Test2 {
	//main  입력후 ctrl + space
	public static void main(String[] args) {
		//데이터타입: 	int,short,long...
		int depositAmount;
		depositAmount = 50000;
		//sysout 입력후 ctrl + space
		System.out.println(depositAmount);
		
		
		//데이터타입
		//1.boolean
		boolean isMarried = false;
		isMarried = true;
		System.out.println("ismarried="+ isMarried);

		//2.char 문자타입
		char ch = 'A'; //아스키코드에서 A=65,a=97
		int num = ch;
		num = num +1;//66
		ch =(char)num; //4바이트를 2바이트에 저장할려고 하니 정보 손실 발생때문에 오류생김

		System.out.print("\n\tnum = " + num);
		
		//3.string 참조타입
		String greating = "good morning";
		
		//4.byte,int,short,long 정수타입
		
		
	}

}
