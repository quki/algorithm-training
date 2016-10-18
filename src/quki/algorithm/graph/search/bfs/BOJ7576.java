package quki.algorithm.graph.search.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ7576 {

	static int dx[] = { 0, 0, -1, 1 }; // ╩С, го , аб, ©Л
	static int dy[] = { -1, 1, 0, 0 };

	static class Point {
		int i;
		int j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int a[][] = new int[N][M];
		int d[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(d[i], -1);
		}
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int e = sc.nextInt();
				a[i][j] = e;
				if (e == 1) {
					q.add(new Point(i, j));
				}
				d[i][j] = e;
			}
		}

		while (!q.isEmpty()) {

			Point p = q.poll();
			int i = p.i;
			int j = p.j;

			for (int k = 0; k < dx.length; k++) {
				int newJ = j + dx[k];
				int newI = i + dy[k];

				if (newI >= 0 && newI < N && newJ >= 0 && newJ < M) {
					if (a[newI][newJ] == 0) {
						d[newI][newJ] = d[i][j] + 1;
						a[newI][newJ] = 1;
						q.add(new Point(newI, newJ));
					}
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (d[i][j] == -1) {
					continue;
				} else if (d[i][j] == 0) {
					System.out.println(-1);
					return;

				} else {
					ans = Math.max(ans, d[i][j]);
				}
			}
		}
		System.out.println(ans - 1);

	}

}
