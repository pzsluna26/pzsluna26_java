package data_structure_ex;

 /*
 * 6장 구현 실습과제2
 */

class PhyscData implements Comparable<PhyscData>{
    String name;              // 이름
    int    height;            // 키
    double vision;            // 시력
	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	// 키를 기준으로 비교
	public int compareTo(PhyscData p) {
		return this.height - p.height;
	}
}

public class Test06_2 {
	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(PhyscData[] a, int pl1, int pr1, int pl2, int pr2 ) {
		int size = pr1 - pl1 +1; //병합될 배열 사이즈 
		PhyscData[] temp = new PhyscData[size]; //임시배열 
		
		int i = pl1;
		int j = pl2;
		int k = 0;
		
		//두 배열을 비교하면서 작은 것을 temp에 넣기
		while(i <= pr1 && j <= pr2) {
			if(a[i].compareTo(a[j]) <= 0)
				temp[k++] = a[i++];
			else
				temp[k++] = a[j++];
		}
		// 남은 요소 복사 (왼쪽 구간)
        while (i <= pr1)
            temp[k++] = a[i++];

        // 남은 요소 복사 (오른쪽 구간)
        while (j <= pr2)
            temp[k++] = a[j++];

        // temp 배열을 원래 배열에 복사
        for (int m = 0; m < size; m++)
            a[pl1 + m] = temp[m];
  
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(PhyscData[] a, int left, int right) {
		int mid = (left+right)/2;
		if (left == right) return;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, mid, mid+1, right);
		return;
	}

	public static void main(String[] args) {
		PhyscData[] x = {
		         new PhyscData("강민하", 162, 0.3),
		         new PhyscData("김찬우", 173, 0.7),
		         new PhyscData("박준서", 171, 2.0),
		         new PhyscData("유서범", 171, 1.5),
		         new PhyscData("이수연", 168, 0.4),
		         new PhyscData("장경오", 171, 1.2),
		         new PhyscData("황지안", 169, 0.8),
		     };
		int nx = x.length;

		   MergeSort(x, 0, nx - 1); // 배열 x를 퀵정렬
			System.out.println("오름차순으로 정렬했습니다.");
		     System.out.println("■ 신체검사 리스트 ■");
		     System.out.println(" 이름     키  시력");
		     System.out.println("------------------");
		     for (int i = 0; i < x.length; i++)
		         System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
	}
}
