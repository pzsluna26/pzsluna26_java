package data_structure_ch03;

import java.util.Arrays;

class Student{
	String sid;
	String sname;
	String dept;
	public Student(String sid, String sname, String dept) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.dept = dept;
	}
	
	public int compareTo(Student other) {
        return this.sid.compareTo(other.sid); // 학번 기준 오름차순
    }
	@Override
	public String toString() {
		return sid + "," + sname + "," + dept;
	}
}

public class Assignment02 {
	 public static void show(Student[] arr) {
	        for (Student s : arr) {
	            System.out.println(s);
	        }
	    }
	
	 public static void main(String[] args) {
		Student[] students = {
			    new Student("S001", "영희", "Math"),
			    new Student("S003", "민수", "Computer"),
			    new Student("S002", "철수", "Physics"),
			    new Student("S005", "지영", "Biology"),
			    new Student("S004", "준호", "Chemistry")
			};
	System.out.println("=== 정렬 전 학생 목록 ===");
	show(students);
	
	Arrays.sort(students);
	Student[] targets = {
		    new Student("S002", "철수", "Physics"),
		    new Student("S006", "홍길동", "Law"),
		    new Student("S004", "준호", "Chemistry")
		};
	
	System.out.println("=== 이진 탐색 결과 ===");
	for(Student t : students) {
		System.out.println(t);		
	}
	
	}
	
	}
/*

??????? Student 클래스는 Comparable을 구현하지 않음

???정렬과 이진 탐색에 사용할 Comparator<Student> 객체를 람다식 또는 익명 클래스로 구현할 것

기준: sid 오름차순



다음 탐색 대상 배열을 정의하고, 확장형 for문으로 각 항목에 대해 Arrays.binarySearch(배열, key, comparator)로 탐색한다.



탐색 결과는 다음과 같이 출력한다:

"찾은 학생: S002, 철수, Physics"

"학번 S006인 학생은 존재하지 않습니다."

=== 정렬 전 학생 목록 ===
S001, 영희, Math
S003, 민수, Computer
S002, 철수, Physics
S005, 지영, Biology
S004, 준호, Chemistry

=== 이진 탐색 결과 ===
찾은 학생: S002, 철수, Physics
학번 S006인 학생은 존재하지 않습니다.
찾은 학생: S004, 준호, Chemistry

 * 
 */
}
