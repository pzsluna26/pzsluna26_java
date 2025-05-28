package data_structure_ch02;

/*
 * 2장 실습과제4 - 스트링 배열 정렬
 * 정렬된 배열에 insert하면 중간에 끼워 넣으면 큰 값들은 이동해야 하고 크기를 1 증가 처리가 필요 
 */
public class Test02_14 {
	public static void main(String[] args) {
		String []data = {"apple","grape","persimmon", "pear","blueberry", "strawberry", "melon", "oriental melon"};

		showData("정렬전", data);
		sortData();
		showData("정렬후", data);
		String[] newData = insertString(data, "banana"); //바나나 끼워넣기
		showData("삽입후 크기가 증가된 정렬 배열", newData);
		//Arrays.sort(data);
		//Arrays.sort(data,(a,b)->a.compareTo(b)); 람다식
		
	}

	static void showData(String title, String data[]) {//확장된 for 문으로 출력 
		for(String all : String data[]) {
			System.out.println(all);
		}
	}

	static void swap() {
	//스트링의 맞교환 함수로 sortData()에서 호출됨
		
	}
	static void sortData() {//올림차순으로 정렬 - for 문을 사용하여 직접 구현한다 

	}
	static void insertString(String[] data, String string){
		for(String i=0; i< data.length; i++) {
			
		}
	//배열의 사이즈를 1개 증가시킨후 insert되는 스트링 보다 큰 값들은 우측으로 이동,
	//사이즈가 증가된 스트링 배열을 리턴
		
	}
}





//package data_structure_ch02;
//
//public class Test02_14 {
//    public static void main(String[] args) {
//        String[] data = {
//            "apple", "grape", "persimmon", "pear",
//            "blueberry", "strawberry", "melon", "oriental melon"
//        };
//
//        showData("정렬 전", data);
//        sortData(data);
//        showData("정렬 후", data);
//
//        String[] newData = insertString(data, "banana");
//        showData("삽입 후 크기가 증가된 정렬 배열", newData);
//    }
//
//    // 문자열 배열 출력 (for-each 문 사용)
//    static void showData(String title, String[] arr) {
//        System.out.print(title + ": ");
