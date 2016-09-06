package quki.algorithm.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/**
 * 다익스트라알고리즘
 * 인접행렬, 인접리스트: O(V^2)
 * 이유: V^2 + E -> E<V^2 이므로 O(V^2)
 * @author quki
 *
 */
public class BOJ1916 {

	public static class Edge {
		int v;
		int c;

		Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
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
		}

		int start = sc.nextInt();
		int end = sc.nextInt();

		int d[] = new int[n + 1];
		boolean check[] = new boolean[n + 1];
		int inf = 1000000000;
		Arrays.fill(d, inf);
		d[start] = 0;
		check[start] = true;

		// 벨만포드와는 다르게 V-1번만 돌리면 된다.
		for (int i = 1; i <= n - 1; i++) {

			// Relaxation, 총: O(E)
			for (Edge e : hm.get(start)) {
				int u = start;
				int v = e.v;
				int c = e.c;
				if (d[v] > d[u] + c) {
					d[v] = d[u] + c;
				}

			}
			
			// 다음 Edge 골라내기
			// d[j] 값 중 최소값을 찾아낸다.
			int min = inf;
			for (int j = 1; j <= n; j++) {
				if (d[j] < min && !check[j]) {
					start = j;
					min = d[j];
				}

			}
			
			check[start] = true;

		}
		
		System.out.println(d[end]);

	}

}
