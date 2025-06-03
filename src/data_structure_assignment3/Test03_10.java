package data_structure_assignment3;

import java.util.Arrays;
import java.util.Comparator;

class Student {

	// 클래스 객체
	String sid;
	String sname;
	String dept;

	// 생성자
	public Student(String sid, String sname, String dept) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.dept = dept;
	}

	// toString() 메서드: "S002, 철수, Physics" 형식 반환
	public String toString() {
		return sid + ", " + sname + ", " + dept;
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
		Student[] students = { new Student("S001", "영희", "Math"), new Student("S003", "민수", "Computer"),
				new Student("S002", "철수", "Physics"), new Student("S005", "지영", "Biology"),
				new Student("S004", "준호", "Chemistry") };

		show("=== 정렬 전 학생 목록 ===", students);
		System.out.println();

		// 정렬과 이진 탐색에 사용할 Comparator<Student> 객체를 람다식 또는 익명 클래스로 구현할 것
		// 기준: sid 오름차순
		Comparator<Student> sidComp = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.sid.compareTo(s2.sid);
			}
		};

		// 위 배열을 Arrays.sort(배열, comparator)로 정렬한다.
		Arrays.sort(students, sidComp);

		// 다음 탐색 대상 배열을 정의하고,
		// 확장형 for문으로 각 항목에 대해
		// Arrays.binarySearch(배열, key, comparator)로 탐색한다.
		Student[] targets = { new Student("S002", "철수", "Physics"), new Student("S006", "홍길동", "Law"),
				new Student("S004", "준호", "Chemistry") };

		System.out.println("=== 이진 탐색 결과 ===");

		for (Student t : targets) {
			int index = Arrays.binarySearch(students, t, sidComp);
			if (index >= 0) {
				System.out.println("찾은 학생: " + students[index]);
			} else {
				System.out.println("학번 " + t.sid + "인 학생은 존재하지 않습니다. ");
			}
		}
	}
}
