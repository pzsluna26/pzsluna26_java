package ch04;

public class Test37_1 {

	public static void main(String[] args) {
		// 숫자처리(for 확장문 버전)
			/* '점수:90,85,78,100,98'을 배열, for확장문 , length ,if 사용해 아래 값을 출력하라. 
			 * 총 점 : 451
			 * 평 균 : 90.0
			 * 최대값 : 100
			 * 최솟값 : 78
			 */
		
		int score[] = {90,85,78,100,98};
		
		int sum = 0;
		int max = 0;
		int min = 999;
		
		for(int num : score) {
			sum += num;
			if(max < num)
				max = num;
			if(min > num)
				min = num;
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
