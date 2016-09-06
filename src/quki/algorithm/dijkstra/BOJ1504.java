package quki.algorithm.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * 다익스트라
 * 특정 경로를 지나야함
 * 시작점을 다르게 해서 구함.
 * 
 * @author quki
 *
 */
public class BOJ1504 {

	public static final int inf = 100000000; // 한자리 낮춤. inf+inf+inf일 수 있어서

	public static class Edge {
		int v;
		int c;

		Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

	public static int dijkstra(int start, int end, HashMap<Integer, ArrayList<Edge>> hm) {

		int n = hm.size() - 1;

		int d[] = new int[n + 1];
		boolean check[] = new boolean[n + 1];
		Arrays.fill(d, inf);
		d[start] = 0;

		for (int i = 1; i <= n - 1; i++) {

			check[start] = true;

			// Relaxation
			for (Edge e : hm.get(start)) {
				int u = start;
				int v = e.v;
				int c = e.c;
				if (d[v] > d[u] + c) {
					d[v] = d[u] + c;
				}

			}

			// 다음 start 찾기
			int min = inf;
			for (int j = 1; j <= n; j++) {
				if (d[j] < min && !check[j]) {
					min = d[j];
					start = j;
				}
			}

		}

		return d[end];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		HashMap<Integer, ArrayList<Edge>> hm = new HashMap<>();
		for (int i = 0; i <= n; i++) {
			hm.put(i, new ArrayList<Edge>());
		}
		while (m-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();
			hm.get(u).add(new Edge(v, c));
			hm.get(v).add(new Edge(u, c));
		}
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();
		int start = 1;
		int end = n;

		// 두가지 경우가 존재
		// 1 - v1 - v2 - n
		// 1 - v2 - v1 - n
		int p1 = dijkstra(start, v1, hm);
		int p2 = dijkstra(v1, v2, hm);
		int p3 = dijkstra(v2, end, hm);
		int ans1 = p1 + p2 + p3;
		p1 = dijkstra(start, v2, hm);
		p2 = dijkstra(v2, v1, hm);
		p3 = dijkstra(v1, end, hm);
		int ans2 = p1 + p2 + p3;

		int ans = Math.min(ans1, ans2);
		if (ans >= inf) {
			ans = -1;
		}
		System.out.println(ans);

	}

}
