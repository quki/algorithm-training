package quki.algorithm.string;

import java.util.Scanner;
import java.util.Stack;

/**
 * 문자열 폭발
 * 
 * @author quki
 *
 */
public class BOJ9935 {

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String origin = sc.nextLine();
		String bombed = sc.nextLine();
		int N = origin.length();
		int M = bombed.length();
		boolean deleted[] = new boolean[N];

		if (M == 1) {
			for (int i = 0; i < N; i++) {
				if (origin.charAt(i) == bombed.charAt(0)) {
					deleted[i] = true;
				}
			}
		} else {
			Stack<Pair> st = new Stack<>();
			for (int i = 0; i < N; i++) {
				if (origin.charAt(i) == bombed.charAt(0)) {
					st.push(new Pair(i, 0));
				} else {
					if (!st.isEmpty()) {
						Pair p = st.peek();
						if (origin.charAt(i) == bombed.charAt(p.y + 1)) {
							st.push(new Pair(i, p.y + 1));
							if (p.y + 1 == M - 1) {
								// bomb 길이 만큼 빼기
								for (int j = 0; j < M; j++) {
									Pair pPop = st.pop();
									deleted[pPop.x] = true;
								}
							}
						} else {
							while (!st.isEmpty()) {
								st.pop();
							}
						}
					}

				}

			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (deleted[i])
				continue;

			sb.append(origin.charAt(i));
		}

		if (sb.length() == 0) {
			System.out.println("FLURA");
		} else {
			System.out.println(sb.toString());
		}

	}

}
