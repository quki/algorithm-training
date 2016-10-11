package quki.algorithm.graph.search.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 운동
 * DFS로 풀었지만 시간초과남
 * 
 * TSP, 플로이드와샬
 * 
 * @author quki
 *
 */
public class BOJ1956 {
	static HashMap<Integer, ArrayList<Edge>> graph;
	static boolean[] check;
	static int N, M;
	static int d[][];
	static final int INF = 1000000000;

	static class Edge {
		int v;
		int c;

		Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

	static void dfs(int source, int current) {

		for (Edge e : graph.get(current)) {
			int next = e.v;
			int c = e.c;
			if (!check[next]) {
				if (d[source][next] == 0 || d[source][next] > d[source][current] + c) {
					d[source][next] = d[source][current] + c;
					check[next] = true;
					dfs(source, next);
					check[next] = false;
				}
			}

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		graph = new HashMap<>();
		check = new boolean[N + 1];
		d = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			graph.put(i, new ArrayList<Edge>());
		}
		while (M-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();

			graph.get(u).add(new Edge(v, c));
		}

		for (int source = 1; source <= N; source++) {
			dfs(source, source);
		}

		int ans = INF;
		for (int i = 1; i <= N; i++) {
			if (d[i][i] != 0)
				ans = Math.min(ans, d[i][i]);
		}

		if (ans == INF) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}

	}

}
