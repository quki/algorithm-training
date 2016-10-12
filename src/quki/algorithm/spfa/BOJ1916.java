package quki.algorithm.spfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 다익스트라 -> SPFA
 * 
 * @author quki
 *
 */
public class BOJ1916 {

	static final int INF = 1000000000;

	static class Edge {
		int v;
		int c;

		Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		HashMap<Integer, ArrayList<Edge>> graph = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			graph.put(i, new ArrayList<Edge>());
		}
		while (M-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();
			graph.get(u).add(new Edge(v, c));
		}

		int start = sc.nextInt();
		int end = sc.nextInt();

		int d[] = new int[N + 1];
		Arrays.fill(d, INF);
		d[start] = 0;
		boolean isInQueue[] = new boolean[N + 1];
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
		
		System.out.println(d[end]);

	}

}
