import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SetsTree {
	// private Map<Integer, Integer> parent;
    // private Map<Integer, Integer> rank;
    
	private int[] parent;
    private int n;   
    
    public SetsTree(int sz) {
        n = sz;
        parent = new int[sz + 1]; // Don't want to use parent[0]
        Arrays.fill(parent, -1);  // Initialize with -1
    }      
    
    public int simpleFind(int i) {
    	while(parent[i] >= 0) { 
    		i = parent[i];
    	}
    	return i;
    }
    
    public void simpleUnion(int i, int j) { 
        i = simpleFind(i); 
        j = simpleFind(j);
        if (i == j) return; // 이미 같은 집합 
        parent[j] = i; 
    }
    
    public int find(int i) {
    	if (parent[i] < 0) { // i가 root 인가요?
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
        	parent[i] += parent[j]; // 병합
        	parent[j] = i; // j를 i의 자식으로 만듬
        } else {
        	parent[j] += parent[i]; // 병합
        	parent[i] = j; // i를 j의 자식으로 만듬
        }
    }
    
    public void delete(int n) {
    	if (n <= 0 || n > this.n) {
        	System.out.println("잘못된 매개변수 입니다.");
        	return;
    	}   	
    	parent[n] = -1;
    }
    
    // connected
    public boolean connected(int i, int j) {
    	return find(i) == find(j);
    }
}