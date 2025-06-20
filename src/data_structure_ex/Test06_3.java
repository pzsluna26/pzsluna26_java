package data_structure_ex;

class Polynomial3 implements Comparable<Polynomial3> {
	double coef; // 계수
	int exp; // 지수

	Polynomial3() {
	}

	Polynomial3(double coef, int exp) {
		this.coef = coef;
		this.exp = exp;
	}

	@Override
	public int compareTo(Polynomial3 o) {
		return Integer.compare(o.exp, this.exp); // 내림차순 정렬
	}
}

public class Test06_3 {

	static void merge(Polynomial3[] a, int lefta, int righta, int leftb, int rightb) {
		Polynomial3[] temp = new Polynomial3[30];
		int i = lefta;
		int j = leftb;
		int k = 0;

		// 1. 두 배열을 비교
		while (i <= righta && j <= rightb) {
	        if (k >= temp.length) break; // temp 배열 초과 방지
	        if (a[i].exp >= a[j].exp)
	            temp[k++] = a[i++];
	        else
	            temp[k++] = a[j++];
	    }

		// 2. 남은 배열을 처리
		while (i <= righta && k < temp.length) {
	        temp[k++] = a[i++];
	    }
	    while (j <= rightb && k < temp.length) {
	        temp[k++] = a[j++];
	    }
//		while (i <= righta) {
//			temp[k++] = a[i++];
//		}
//		while (j <= rightb) {
//			temp[k++] = a[j++];
//		}

	    // 3. temp -> a로 복사
	    for (int m = 0; m < k; m++) {
	        if (lefta + m >= a.length) break; // ⛔ a 배열 초과 방지
	        a[lefta + m] = temp[m];
	    }
	}
	
	static void MergeSort(Polynomial3[] a, int left, int right) {
		if (left >= right)
			return;
		int mid = (left + right) / 2;
		MergeSort(a, left, mid);
		MergeSort(a, mid + 1, right);
		merge(a, left, mid, mid + 1, right);
	}

	// 출력 메서드
	static void ShowPolynomial(String str, Polynomial3[] terms, int count) {
		System.out.print(str);
		for (int i = 0; i < count; i++) {
			if (terms[i] == null)
				break;
			// 두번째 항 부터는 앞에 "+"를 붙여준다.
			if (i > 0) {
				System.out.print(" + ");
			}
			// 지수에 따른 출력 포멧 처리
			// 지수가 0이면 상수항 (소수점 한자리까지만 출력)
			if (terms[i].exp == 0) {
				System.out.printf("%.1f", terms[i].coef);
			// 지수가 1이면 1차항
			} else if (terms[i].exp == 1) {
				System.out.printf("%.1fx", terms[i].coef);
			// 아니면, 일반항
			} else {
				System.out.printf("%.1fx^%d", terms[i].coef, terms[i].exp);
			}
		}
		System.out.println();
	}

	static int AddPolynomial(Polynomial3[] x, Polynomial3[] y, Polynomial3[] z) {
		// 다항식 배열의 인덱스
		int p = 0; // x배열의 현재 항 위치 (x[p])
		int q = 0; // y배열의 현재 항 위치 (y[q])
		int r = 0; // 결과 다항식 z 배열의 현재 항 위치 (z[r])
		int terms = 0;
		while (p < x.length && x[p] != null && q < y.length && y[q] != null) {
			if (x[p].exp > y[q].exp) {
				// 항을 계산해야 함
				terms = addTerm(z, x[p], terms);
				p++;
			} else if (x[p].exp < y[q].exp) {
				// 항을 계산해야 함
				terms = addTerm(z, y[q], terms);
				q++;
			} else {
				// 덧셈
				Polynomial3 sum = new Polynomial3(x[p].coef + y[q].coef, x[p].exp); // [수정] coef + coef
				terms = addTerm(z, sum, terms);
				p++;
				q++;
			}
		}
		// 남은 항들 추가
		while (p < x.length && x[p] != null)
			terms = addTerm(z, x[p++], terms);
		while (q < y.length && y[q] != null)
			terms = addTerm(z, y[q++], terms);
		return terms;
	}

	static int addTerm(Polynomial3[] z, Polynomial3 term, int terms) {
		z[terms] = new Polynomial3(term.coef, term.exp); // [수정] Polynomia13 → Polynomial3
		return terms + 1; // [수정] 항 추가 후 terms 증가 필요
	}

	static int MultiplyPolynomial(Polynomial3[] x, Polynomial3[] y, Polynomial3[] z) {
		int terms = 0;
		for (Polynomial3 valueX : x) {
			if (valueX == null)
				break;
			for (Polynomial3 valueY : y) {
				if (valueY == null)
					break;
				Polynomial3 term = new Polynomial3(valueX.coef * valueY.coef, valueX.exp + valueY.exp);
				terms = addTerm(z, term, terms);
			}
		}
		return terms;
	}

	static double EvaluatePolynomial(Polynomial3[] z, int zTerms, int value) {
		double result = 0.0;
		for (int i = 0; i < zTerms; i++) {
			result += z[i].coef * Math.pow(value, z[i].exp);
		}
		return result;
	}

	public static void main(String[] args) {
		Polynomial3[] x = { new Polynomial3(1.5, 3), new Polynomial3(2.5, 7), new Polynomial3(3.3, 2),
				new Polynomial3(4.0, 1), new Polynomial3(2.2, 0), new Polynomial3(3.1, 4), new Polynomial3(3.8, 5), };
		Polynomial3[] y = { new Polynomial3(1.5, 1), new Polynomial3(2.5, 2), new Polynomial3(3.3, 3),
				new Polynomial3(4.0, 0), new Polynomial3(2.2, 4), new Polynomial3(3.1, 5), new Polynomial3(3.8, 6), };

		ShowPolynomial("다항식 x = ", x, x.length);
		ShowPolynomial("다항식 y = ", y, y.length);

		MergeSort(x, 0, x.length - 1);
		MergeSort(y, 0, y.length - 1);

		ShowPolynomial("정렬후 다항식 x = ", x, x.length);
		ShowPolynomial("정렬후 다항식 y = ", y, y.length);

		Polynomial3[] z = new Polynomial3[50];
		int zTerms = AddPolynomial(x, y, z);
		// 다항식 덧셈 z = x + y
		ShowPolynomial("덧셈후 다항식 z = ", z, zTerms);

		z = new Polynomial3[100]; // 곱셈 결과가 더 클 수 있으므로 배열 재할당
		zTerms = MultiplyPolynomial(x, y, z);
		// 다항식 곱셈
		MergeSort(z, 0, zTerms - 1);
		ShowPolynomial("곱셈후 다항식 z = ", z, zTerms);

		double result = EvaluatePolynomial(z, zTerms, 1);
		System.out.printf("result = %.2f\n", result);
	}
}