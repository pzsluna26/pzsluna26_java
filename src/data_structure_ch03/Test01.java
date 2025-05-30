package data_structure_ch03;
import java.util.Arrays;
import java.util.Random;

/*숫자 30개 들은 배열 잇어.
// *o여기에 값을 할당할꺼야. 100이하의 난수
// *o배열을 출력할거야("정렬전배열[]", 현재배열)
// *o배열을 정렬을 할거야
// *o정렬한 후의 배열을 출력할거야
// **/ 

public class Test01 {
	
	//1. 랜덤한 값으로 배열 채우기
	static void inputData(int[]arr){
		Random rnd = new Random();
    	for(int i=0; i<arr.length; i++) {
    		arr[i] = rnd.nextInt(100);
    	}
	}

	
	//2. 배열 출력 함수
	static void showList(String str, int[] arr){
		System.out.println(str);
		for(int st : arr) {
			System.out.print(st+" ");			
		}
	}
	
	
	//3. 선형검색
	static boolean linearSearch(int arr[],int key){
		for (int i = 0; i < arr.length; i++) {
		    if (arr[i] == key) {
		        return true;
		    }
		}
		return false;
		}

	
	//4. 이진검색
	static boolean binarySearch(int[] arr, int key) {
	    int pl = 0;
	    int pr = arr.length - 1;

	    while (pl <= pr) {
	        int pc = (pl + pr) / 2;

	        if (key == arr[pc]) {
	            System.out.println("찾은 값의 인덱스 = " + pc);
	            return true; // 값을 찾았을 때
	        } else if (key > arr[pc]) {
	            pl = pc + 1;
	        } else {
	            pr = pc - 1;
	        }
	    }
	    return false; // 찾지 못했을 때
	}
	

		

	public static void main(String[] args) {
		int []data = new int[30];
		inputData(data);// 구현 반복 숙달 훈련 - 100 이하 난수를 생성

		showList("정렬 전 배열[]:: ", data);
		System.out.println();
		System.out.println("======================================================================================");
		Arrays.sort(data);
		showList("정렬 후 배열[]:: ", data);// 구현 반복 숙달 훈련
		System.out.println();
		System.out.println("======================================================================================");
		int key = new Random().nextInt(101);
		boolean resultIndex = linearSearch(data, key);//교재 99-100:실습 3-1 참조, 교재 102: 실습 3-2
		//Arrays 클래스에 linear search는 없기 때문에 구현해야 한다 
		System.out.println("linearSearch(13): key = " + key + ", result = " + resultIndex);
		System.out.println("======================================================================================");
		key = 39;
		// 교재 109~113
		resultIndex = binarySearch(data, key);//함수 구현이 필요
		System.out.println("binarySearch(19): key = " + key + ", result = " + resultIndex);
		
		key = new Random().nextInt(101);
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		
//		//정수면 api 써도됨
//		resultIndex = Arrays.binarySearch(data, key);
//		System.out.println("\nArrays.binarySearch(10): result = " + resultIndex);

	}
}
