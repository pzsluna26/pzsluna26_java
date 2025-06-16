package data_structure_ex;

import java.util.Stack;

// 포인트 클래스: 정렬 범위(왼쪽, 오른쪽 인덱스)를 저장
class Point3 {
	private int ix;
	private int iy;

	public Point3(int x, int y) {
		ix = x;
		iy = y;
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}
}

public class Test06_1 {

	// 두 값을 교환하는 함수 (Swap)
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// 퀵 정렬 (비재귀 버전)
	static void quickSort(int[] a, int left, int right) {
		Stack<Point3> st = new Stack<>(); // 정렬할 구간을 저장하는 스택

		st.push(new Point3(left, right)); // 처음 전체 구간을 푸시

		while (!st.isEmpty()) {
			Point3 pt = st.pop();         // 스택에서 구간을 꺼냄
			int pl = pt.getX();           // 왼쪽 인덱스
			int pr = pt.getY();           // 오른쪽 인덱스
			int pivot = a[(pl + pr) / 2]; // 가운데 요소를 피벗으로 설정

			// 정렬 수행
			while (pl <= pr) {
				while (a[pl] < pivot) pl++;
				while (a[pr] > pivot) pr--;
				if (pl <= pr) swap(a, pl++, pr--);
			}

			// 왼쪽 구간이 남아있으면 스택에 넣기
			if (pt.getX() < pr) st.push(new Point3(pt.getX(), pr));
			// 오른쪽 구간이 남아있으면 스택에 넣기
			if (pl < pt.getY()) st.push(new Point3(pl, pt.getY()));
		}
	}

	public static void main(String[] args) {
		int nx = 10;
		int[] x = new int[10];

		// 0~19 사이의 랜덤 숫자 10개 생성
		for (int ix = 0; ix < 10; ix++) {
			double d = Math.random();
			x[ix] = (int) (d * 20);
		}

		// 정렬 전 출력
		System.out.print("정렬 전: ");
		for (int i = 0; i < nx; i++)
			System.out.print(x[i] + " ");
		System.out.println();

		// 퀵 정렬 실행
		quickSort(x, 0, nx - 1);

		// 정렬 후 출력
		System.out.println("정렬 후 (오름차순):");
		for (int i = 0; i < nx; i++)
			System.out.print(x[i] + " ");
	}
}
