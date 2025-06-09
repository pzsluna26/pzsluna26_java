package data_structure_ex;

import java.util.Arrays;
import java.util.Comparator;

class Student1 {

	// 클래스 객체
	private String sid;
	private String sname;
	private String dept;

	// 생성자: 객체의 필드값을 초기화 하는 것
	public Student1(String sid, String sname, String dept) {
		this.sid = sid;
		this.sname = sname;
		this.dept = dept;
	}

	// toString() 메서드: "S002, 철수, Physics" 형식 반환
	public String toString() {
		return getSid() + ", " + sname + ", " + dept;
	}
	public String getSid() {
		return sid;
	}
}

public class Test03_10 {

	// show(Student[] arr) 메서드를 작성하여 확장형 for문으로 배열 내용을 출력한다.
	// 출력 시 "=== 정렬 전 학생 목록 ==="을 먼저 출력한다.
	static void show(String msg, Student[] arr) {
		System.out.println(msg);
		for (Student s : arr) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {

		// 메인 메서드에서는 다음 학생 배열을 선언한다
		Student[] students = { 
				new Student("S001", "영희", "Math"), 
				new Student("S003", "민수", "Computer"),
				new Student("S002", "철수", "Physics"), 
				new Student("S005", "지영", "Biology"),
				new Student("S004", "준호", "Chemistry") };

		show("=== 정렬 전 학생 목록 ===", students);
		System.out.println();

		// 정렬과 이진 탐색에 사용할 Comparator<Student> 객체를 익명클래스 말고 '람다식'으로 만들기 (스트림때문에)
		// 기준: sid 오름차순
		/* 익명클래스 
		Comparator<Student> sidComp = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.sid.compareTo(s2.sid);
			}
		};*/
		
		
		// 람다함수는 리턴이 없어도 리턴된다.
		Comparator<Student> sidComp = (s1, s2) -> s1.getSid().compareTo(s2.getSid());


		// 위 배열을 Arrays.sort(배열, comparator)로 정렬한다.
		Arrays.sort(students, sidComp);

		// 다음 탐색 대상 배열을 정의하고,
		// 확장형 for문으로 각 항목에 대해
		// Arrays.binarySearch(배열, key, comparator)로 탐색한다.
		Student[] targets = { new Student("S002", "철수", "Physics"), new Student("S006", "홍길동", "Law"),
				new Student("S004", "준호", "Chemistry") };

		System.out.println("=== 이진 탐색 결과 ===");

		for (Student t : targets) {
			// (a,b,c를 넣으면)인덱스로 돌려줌
			int index = Arrays.binarySearch(students, t, sidComp);
			// 찾았으면
			if (index >= 0) {
				System.out.println("찾은 학생: " + students[index]);
			// 못찾았으면
			} else {
				System.out.println("학번 " + t.getSid() + "인 학생은 존재하지 않습니다. ");
			}
		}
	}
}
