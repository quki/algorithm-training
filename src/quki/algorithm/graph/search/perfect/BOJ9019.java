package quki.algorithm.graph.search.perfect;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ9019 {

	public static final int MOD = 10000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			int[] depth = new int[10000];
			char[] fromCmd = new char[10000];
			int[] from = new int[10000];

			Queue<Integer> q = new LinkedList<>();
			q.add(A);

			while (!q.isEmpty()) {
				int now = q.remove();
				if (now == B)
					break;

				int next = now;

				// D
				next = 2 * now % MOD;

				if (depth[next] == 0 || depth[now] + 1 < depth[next]) {
					q.add(next);
					fromCmd[next] = 'D';
					from[next] = now;
					depth[next] = depth[now] + 1;
				}

				// S
				next = now - 1;
				if (now == 0) {
					next = 9999;
				}

				if (depth[next] == 0 || depth[now] + 1 < depth[next]) {
					q.add(next);
					fromCmd[next] = 'S';
					from[next] = now;
					depth[next] = depth[now] + 1;
				}

				// L
				next = (now / 1000) + (now % 1000) * 10;
				if (depth[next] == 0 || depth[now] + 1 < depth[next]) {
					q.add(next);
					fromCmd[next] = 'L';
					from[next] = now;
					depth[next] = depth[now] + 1;
				}

				// R
				next = (now / 10) + (now % 10) * 1000;
				if (depth[next] == 0 || depth[now] + 1 < depth[next]) {
					q.add(next);
					fromCmd[next] = 'R';
					from[next] = now;
					depth[next] = depth[now] + 1;
				}

			}

			Stack<Character> st = new Stack<>();
			int start = B;
			while (start != A) {
				st.push(fromCmd[start]);
				start = from[start];
			}
			StringBuilder ans = new StringBuilder();
			while (!st.isEmpty()) {
				ans.append(st.pop());
			}
			System.out.println(ans);
		}
	}

}
