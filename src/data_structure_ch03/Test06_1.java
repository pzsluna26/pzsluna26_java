package data_structure_ch03;

import java.util.Arrays;

class PhyscData2 implements Comparable<PhyscData2> {
    String name;
    int height;
    double vision;

    public PhyscData2(String name, int height, double vision) {
        this.name = name;
        this.height = height;
        this.vision = vision;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + height + ", " + vision + "]";
    }

    @Override
    public int compareTo(PhyscData2 p) {
        // height 비교 기준
        return Integer.compare(this.height, p.height);
    }
}

public class Test06_1 {
    public static void main(String[] args) {
        PhyscData2[] data = {
            new PhyscData2("홍길동", 162, 0.3),
            new PhyscData2("나동", 164, 1.3),
            new PhyscData2("최길", 152, 0.7),
            new PhyscData2("홍길동", 162, 0.3),
            new PhyscData2("박동", 182, 0.6),
            new PhyscData2("박동", 167, 0.2),
            new PhyscData2("길동", 167, 0.5),
        };

        showData("정렬전", data);
        sortData(data);
        showData("정렬후", data);
        reverse(data);
        showData("역순 재배치후", data);

        Arrays.sort(data); // Comparable로 정렬
        showData("Arrays.sort() 정렬후", data);

        PhyscData2 key = new PhyscData2("길동", 167, 0.5);
        int resultIndex = linearSearch(data, key);
        System.out.println("\nlinearSearch(<길동,167,0.5>): result index = " + resultIndex);

        key = new PhyscData2("박동", 167, 0.6);
        resultIndex = binarySearch(data, key);
        System.out.println("\nbinarySearch(<박동,167,0.6>): result index = " + resultIndex);

        key = new PhyscData2("나동", 164, 0.6);
        resultIndex = Arrays.binarySearch(data, key);
        System.out.println("\nArrays.binarySearch(<나동,164,0.6>): result index = " + resultIndex);
    }

    static void showData(String title, PhyscData2[] data) {
        System.out.println("[" + title + "]");
        for (PhyscData2 d : data) {
            System.out.println(d);
        }
    }

    static void sortData(PhyscData2[] data) {
        // 단순 삽입 정렬
        for (int i = 1; i < data.length; i++) {
            PhyscData2 tmp = data[i];
            int j;
            for (j = i; j > 0 && data[j - 1].compareTo(tmp) > 0; j--) {
                data[j] = data[j - 1];
            }
            data[j] = tmp;
        }
    }

    static void reverse(PhyscData2[] data) {
        for (int i = 0; i < data.length / 2; i++) {
            PhyscData2 tmp = data[i];
            data[i] = data[data.length - i - 1];
            data[data.length - i - 1] = tmp;
        }
    }

    static int linearSearch(PhyscData2[] data, PhyscData2 key) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].compareTo(key) == 0) return i;
        }
        return -1;
    }

    static int binarySearch(PhyscData2[] data, PhyscData2 key) {
        int pl = 0;
        int pr = data.length - 1;
        while (pl <= pr) {
            int pc = (pl + pr) / 2;
            int cmp = key.compareTo(data[pc]);
            if (cmp == 0) return pc;
            else if (cmp < 0) pr = pc - 1;
            else pl = pc + 1;
        }
        return -1;
    }
}