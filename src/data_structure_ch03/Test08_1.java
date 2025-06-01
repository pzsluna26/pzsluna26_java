package data_structure_ch03;

import java.util.Arrays;
import java.util.Comparator;

class Fruit4 {
	String name;
	int price;
	String expire;

	public Fruit4(String name, int price, String expire) {
		this.name = name;
		this.price = price;
		this.expire = expire;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getExpire() {
		return expire;
	}

	@Override
	public String toString() {
		return "과일명: " + name + ", 가격: " + price + ", 유통기한: " + expire;
	}
}

// 이름 기준 정렬
class FruitName implements Comparator<Fruit4> {
	public int compare(Fruit4 f1, Fruit4 f2) {
		return f1.getName().compareTo(f2.getName());
	}
}

// 가격 기준 정렬
class FruitPrice implements Comparator<Fruit4> {
	public int compare(Fruit4 f1, Fruit4 f2) {
		return Integer.compare(f1.getPrice(), f2.getPrice());
	}
}

public class Test08_1 {

	private static void showData(String msg, Fruit4[] arr) {
		System.out.println(msg);
		for (Fruit4 f : arr) {
			System.out.println(f);
		}
	}

	private static void sortData(Fruit4[] arr, Comparator<Fruit4> comp) {
		Arrays.sort(arr, comp);
	}

	// 직접 구현한 이진탐색
	private static int binarySearch(Fruit4[] arr, Fruit4 key, Comparator<Fruit4> comp) {
		int pl = 0;
		int pr = arr.length - 1;
		while (pl <= pr) {
			int pc = (pl + pr) / 2;
			int temp = comp.compare(key, arr[pc]);

			if (temp == 0) return pc;
			else if (temp < 0) pr = pc - 1;
			else pl = pc + 1;
		}
		return -1;
	}

	public static void main(String[] args) {

		Fruit4[] arr = {
			new Fruit4("사과", 200, "2023-5-8"),
			new Fruit4("감", 500, "2023-6-8"),
			new Fruit4("대추", 200, "2023-7-8"),
			new Fruit4("복숭아", 50, "2023-5-18"),
			new Fruit4("수박", 880, "2023-5-28"),
			new Fruit4("산딸기", 10, "2023-9-8")
		};

		// 1. 정렬 전 출력
		System.out.println("정렬 전 객체 배열:");
		showData("초기 데이터", arr);

		// 2. 이름 기준 익명 클래스 정렬
		Arrays.sort(arr, new Comparator<Fruit4>() {
			public int compare(Fruit4 f1, Fruit4 f2) {
				return f1.name.compareTo(f2.name);
			}
		});
		showData("\n익명 클래스(이름 기준) 정렬 후", arr);

		// 3. 람다식 정렬 (이름 기준)
		Arrays.sort(arr, (f1, f2) -> f1.name.compareTo(f2.name));
		showData("\n람다식(이름 기준) 정렬 후", arr);

		// 4. 이름 기준 정렬 클래스 사용
		FruitName nameComparator = new FruitName();
		Arrays.sort(arr, nameComparator);
		showData("\nFruitName comparator 정렬 후", arr);

		// 5. 가격 기준 정렬 클래스 사용
		FruitPrice priceComparator = new FruitPrice();
		sortData(arr, priceComparator);
		showData("\nFruitPrice comparator 정렬 후", arr);

		// 6. 유통기한 기준 람다식 정렬
		Comparator<Fruit4> expireComparator = (a, b) -> a.getExpire().compareTo(b.getExpire());
		Arrays.sort(arr, expireComparator);
		showData("\n람다식(유통기한 기준) 정렬 후", arr);

		// 7. 람다식 가격 정렬
		Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice());
		showData("\n람다식(가격 기준) 정렬 후", arr);

		// 8. 이름 기준 익명 클래스 comparator 사용
		Arrays.sort(arr, new Comparator<Fruit4>() {
			public int compare(Fruit4 a1, Fruit4 a2) {
				return a1.getName().compareTo(a2.getName());
			}
		});
		showData("\n익명 객체(이름 기준) 정렬 후", arr);

		// 9. Arrays.binarySearch() 이름 기준
		Fruit4 newFruit4 = new Fruit4("수박", 880, "2023-5-18");
		int resultIndex = Arrays.binarySearch(arr, newFruit4, nameComparator);
		System.out.println("\nArrays.binarySearch(이름 기준) 결과: " + resultIndex);

		// 10. 직접 구현한 이진 탐색 (가격 기준)
		sortData(arr, priceComparator); // 정렬 먼저 해야 함
		resultIndex = binarySearch(arr, newFruit4, priceComparator);
		System.out.println("\nbinarySearch(가격 기준) 결과: " + resultIndex);
		showData("\n최종 가격 기준 정렬된 배열:", arr);
	}
}
