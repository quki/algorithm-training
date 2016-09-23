package quki.algorithm.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/**
 * DFS + 이분탐색
 * DFS에서 boolean 리턴하는게 좀 어려움
 * 
 * @author quki
 *
 */
public class BOJ1939 {

	static class Edge {
		int v;
		int c;

		Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

	/**
	 * DFS
	 * 그냥 end로 갈수만 있으면 true
	 */
	static boolean isPossible(HashMap<Integer, ArrayList<Edge>> graph, boolean[] check, int mid, int node, int end) {

		check[node] = true;

		if (node == end)
			return true;

		for (Edge e : graph.get(node)) {
			int c = e.c;
			int v = e.v;
			if (!check[v] && mid <= c) {
				if (isPossible(graph, check, mid, v, end))
					return true;
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

		boolean check[] = new boolean[N + 1];
		int left = 1; // 내가 구하고자 하는 것(중량)의 최소값
		int right = 1000000000; // 내가 구하고자 하는 것(중량)의 최대값
		int ans = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			Arrays.fill(check, false);
			if (isPossible(graph, check, mid, start, end)) {
				left = mid + 1;
				ans = mid;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(ans);

	}

}
