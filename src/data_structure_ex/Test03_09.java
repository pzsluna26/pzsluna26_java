package data_structure_ex;

import java.util.Arrays;

// 객체 클래스 
class Student implements Comparable<Student> {
	String sid;
	String sname;
	String dept;

	// 생성자
	public Student(String sid, String sname, String dept) {
		this.sid = sid;
		this.sname = sname;
		this.dept = dept;
	}

	// 메서드 → sid 기준 오름차순 비교
	public int compareTo(Student other) {
		return this.sid.compareTo(other.sid);
	}

	// 메서드 → 출력 형식은 "S002, 철수, Physics"
	public String toString() {
		return sid + ", " + sname + ", " + dept;
	}
}

public class Test03_09 {

	// show(Student[] arr) 메서드를 작성하여 확장형 for문으로 배열 내용을 출력한다.
	// 출력 시 "=== 정렬 전 학생 목록 ==="을 먼저 출력한다.
	static void show(String msg, Student[] arr) {
		System.out.println(msg);
		for (Student s : arr) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		// 메인 메서드에서 다음 학생 배열을 정의한다 (정렬 전 상태)
		Student[] students = { new Student("S001", "영희", "Math"), new Student("S003", "민수", "Computer"),
				new Student("S002", "철수", "Physics"), new Student("S005", "지영", "Biology"),
				new Student("S004", "준호", "Chemistry") };

		show("=== 정렬 전 학생 목록 ===", students);
		System.out.println();

		// 위 배열을 **Arrays.sort()**로 정렬한 후,
		Arrays.sort(students);

		// 다음과 같은 탐색 대상 객체 배열을 정의하고 반복문으로 탐색한다
		// 배열을 확장형 for문으로 순회하면서 Arrays.binarySearch()를 통해 각 객체를 탐색하고 결과를 출력한다.
		// 출력 형식은 다음 중 하나로 한다:
		// "찾은 학생: S002, 철수, Physics"
		// "학번 S006인 학생은 존재하지 않습니다."
		Student[] targets = { new Student("S002", "철수", "Physics"), new Student("S006", "홍길동", "Law"),
				new Student("S004", "준호", "Chemistry") };

		System.out.println("=== 이진 탐색 결과 ===");
		for (Student t : targets) {
			int Index = Arrays.binarySearch(students, t);
			if (Index >= 0) {
				System.out.println("찾은 학생 : " + students[Index]);
			} else {
				System.out.println("학번" + t.sid + "인 학생은 존재하지 않습니다. ");

			}
		}
	}
}
