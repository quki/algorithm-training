package quki.algorithm.graph.search.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 케빈베이컨 법칙을 dfs로
 * 
 * @author quki
 *
 */
public class BOJ1389 {

	static int d[][];
	static HashMap<Integer, ArrayList<Integer>> graph;
	static int N;
	static boolean check[];

	static void DFS(int source, int current, int depth) {

		depth++;

		for (int next : graph.get(current)) {
			if (!check[next]) {

				if (d[source][next] == 0 || d[source][next] > depth) {
					d[source][next] = depth;
					check[next] = true;
					DFS(source, next, depth);
					check[next] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();

		d = new int[N + 1][N + 1];
		graph = new HashMap<>();
		check = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			graph.put(i, new ArrayList<Integer>());
		}

		while (M-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		for (int source = 1; source <= N; source++) {
			DFS(source, source, 0);
		}
		int ans = 0;
		int min = 1000000000;
		for (int i = N; i >= 1; i--) {

			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += d[i][j];
			}
			if (min >= sum) {
				min = sum;
				ans = i;
			}

		}
		System.out.println(ans);

	}

}
