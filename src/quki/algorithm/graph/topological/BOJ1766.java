package quki.algorithm.graph.topological;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1766 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int ind[] = new int[N+1];
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
		for(int i = 0; i<N+1; i++){
			graph.put(i, new ArrayList<Integer>());
		}
		while(M-- > 0){
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph.get(u).add(v);
			ind[v]++;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 1; i<= N; i++){
			if(ind[i] == 0) pq.add(i);
		}
		StringBuilder ans = new StringBuilder();
		while(!pq.isEmpty()){
			int u = pq.poll();
			ans.append(u);
			ans.append(" ");
			for(int v: graph.get(u)){
				ind[v]--;
				if(ind[v] == 0) pq.add(v);
			}
		}
		
		System.out.print(ans.toString());
		
		
		
		
	}

}
