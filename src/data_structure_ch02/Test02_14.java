package data_structure_ch02;

/*
 * 2장 실습과제4 - 스트링 배열 정렬
 * 정렬된 배열에 insert하면 중간에 끼워 넣으면 큰 값들은 이동해야 하고 크기를 1 증가 처리가 필요 
 */
public class Test02_14 {
	public static void main(String[] args) {
		String []data = {"apple","grape","persimmon", "pear","blueberry", "strawberry", "melon", "oriental melon"};

		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);
		String[] newData = insertString(data, "banana"); //바나나 끼워넣기
		showData("삽입후 크기가 증가된 정렬 배열", newData);
		//Arrays.sort(data);
		//Arrays.sort(data,(a,b)->a.compareTo(b)); 람다식
		
	}

	static void showData(String title, String arr[]) {//확장된 for 문으로 출력 
		System.out.println("<"+title+">");
		for(String all : arr) {
			System.out.println(all+" ");
		}
		System.out.println();
	}
	
	//배열 출력함수 
	//스트링의 맞교환 함수로 sortData()에서 호출됨
	static void swap(String arr[], int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	//올림차순으로 정렬 - for 문을 사용하여 직접 구현한다
	static void sortData(String[]arr) {
		int n = arr.length;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-i-1;j++) {
				if(arr[j].compareTo(arr[j+1])>0) {
					swap(arr,j,j+1);
				}
			}
		}
	}
	
	//배열의 사이즈를 1개 증가시킨후 insert되는 스트링 보다 큰 값들은 우측으로 이동,
	//사이즈가 증가된 스트링 배열을 리턴
	static String[] insertString(String[] arr, String newStr){
		int n = arr.length;
		String[] newArr = new String[n+1];
		
		int i=0;
		while(i<n&&arr[i].compareTo(newStr)< 0) {
			newArr[i]=arr[i];
			i++;
		}
		newArr[i] = newStr;
		
		for(int j=i; j< n; j++){
			newArr[j+1]=arr[j];
		}
		return newArr;
			
		}	
		
	}


