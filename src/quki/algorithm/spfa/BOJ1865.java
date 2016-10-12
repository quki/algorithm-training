package quki.algorithm.spfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 벨만포드 -> SPFA로 풀기
 * 
 * @author quki
 *
 */
public class BOJ1865 {

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
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int W = sc.nextInt();

			HashMap<Integer, ArrayList<Edge>> graph = new HashMap<>();
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

			while (W-- > 0) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int c = sc.nextInt();
				graph.get(u).add(new Edge(v, -c));
			}

			boolean isInQueue[] = new boolean[N + 1];
			int d[] = new int[N + 1];
			int cycle[] = new int[N + 1]; // 음수 사이클이 있다면 cycle[i] >=N 이다.
			Arrays.fill(d, INF);
			int start = 1;
			Queue<Integer> q = new LinkedList<>();
			q.add(start);
			isInQueue[start] = true;
			d[start] = 0;
			boolean isCycle = false;
			while (!q.isEmpty()) {

				int u = q.poll();
				isInQueue[u] = false;
				for (Edge e : graph.get(u)) {
					int v = e.v;
					int c = e.c;

					if (d[v] > d[u] + c) {
						d[v] = d[u] + c;
						cycle[v]++;
						if (!isInQueue[v]) {
							q.add(v);
							isInQueue[v] = true;
						}

						if (cycle[v] >= N) {
							isCycle = true;
							break;
						}
					}

				}

				if (isCycle)
					break;

			}

			if (isCycle) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
	}

}
