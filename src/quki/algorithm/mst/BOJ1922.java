package quki.algorithm.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ1922 {

	static void union(int x, int y, int p[]) {
		int rootX = findRoot(x, p);
		int rootY = findRoot(y, p);
		p[rootY] = p[rootX];
	}

	static int findRoot(int x, int p[]) {
		if (x == p[x])
			return x;

		return p[x] = findRoot(p[x], p);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Edge> edges = new ArrayList<>();
		while (M-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();
			edges.add(new Edge(u, v, c));
		}

		Collections.sort(edges, new Comparator<Edge>() {

			@Override
			public int compare(Edge e1, Edge e2) {

				if (e1.c < e2.c) {
					return -1;
				} else if (e1.c == e2.c) {
					return 0;
				} else {
					return 1;
				}
			}
		});

		int p[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
		int ans = 0;
		for (Edge e : edges) {
			int u = e.u;
			int v = e.v;
			int c = e.c;

			if (findRoot(u, p) != findRoot(v, p)) {
				union(u,v,p);
				ans+=c;
			}

		}
		System.out.println(ans);
	}

	static class Edge {
		private int u;
		private int v;
		private int c;

		Edge(int u, int v, int c) {
			this.u = u;
			this.v = v;
			this.c = c;
		}
	}
}
