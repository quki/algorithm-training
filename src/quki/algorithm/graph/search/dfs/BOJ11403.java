package quki.algorithm.graph.search.dfs;

import java.util.Scanner;

/**
 * 플로이드 와샬로 풀 수 있다
 * 
 * @author quki
 *
 */

public class BOJ11403 {

	static int N;
	static int[][] graph;
	static boolean[] visited;

	static void dfs(int source, int current) {

		for (int next = 1; next <= N; next++) {
			if (graph[current][next] == 1 && !visited[next]) {
				
				if(source!=current && graph[source][next] != 0)
					continue;
				
				graph[source][next] = 1;

				visited[next] = true;
				dfs(source, next);
				visited[next] = false;
			}
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		graph = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				graph[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= N; i++) {
			dfs(i, i);
		}
		StringBuilder ans = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ans.append(graph[i][j]);
				ans.append(" ");
			}
			ans.append("\n");
		}
		System.out.println(ans);
	}

}