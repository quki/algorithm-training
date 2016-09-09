package quki.algorithm.scpc;

import java.util.Scanner;

/**
 * DP 2차원 배열
 * 1. MOD 계산 주의 
 * 2. 3중 for문 주의
 * 
 * @author quki
 *
 */
public class SCPC2 {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			int K = sc.nextInt();
			int L = sc.nextInt();

			int d[][] = new int[N + 1][K + 1];
			boolean bomb[] = new boolean[N + 1];
			int sum[] = new int[N + 1];
			int mod = 1000000009;

			for (int i = 1; i <= L; i++) {
				int b = sc.nextInt();
				bomb[b] = true;
			}

			// 초기화
			if (!bomb[1]) {
				d[1][1] = 1;
				sum[1] = 1;
			}

			for (int i = 2; i <= N; i++) {

				if (bomb[i])
					continue;

				// 점화식
				for (int m = 1; m <= K; m++) {

					if (i - m > 0) {
						d[i][m] = (sum[i - m] + mod - d[i - m][m]) % mod;
					}
					if (i == m) {
						d[i][m] = 1;
					}
				}

				// sum 계산
				for (int m = 1; m <= K; m++) {
					sum[i] = (sum[i] + d[i][m]) % mod;
				}

			}

			System.out.println("Case #" + test_case);
			System.out.println(sum[N]);

		}
	}

}
