package quki.algorithm.spfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 
 * 다익스트라 -> SPFA
 * 특정한 경로를 지나는 최단경로
 * 
 * @author quki
 *
 */
public class BOJ1504 {
	static HashMap<Integer, ArrayList<Edge>> graph;
	static int N, M;
	static final int INF = 100000000; // 한자리 작게 잡음, INF + INF + INF 연산 때문

	static class Edge {
		int v;
		int c;

		Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

	static int SPFA(int start, int end) {

		int d[] = new int[N + 1];
		boolean isInQueue[] = new boolean[N + 1];

		Arrays.fill(d, INF);
		d[start] = 0;

		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		isInQueue[start] = true;
		while (!q.isEmpty()) {

			int u = q.poll();
			isInQueue[u] = false;

			for (Edge e : graph.get(u)) {
				int v = e.v;
				int c = e.c;

				if (d[v] > d[u] + c) {
					d[v] = d[u] + c;
					if (!isInQueue[v]) {
						q.add(v);
						isInQueue[v] = true;
					}
				}

			}

		}

		return d[end];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		graph = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			graph.put(i, new ArrayList<Edge>());
		}

		while (M-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();
			graph.get(u).add(new Edge(v, c));
			graph.get(v).add(new Edge(u, c));
		}

		int v1 = sc.nextInt();
		int v2 = sc.nextInt();
		int start = 1;
		int end = N;
		
		// start - v1 - v2 - end
		int p1 = SPFA(start, v1);
		int p2 = SPFA(v1, v2);
		int p3 = SPFA(v2, end);
		int ans1 = p1 + p2 + p3;
		// start - v2 - v1 - end
		int t1 = SPFA(start, v2);
		int t2 = SPFA(v2, v1);
		int t3 = SPFA(v1, end);
		int ans2 = t1 + t2 + t3;
		
		int ans = Math.min(ans1, ans2);
		
		if(ans >= INF){
			System.out.println(-1);
		}else{
			System.out.println(ans);
		}

	}

}
