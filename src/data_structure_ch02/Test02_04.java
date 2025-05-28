
/*
 * 2장: 메소드 함수에 parameter 전달
 * 메소드에 배열 전달 실습: 교재 59 - 메소드의 매개변수로 배열 사용하기
 * function parameters를 작성할 수 있어야 한다 
 */

package data_structure_ch02;

import java.util.Random;

public class Test02_04 {
    static int top = 0; // 배열에 저장된 실제 데이터 개수
    static final int MAX_LENGTH = 20;

    public static void main(String[] args) {
        int[] data = new int[10];

        inputData(data);
        showData("소스데이터", data);
        int max = findMax(data);
        System.out.println("\nmax = " + max);
        boolean existValue = findValue(data, 3);
        System.out.println("찾는 값 = " + 3 + ", 존재여부 = " + existValue);
        reverse(data);
        showData("역순 데이터", data);
    }

    // 데이터 출력
    static void showData(String msg, int[] arr) {
    	System.out.println(msg+":[");
    	for(int i=0; i<top; i++) {
    		System.out.println(arr[i]);
    		if(i<top-1) {
    			System.out.println(", ");
    		}
    	}
    	System.out.println("]");
    }
    
    static void inputData(int[] arr) {
    	Random rnd = new Random();
    	for(int i=0; i<arr.length; i++) {
    		arr[i] = rnd.nextInt(20);
    	}
    	top = arr.length;
    }

    // 최대값 찾기
    static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // 특정 값 존재 여부 확인
    static boolean findValue(int[] arr, int value) {
        for (int i = 0; i < top; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    	
	//배열을 역순으로 변경
	static void reverse(int[] arr) {
		for(int i=0; i<top / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[top-1-i];
			arr[top -1 -i]= temp;
		}
	}
}
