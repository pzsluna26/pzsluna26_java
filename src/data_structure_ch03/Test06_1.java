package data_structure_ch03;
import java.util.Arrays;
//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현


class PhyscData2 implements Comparable<PhyscData2>{
	String name;
	int height;
	double vision;

	@Override//object에 있는 tostring 상속
	public String toString() {//[홍길동,162,0.3] 형태로 리턴한다 
		
	}
	@Override//comparable 인터페이스에 있는 compareTo상속
	public int compareTo(PhyscData2 p) {
		// name 비교 버젼
		// height 비교 버젼
	}

}


//public class Test06_1 {
//	public static void main(String[] args) {
//		
//		PhyscData2[] data = {
//				new PhyscData2("홍길동", 162, 0.3),
//				new PhyscData2("나동", 164, 1.3),
//				new PhyscData2("최길", 152, 0.7),
//				new PhyscData2("홍길동", 162, 0.3),
//				new PhyscData2("박동", 182, 0.6),
//				new PhyscData2("박동", 167, 0.2),
//				new PhyscData2("길동", 167, 0.5),
//		};
//		if (data[0].compareTo(data[1] > 0) {
//		  //객체(수신객체) //메소드	
//		}
//		System.out.println(data[0].toString());
//		showData("정렬전", data);
//		sortData(data);//6장 06-4 단순 삽입 정렬 InsertionSort() 함수로 구현
//		showData("정렬후", data);
//		reverse(data);
//		showData("역순 재배치후", data);
//		Arrays.sort(data);//사용된다 그 이유는? 이해가 되어야 한다 - compareTo() 구현을 변경하여 실행결과를 확인
//		showData("Arrays.sort() 정렬후", data);
//		
//		PhyscData2 key = new PhyscData2("길동", 167, 0.5);
//		int resultIndex = linearSearch(data, key);//compareTo()를 사용하여 구현
//		System.out.println("\nlinearSearch(<길동,167,0.5>): result index = " + resultIndex);
//		
//		key = new PhyscData2("박동", 167, 0.6);
//		/*
//		 * 교재 109~113
//		 */
//		resultIndex = binarySearch(data, key);//compareTo()를 사용하여 구현
//		System.out.println("\nbinarySearch(<박동,167,0.6>): result index = " + resultIndex);
//		key = new PhyscData2("나동", 164, 0.6);
//		/*
//		 * 교재 115 Arrays.binarySearch에 의한 검색
//		 */
//		resultIndex = Arrays.binarySearch(data, key);//compareTo()를 사용되는지를 확인-이해할 수 있어야 한다 
//		System.out.println("\nArrays.binarySearch(<나동,164,0.6>): result index = " + resultIndex);
//	}
//}
