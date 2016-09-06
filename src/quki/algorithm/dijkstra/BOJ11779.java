package quki.algorithm.dijkstra;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * BOJ 1916과 비슷 경로 찍기
 * 
 * 인접행렬로 풀어보겠다. 인접행렬 초기화 부분이 번거로우니까 그냥 인접리스트로하자.
 * 
 * @author quki
 *
 */
public class BOJ11779 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[][] = new int[n + 1][n + 1];

		int inf = 1000000000;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a[i][j] = inf;
			}
		}
		while (m-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();
			if (a[u][v] > c) {
				a[u][v] = c;
			}
		}
		int start = sc.nextInt();
		int end = sc.nextInt();

		int d[] = new int[n + 1];
		boolean check[] = new boolean[n + 1];
		int parent[] = new int[n + 1];
		Arrays.fill(d, inf);
		d[start] = 0;
		check[start] = true;
		parent[start] = start;

		int u = start;
		for (int i = 1; i <= n - 1; i++) {

			// Relaxation
			for (int j = 1; j <= n; j++) {
				if (d[j] > d[u] + a[u][j]) {
					d[j] = d[u] + a[u][j];
					parent[j] = u;
				}
			}

			// 다음 Edge
			int min = inf;
			for (int j = 1; j <= n; j++) {
				if (!check[j] && d[j] < min) {
					min = d[j];
					u = j;
				}
			}

			check[u] = true;

		}

		// 출력
		StringBuffer sb = new StringBuffer();
		sb.append(d[end] + "\n");
		Stack<Integer> st = new Stack<>();
		int k = end;
		st.add(k);
		while (true) {
			if (start == k)
				break;

			k = parent[k];
			st.add(k);

		}
		sb.append(st.size() + "\n");

		while (!st.isEmpty()) {
			sb.append(st.pop() + " ");
		}

		System.out.println(sb);

	}

}
