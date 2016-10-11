package quki.algorithm.graph.search.dfs;

import java.util.HashSet;
import java.util.Scanner;
/**
 * 부분집합의 최소
 * 
 * @author quki
 *
 */
public class BOJ1182 {
	static int S;
	static int cnt = 0;
	static void go(int[] a, HashSet<Integer> check, int currIdx){
		int sum = 0;
		for(int e: check){
			sum+=e;
		}
		
		if(sum == S){
			cnt++;
		}
		
		for(int next = currIdx+1; next<a.length; next++){
			
			check.add(a[next]);
			go(a, check, next);
			check.remove(a[next]);
		}
	
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		S = sc.nextInt();
		int a[] = new int[N];
		for(int i = 0; i<N;i++){
			a[i] = sc.nextInt();
		}
		HashSet<Integer> check = new HashSet<>();
		
		for(int i = 0; i<N; i++){
			check.add(a[i]);
			go(a, check, i);
			check.remove(a[i]);
		}
		
		System.out.println(cnt);
		
		
	}

}
