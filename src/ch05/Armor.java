package ch05;

public class Armor {
	// 객체지향 - 필드
	private String name;
	private int height;
	private int weight;
	private String color;
	private boolean isFly;
	
	public void setName() {
		String value = "mark6";
		name = value;
		System.out.println("이름은: " + name);
	}
	
	public static void main(String[] args) {
	Armor bird = new Armor();  // 로봇 객체 만들기
    bird.setName();         

	}
	}
	
	/* 메인에서 메서드호출을 하려면, 
	 * 클래스 메서드선언에서 명령문(출력명령) 까지 만들어야 호출됨! */

