
package quki.algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2294 {
	static final int INF = 1000000000;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int N = sc.nextInt();
		int dp[] = new int[N + 1];
		int cost[] = new int[K];
		for (int i = 0; i < K; i++) {
			cost[i] = sc.nextInt();
		}
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for (int i = 1; i <= N; i++) {
			for (int k = 0; k < cost.length; k++) {
				if (i - cost[k] >= 0) {
					dp[i] = Math.min(dp[i], dp[i - cost[k]] + 1);
				}
			}
		}
		if (dp[N] == INF) {
			System.out.println(-1);
		} else {
			System.out.println(dp[N]);
		}

	}

}
