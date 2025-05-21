package com.ruby.java.ch09;

public class Test03 {
	/*
	 * 삼각형의 세 꼭짓점: A(x1, y1), B(x2, y2), C(x3, y3)
	 * 원 중심: (cx, cy), 반지름: r
	 * 
	 * 구하는 값: 삼각형 둘레, 삼각형 면적, 원 둘레, 원 면적
	 */
public static void main(String[] args) {
	// 삼각형 꼭짓점 좌표
    double x1 = 1, y1 = 1;
    double x2 = 4, y2 = 1;
    double x3 = 4, y3 = 5;

    // 원의 중심 좌표 및 반지름
    double cx = 3, cy = 3;
    double r = 2;

    // 삼각형의 변 길이 계산 (유클리드 거리)
    double ab = distance(x1, y1, x2, y2);
    double bc = distance(x2, y2, x3, y3);
    double ca = distance(x3, y3, x1, y1);

    // 삼각형 둘레
    double trianglePerimeter = ab + bc + ca;

    // 삼각형 면적 (Heron's formula)
    double s = trianglePerimeter / 2.0;
    double triangleArea = Math.sqrt(s * (s - ab) * (s - bc) * (s - ca));

    // 원의 둘레
    double circlePerimeter = 2 * Math.PI * r;

    // 원의 면적
    double circleArea = Math.PI * r * r;

    // 출력
    System.out.printf("삼각형 둘레: %.2f\n", trianglePerimeter);
    System.out.printf("삼각형 면적: %.2f\n", triangleArea);
    System.out.printf("원 둘레: %.2f\n", circlePerimeter);
    System.out.printf("원 면적: %.2f\n", circleArea);
}

// 두 점 사이 거리 구하는 함수
    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
	
}


/*
 * 🧠 이 예제의 핵심 포인트
삼각형의 변 길이 계산: 두 점 사이의 거리를 계산하여 삼각형의 각 변의 길이를 구합니다.
삼각형의 면적 계산: Heron's 공식을 사용하여 삼각형의 면적을 계산합니다.
원의 둘레와 면적 계산: 원의 반지름을 이용하여 둘레와 면적을 계산합니다.
 * 
 * 🔍 실무에서의 활용
그래픽스 및 게임 개발: 도형의 면적이나 둘레를 계산하여 충돌 감지나 렌더링에 활용할 수 있습니다.
CAD 소프트웨어: 도면의 정확한 면적과 둘레를 계산하여 설계에 활용할 수 있습니다.
데이터 분석: 지리 정보 시스템(GIS) 등에서 지형의 면적을 계산하는 데 활용할 수 있습니다.
 * 
 *📌 추가 설명
Heron's 공식: 세 변의 길이를 알고 있을 때 삼각형의 면적을 계산하는 공식입니다. 
반둘레(s)를 이용하여 면적을 계산합니다. 
 * 
 * 
 * 
 * 
 * */
