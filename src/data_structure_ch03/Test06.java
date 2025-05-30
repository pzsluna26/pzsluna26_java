package data_structure_ch03;
import java.util.Arrays;

public class Test06 {
	
	// 1. 문자열 배열 출력
	static void showData(String str,data[]) {
		System.out.println(str + "배열: ");
		for(String item : data) {
			System.out.println(item);
		}
	}

 
	// 2. 선택 정렬 (오름차순) - String 비교
	static void sortData(String data[]) {
		for(int i=0; i<data.length; i++) {
			int minIndex = i;
			for(int j=i+1; j<data.length; j++) {
				if(data[j].compareTo(data[minIndex]) < 0) {
					minIndex =j;
				}
			}
			//교환
			String temp = data[i];
			data[i] = data[minIndex];
			data[minIndex]=temp;
		}
	}
	
  
	// 3. 선형 검색 (linear search)
	static int linearSearch(String data[], String key) {
		for(int i=0; i<data.length; i++) {
			if(data[i].equals(key)) {
				return i;	
			}
		}
		return -1; //왜 -1인가!?
	}

	
//    static int binarySearch(String[] data, String key) {
//        int pl = 0;
//        int pr = data.length - 1;
//
//        while (pl <= pr) {
//            int pc = (pl + pr) / 2;
//            int cmp = key.compareTo(data[pc]);
//
//            if (cmp == 0) return pc;        // key와 일치
//            else if (cmp < 0) pr = pc - 1;  // 왼쪽 영역
//            else pl = pc + 1;               // 오른쪽 영역
//        }
//        return -1; // 못 찾음
//    }
	 // 4. 이진 검색 (binary search) - 배열은 정렬되어 있어야 함
	static int binarySearch(String data[], String key) {
		int pl = 0;
		int pr = data.length -1;
		
		while(pl <= pr) {
			int pc = (pl+pr)/2;
			int cmp = key.compareTo(data[pc]);
			
		}
	}
	


    public static void main(String[] args) {
        String[] data = {"사과", "포도", "복숭아", "감", "산딸기", "블루베리", "대추", "수박", "참외"};
        showData("정렬전", data);

        sortData(data); // 직접 구현한 선택 정렬
        showData("정렬후", data);

        String key = "포도";
        int resultIndex = linearSearch(data, key);
        System.out.println("\nlinearSearch(포도): key = " + key + ", result 색인 = " + resultIndex);

        key = "배";
        resultIndex = binarySearch(data, key);
        System.out.println("\nbinarySearch(배): key = " + key + ", result = " + resultIndex);

        key = "산딸기";
        resultIndex = Arrays.binarySearch(data, key); // 자바 표준 이진 검색
        System.out.println("\nArrays.binarySearch(산딸기): key = " + key + ", result = " + resultIndex);
    }
}

