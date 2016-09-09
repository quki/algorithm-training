package quki.algorithm.scpc;

import java.util.Scanner;

/**
 * DP 2차원 배열
 * 1. mod 계산 주의 
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

			for (int n = 2; n <= N; n++) {

				if (bomb[n])
					continue;

				// 점화식
				for (int k = 1; k <= K; k++) {

					if (n - k > 0) {
						d[n][k] = (sum[n - k] + mod - d[n - k][k]) % mod;
					}
					if (n == k) {
						d[n][k] = 1;
					}
				}

				// sum 계산
				for (int k = 1; k <= K; k++) {
					sum[n] = (sum[n] + d[n][k]) % mod;
				}

			}

			System.out.println("Case #" + test_case);
			System.out.println(sum[N]);

		}
	}

}
