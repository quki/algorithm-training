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
public class BOJ1753 {
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
		int V = sc.nextInt();
		int E = sc.nextInt();
		int start = sc.nextInt();
		HashMap<Integer, ArrayList<Edge>> graph = new HashMap<>();
		for (int i = 1; i <= V; i++) {
			graph.put(i, new ArrayList<Edge>());
		}

		while (E-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();

			graph.get(u).add(new Edge(v, c));

		}

		int d[] = new int[V + 1];
		boolean isInQueue[] = new boolean[V + 1];
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

		StringBuilder ans = new StringBuilder();

		for (int i = 1; i <= V; i++) {
			int a = d[i];
			if (a >= INF) {
				ans.append("INF");
			} else {
				ans.append(d[i]);
			}
			ans.append("\n");
		}

		System.out.println(ans);

	}

}
