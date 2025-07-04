package data_structure_ex;
import java.util.ArrayList;
/*
 * 집합 트리
 * 집합 원소를 제거하는 delete() 추가, 집합 세트를 출력하는 displaySets()를 추가함
 * 그래프 문제 풀기 위해 : 세트의 union, find 함수가 필요함
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

class Sets3 {
    private int[] parent;
    private int n;

    public Sets3(int sz) {
        n = sz;
        // 배열생성
        parent = new int[sz + 1]; // Don't want to use parent[0] 
        Arrays.fill(parent, -1);  // Initialize with -1
    }
    
    
    public void delete(int n) {
    	//root를 삭제할 때 문제 있다
    	if(n <= 0 || n > this.n) {
    		System.out.println("잘못된 매개변수 입니다.");
    		return;
    	}
    	// root가 아닌 경우?
    	parent[n] = -1;
    	// n이 root이거나 non-leaf 문제 해결 필요 => LinkedList에서 문제됨 
    }

    
    // 루트 기준으로 집합set을 출력해라
    // {1,2,3} 등으로 set을 표시하기	
    void displaySets() {
    	Map<Integer, List<Integer>> sets = new HashMap<>();
    	for(int i = 1; i <= n; i++ ) {
    		int root = find(i);
    		sets.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
    	}
    	
    	System.out.println("현재 집합 상태");
    	sets.forEach((root, element) -> {
    		// 요소를 스트림으로 변환해서 오름차순 정렬, 그리고 숫자를 문자열로 바꾸고, ","로 이어붙여서 하나의 문자열로 만든다.
    		System.out.println("{"+ element.stream().sorted().map(String::valueOf).collect(java.util.stream.Collectors.joining(","))+"}");
    	});
    	System.out.println("");
    }
    
    public void display() {
        System.out.print("display:index=  ");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

        System.out.print("display:value= ");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%3d", parent[i]);
        }
        System.out.println();
    }
    
   
    
    // 루트를 찾아라
    public int simpleFind(int i) {
    	// i번째 원소를 찾아줘
    	// 찾으면 원소의 값을 보내주고
    	// 못찾으면 i번째 원소를 전달해줘
    	while(parent[i]>=0) {
    		i = parent[i];
    	}
    	// 찾았음
    	return i;
    }
    

    // i집합과 j집합을 합치자 => j그룹을 i그룹 밑에 붙이자
    public void simpleUnion(int i, int j) { //(7,1)
        // i가 속한 집합의 루트  (7) -> 7
        i = simpleFind(i);
        // j가 속한 집합의 루트  (1) -> 1
        j = simpleFind(j);
        // 이미 같은 집합 (부모가 같음) 
        if (i == j) return;
        else
        	// j가 루트 i 가 값
        	parent[j] = i; // 7 = 1

    }
    
    public int find(int i) {
    	if(parent[i] < 0) {
    		return i;
    	}
    	return parent[i] = find(parent[i]); // 경로 압축: 부모를 루트에 연결
    }
    
    public void weightedUnion(int i, int j) { 
        i = find(i); 
        j = find(j); 
        if (i == j) return;

        // 더 작은 집합을 더 큰 집합 아래에 둡니다.
        if (parent[i] < parent[j]) {
            parent[i] += parent[j]; // i의 집합 크기에 j의 크기 추가
            parent[j] = i;          // j를 i 밑에 붙임
        } else {
            parent[j] += parent[i]; // j의 집합 크기에 i의 크기 추가
            parent[i] = j;          // i를 j 밑에 붙임
        }
    }
    
    //void difference() 차집합 -  이 문제는 disjoint set을(서로소) 가정하므로 가정 변경이 필요
    //void intersection()교집합

}
public class Test09_3 {
    public static void main(String[] args) {
    	TreeSet<Integer> set1 = new TreeSet<>();
    	set1.add(1);
    	
        Sets3 m = new Sets3(20);
        m.simpleUnion(7, 1);
        m.simpleUnion(2, 3);
        m.simpleUnion(4, 5);
        m.simpleUnion(6, 7);
        m.simpleUnion(4, 2);
        m.simpleUnion(5, 7); // 어디갔??
        m.simpleUnion(8, 10);
        m.simpleUnion(13, 11);
        m.simpleUnion(12, 9);
        m.simpleUnion(14, 20);
        m.simpleUnion(16, 19);
        m.simpleUnion(17, 18);
        m.simpleUnion(12, 19);
        m.simpleUnion(13, 15);
        System.out.println("SimpleUnion() 실행 결과::");
        m.display();
        m.displaySets();
        m.weightedUnion(1, 8);
        m.weightedUnion(1, 4);
        m.weightedUnion(3, 9);
        m.weightedUnion(7, 15);
        m.weightedUnion(12, 18);
        m.weightedUnion(4, 16);
        System.out.println("WeightedUnion() 실행 결과::");
        m.display();
        m.displaySets();
        if (m.simpleFind(2) == m.simpleFind(18))
        	System.out.println("2, 18은 같은 집합이다");
        else
        	System.out.println("2, 18은 다른 집합이다");
//
//        System.out.println("***3를 집합에서 삭제한다***");
//        m.delete(3);//root를 삭제할 때 문제 있다
//        m.display();
//        m.displaySets();
//        
//        if (m.simpleFind(2) == m.simpleFind(18))
//        	System.out.println("2, 18은 같은 집합이다");
//        else
//        	System.out.println("2, 18은 다른 집합이다");
//        
    }
}

