package data_structure_ex;

import java.util.Arrays;
import java.util.Comparator;

// 객체 클래스 
class PhyscData2 implements Comparable<PhyscData2> {
	String name;
	int height;
	double vision;

	// 생성자
	public PhyscData2(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	// 기본 정렬: 이름 기준 
	@Override
	public int compareTo(PhyscData2 other) {
		return this.name.compareTo(other.name);
	}

}


public class Test02_14_1 {

	public static void main(String[] args) {
		PhyscData2[] data = { 
				new PhyscData2("홍길동", 162, 0.3), 
				new PhyscData2("홍동", 164, 1.3),
				new PhyscData2("홍길", 152, 0.7), 
				new PhyscData2("김홍길동", 172, 0.3), 
				new PhyscData2("이길동", 182, 0.6),
				new PhyscData2("박길동", 167, 0.2), 
				new PhyscData2("최길동", 169, 0.5), 
				};

		// 정렬 전 출력
		showData("<정렬전>", data);
		System.out.println("--------------------------------");

		// sortData()를 이용해 이름 기준 정렬 후 출력
		sortData(data);
		showData("<정렬후>", data);
		System.out.println("--------------------------------");

		// Arrays.sort()를 이용해 이름 기준 정렬 후 출력 
		Arrays.sort(data);
		showData("<Arrays.sort() 실행후>", data);
		

		
		// 이진 검색 후 출력 
		int resultIndex = binarySearch(data, "이길동");
		if (resultIndex >= 0)
			System.out.println("*이길동이 존재하면 인덱스 = " + resultIndex);
		else
			System.out.println("이길동이 존재하지 않는다");
		System.out.println("--------------------------------");

		// 새 객체 삽입 후 출력 
		PhyscData2[] newData = insertObject(data, new PhyscData2("소주다", 179, 1.5));
		showData("<새 객체 삽입후>", newData);
	}

	
	
	// showData
	static void showData(String msg, PhyscData2[] arr) {
		System.out.println(msg);
		for (PhyscData2 pd : arr) {
			System.out.printf("%-8s%3d%5.1f\n", pd.name, pd.height, pd.vision);
		}
		System.out.println();
	}

	// sortData
	static void sortData(PhyscData2[] arr) {
		Arrays.sort(arr);
	}
 
	// binarySearch
	static int binarySearch(PhyscData2[] arr, String name) {
		int pl = 0;
		int pr = arr.length - 1;

		while (pl <= pr) {
			int pc = (pl + pr) / 2;
			int temp = arr[pc].name.compareTo(name);
			if (temp == 0)
				return pc;
			else if (temp < 0)
				pl = pc + 1;
			else
				pr = pc - 1;
		}
		return -1;
	}

	/* insertObject 정렬된 배열에 삽입
		주어진 정렬된 배열(arr)에 newObj를 삽입하되,
		정렬순서를 유지한 채로 새 배열(newArr)을 만들어 리턴한다.*/
	static PhyscData2[] insertObject(PhyscData2 arr[], PhyscData2 newObj) {
		int n = arr.length;
		PhyscData2[] newArr = new PhyscData2[n+1];
		
		int i = 0;
		while(i<n && arr[i].compareTo(newObj) < 0) {
			newArr[i] = arr[i];
			i++;
		}
		newArr[i] = newObj;
		for(int j=i; j<n; j++) {
			newArr[j+1]= arr[j];
		}
		return newArr;
	}

}
