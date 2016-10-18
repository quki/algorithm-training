package quki.algorithm.graph.search.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
/**
 * DSLR
 * 
 * @author quki
 *
 */
public class BOJ9019 {

	public static final int MOD = 10000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			boolean[] check= new boolean[10000];
			char[] fromCmd = new char[10000];
			int[] from = new int[10000];

			Queue<Integer> q = new LinkedList<>();
			q.add(A);
			check[A] = true;
			while (!q.isEmpty()) {
				int now = q.remove();
				if (now == B)
					break;

				int next = now;

				// D
				next = 2 * now % MOD;

				if (!check[next]) {
					q.add(next);
					fromCmd[next] = 'D';
					from[next] = now;
					check[next] = true;
				}

				// S
				next = now - 1;
				if (now == 0) {
					next = 9999;
				}

				if (!check[next]) {
					q.add(next);
					fromCmd[next] = 'S';
					from[next] = now;
					check[next] = true;
				}

				// L
				next = (now / 1000) + (now % 1000) * 10;
				if (!check[next]) {
					q.add(next);
					fromCmd[next] = 'L';
					from[next] = now;
					check[next] = true;
				}

				// R
				next = (now / 10) + (now % 10) * 1000;
				if (!check[next]) {
					q.add(next);
					fromCmd[next] = 'R';
					from[next] = now;
					check[next] = true;
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
