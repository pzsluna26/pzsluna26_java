package data_structure_ex;

class Polynomial3 implements Comparable<Polynomial3> {
    double coef; // 계수
    int exp;     // 지수

    Polynomial3() {}

    Polynomial3(double coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }

    @Override
    public int compareTo(Polynomial3 o) {
        return o.exp - this.exp; // 내림차순 정렬
    }
}

public class Test06_3 {

    static void merge(Polynomial3[] a, int lefta, int righta, int leftb, int rightb) {
        Polynomial3[] temp = new Polynomial3[30];
        int i = lefta, j = leftb, k = 0;
        while (i <= righta && j <= rightb) {
            if (a[i].exp >= a[j].exp)
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }
        while (i <= righta) temp[k++] = a[i++];
        while (j <= rightb) temp[k++] = a[j++];
        for (int m = 0; m < k; m++)
            a[lefta + m] = temp[m];
    }

    static void MergeSort(Polynomial3[] a, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        MergeSort(a, left, mid);
        MergeSort(a, mid + 1, right);
        merge(a, left, mid, mid + 1, right);
    }

    static void ShowPolynomial(String str, Polynomial3[] x, int count) {
        System.out.print(str);
        int n = count < 0 ? x.length : count;
        for (int i = 0; i < n; i++) {
            if (i != 0) System.out.print(" + ");
            System.out.printf("%.1fx**%d", x[i].coef, x[i].exp);
        }
        System.out.println();
    }

    static int AddPolynomial(Polynomial3[] x, Polynomial3[] y, Polynomial3[] z) {
        int p = 0, q = 0, terms = 0;
        while (p < x.length && q < y.length && x[p] != null && y[q] != null) {
            if (x[p].exp == y[q].exp) {
                terms = addTerm(z, new Polynomial3(x[p].coef + y[q].coef, x[p].exp), terms);
                p++; q++;
            } else if (x[p].exp > y[q].exp) {
                terms = addTerm(z, x[p++], terms);
            } else {
                terms = addTerm(z, y[q++], terms);
            }
        }
        while (p < x.length && x[p] != null) terms = addTerm(z, x[p++], terms);
        while (q < y.length && y[q] != null) terms = addTerm(z, y[q++], terms);
        return terms;
    }

    static int addTerm(Polynomial3[] z, Polynomial3 term, int terms) {
        for (int i = 0; i < terms; i++) {
            if (z[i].exp == term.exp) {
                z[i].coef += term.coef;
                return terms;
            }
        }
        z[terms] = new Polynomial3(term.coef, term.exp);
        return ++terms;
    }

    static int MultiplyPolynomial(Polynomial3[] x, Polynomial3[] y, Polynomial3[] z) {
        int terms = 0;
        for (Polynomial3 valueX : x) {
            if (valueX == null) break;
            for (Polynomial3 valueY : y) {
                if (valueY == null) break;
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
        Polynomial3[] x = {
            new Polynomial3(1.5, 3), new Polynomial3(2.5, 7), new Polynomial3(3.3, 2),
            new Polynomial3(4.0, 1), new Polynomial3(2.2, 0), new Polynomial3(3.1, 4), new Polynomial3(3.8, 5),
        };
        Polynomial3[] y = {
            new Polynomial3(1.5, 1), new Polynomial3(2.5, 2), new Polynomial3(3.3, 3),
            new Polynomial3(4.0, 0), new Polynomial3(2.2, 4), new Polynomial3(3.1, 5), new Polynomial3(3.8, 6),
        };

        ShowPolynomial("다항식 x = ", x, -1);
        ShowPolynomial("다항식 y = ", y, -1);

        MergeSort(x, 0, x.length - 1);
        MergeSort(y, 0, y.length - 1);

        ShowPolynomial("정렬후 다항식 x = ", x, -1);
        ShowPolynomial("정렬후 다항식 y = ", y, -1);

        Polynomial3[] z = new Polynomial3[50];
        for (int i = 0; i < z.length; i++) z[i] = new Polynomial3();

        int zTerms = AddPolynomial(x, y, z);
        ShowPolynomial("덧셈후 다항식 z = ", z, zTerms);

        zTerms = MultiplyPolynomial(x, y, z);
        MergeSort(z, 0, zTerms - 1);
        ShowPolynomial("곱셈후 다항식 z = ", z, zTerms);

        double result = EvaluatePolynomial(z, zTerms, 1);
        System.out.println("result = " + result);
    }
}
