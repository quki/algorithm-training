package quki.algorithm.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 이분탐색 + BFS
 * 
 * @author quki
 *
 */
public class BOJ1939BFS {

	static class Edge {
		int v;
		int c;

		Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

	/**
	 * BFS
	 */
	static boolean isPossible(HashMap<Integer, ArrayList<Edge>> graph, int start, int end, int mid) {
		boolean check[] = new boolean[graph.size()];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		check[start] = true;
		while(!q.isEmpty()){
			int u = q.poll();
			for(Edge e : graph.get(u)){
				int v = e.v;
				int c = e.c; // limit
				if(!check[v] && mid <= c){
					
					if(v == end)
						return true;
					
					q.add(v);
					check[v] = true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		HashMap<Integer, ArrayList<Edge>> graph = new HashMap<>();
		for (int i = 0; i <= N; i++) {
			graph.put(i, new ArrayList<Edge>());
		}
		while (M-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();
			graph.get(u).add(new Edge(v, c));
			graph.get(v).add(new Edge(u, c));
		}
		int start = sc.nextInt();
		int end = sc.nextInt();
		int left = 1;
		int right = 1000000000;
		int ans = 0;
		while (left <= right) {
			int mid = (left + right) / 2; // 중량
			if (isPossible(graph, start, end, mid)) {
				left = mid + 1;
				ans = mid;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(ans);

	}

}
