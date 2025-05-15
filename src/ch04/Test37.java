package ch04;

public class Test37 {

	public static void main(String[] args) {
		// 숫자처리
			/* '점수:90,85,78,100,98'을 배열, 반복문, length ,if 사용해 아래 값을 출력하라. 
			 * 총 점 : 451
			 * 평 균 : 90.0
			 * 최대값 : 100
			 * 최솟값 : 78
			 */
		
		// 문제 풀이 구상
			/* 1.1차원 배열 선언생성초기화
			 * 2.반복문을 사용해 연산(출력요소 각각 변수선언)  
			 * 3.총점은 실행문에 덧셈
			 * 4.평균은 총점 나누기 배열개수(=length)
			 * 5.최대값은 참조변수 보다 크면 참조변수로 i를 바꾸기
			 * 6.최소값은 반대로 
			 */
		
		int score[] = {90,85,78,100,98};
		
		int sum = 0;
		int max = 0;
		int min = 999;
		
		for(int i=0; i < score.length; i++) {
			sum += score[i];
			if(max < score[i])
				max = score[i];
			if(min > score[i])
				min = score[i];
		}
		
		int avg= sum/score.length;
		
		System.out.println("총 합: "+sum);
		System.out.println("평 균: "+avg);
		System.out.println("최대값: "+max);
		System.out.println("최소값: "+min);
		
		}
			
		/* Tip
		1. 요소끼리 비교를 해야할때는 참조변수를 만들어 거기에 요소를 집어넣기 
		2. 출력은 mian 안에서 해야함 
		*/
			
	}


