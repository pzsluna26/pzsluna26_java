package data_structure_ch02;
/*
 * 2장 - 정수 배열 정렬
 */

import java.util.Arrays;
//교재 67 - 실습 2-5
//2번 실습
import java.util.Random;
public class Test02_05 {
	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data); //난수를 10 ~ 60 사이에 생성 => [50]+10
		showData("난수 입력", data);
		/*
		sortData(data);
		showData("정렬후", data);
		*/
		reverse(data);//역순으로 재배치 - 정렬 아님 
		showData("역순 재배치", data);
		
		
		reverseSort(data);//역순으로 재배치 - 정렬 아님 
		showData("역순 정렬후", data);
		
		Arrays.sort(data);; // API 사용
		sortData(data);
		
		
		int realData[] = {5, 15, 99};
		for (int newData: realData) {
			int []result = insertData(data, newData);//입력 실수보다 큰 숫자를 우측으로 이동
			System.out.print("\n\n"+ newData+ " : ");
			showData("실수 삽입후", result);
		}
	}
	
	
	//배열 출력
	static void showData(String msg, int[]data) {
		for(int i =0; i < data.length; i++) {
			if(i != data.length-1) {		
			}
		}	
	}
	//난수 입력(10~60) => [50]+10
	static void inputData(int []data) {

	}
	
	//swap함수
	static void swap(int[]arr, int ind1, int ind2) {//교재 67페이지

	}
	
	//오름차순 정렬
	static void sortData(int []arr) {
		//버블 정렬: for루프 2번 돌려서, 
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] > arr[j])
					swap(arr,i,j);
			}
		}
	}
	static void reverse(int[] a) {//교재 67페이지

	}
	static void reverseSort(int []arr) {

	}

	/*
	 * 난이도가 매우 높은 알고리즘 구현
	 * 정렬된 기존 배열에 임의 값을 추가하는 알고리즘 > 새 배열의 크기는 기존 배열보다 +1로 만들고 기존 배열을 copy할 때
	 * 삽입된 값이 중간에 들어가는 알고리즘 구현하기
	 * O(n) 알고리즘으로 구현 
	 */
	static int[] insertData(int []data, int value) {//insert되는 실수 값이 insert될 위치를 찾아 보다 큰 값은 우측으로 이동
		int newData[] = new int[data.length+1];
		//추가하는 알고리즘 작성 연습

		
	}


}





//package data_structure_ch02;
//
//import java.util.Arrays;
//import java.util.Random;
//
//public class Test02_05 {
//    public static void main(String[] args) {
//        int[] data = new int[10];
//        inputData(data); // 난수 10개 생성 (10 ~ 60 사이)
//        showData("난수 입력", data);
//
//        reverse(data);
//        showData("역순 재배치", data);
//
//        reverseSort(data);
//        showData("역순 정렬후", data);
//
//        Arrays.sort(data); // 오름차순 정렬
//        sortData(data);    // 버블 정렬 사용 (연습용)
//        showData("정렬 후", data);
//
//        int realData[] = {5, 15, 99};
//        for (int newData : realData) {
//            int[] result = insertData(data, newData);
//            System.out.print("\n\n" + newData + " : ");
//            showData("실수 삽입후", result);
//        }
//    }
//
//    // 배열 출력
//    static void showData(String msg, int[] data) {
//        System.out.print(msg + ": [");
//        for (int i = 0; i < data.length; i++) {
//            System.out.print(data[i]);
//            if (i != data.length - 1)
//                System.out.print(", ");
//        }
//        System.out.println("]");
//    }
//
//    // 난수 입력 (10 ~ 60)
//    static void inputData(int[] data) {
//        Random rnd = new Random();
//        for (int i = 0; i < data.length; i++) {
//            data[i] = rnd.nextInt(51) + 10; // 0~50 + 10 => 10~60
//        }
//    }
//
//    // swap 함수
//    static void swap(int[] arr, int ind1, int ind2) {
//        int temp = arr[ind1];
//        arr[ind1] = arr[ind2];
//        arr[ind2] = temp;
//    }
//
//    // 오름차순 정렬 (버블 정렬)
//    static void sortData(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] > arr[j])
//                    swap(arr, i, j);
//            }
//        }
//    }
//
//    // 배열 역순으로 뒤집기
//    static void reverse(int[] a) {
//        for (int i = 0; i < a.length / 2; i++) {
//            swap(a, i, a.length - i - 1);
//        }
//    }
//
//    // 내림차순 정렬
//    static void reverseSort(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] < arr[j])
//                    swap(arr, i, j);
//            }
//        }
//    }
//
//    // 정렬된 배열에 새로운 값을 삽입 (O(n))
//    static int[] insertData(int[] data, int value) {
//        int[] newData = new int[data.length + 1];
//        int i = 0;
//
//        // 삽입 위치 찾기
//        while (i < data.length && data[i] < value) {
//            newData[i] = data[i];
//            i++;
//        }
//
//        // 삽입
//        newData[i] = value;
//
//        // 나머지 복사
//        for (int j = i; j < data.length; j++) {
//            newData[j + 1] = data[j];
//        }
//
//        return newData;
//    }
//}
