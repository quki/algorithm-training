package quki.algorithm.dp.hard;

import java.util.Scanner;

public class BOJ1513 {
	static final int MOD = 10007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int C = sc.nextInt();
		int a[][] = new int[N + 1][M + 1];
		int dp[][][][] = new int[N + 1][M + 1][C + 1][C + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				a[i][j] = -1;
			}
		}
		for (int i = 1; i <= C; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			a[x][y] = i;
		}
		dp[1][0][0][0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {

				// 오락실을 절대 거치지 않는 경우
				if (a[i][j] == -1) {
					// 오락실을 절대 거치지 않는 경우
					dp[i][j][0][0] += dp[i - 1][j][0][0] + dp[i][j - 1][0][0];
					dp[i][j][0][0] %= MOD;
				}

				// 오락실을 1개 이상 거치는 경우
				for (int l = 1; l <= C; l++) {

					// 현재 (i, j)가 오락실이 아닌 경우
					if (a[i][j] == -1) {

						for (int k = 1; k <= C; k++) {
							dp[i][j][k][l] += dp[i - 1][j][k][l] + dp[i][j - 1][k][l];
							dp[i][j][k][l] %= MOD;
						}

					} else { // 오락실인 경우
						int num = a[i][j]; // 오락실 번호
						
						// 오락실 개수 1개
						if (l == 1) {
							dp[i][j][num][1] += dp[i - 1][j][0][0] + dp[i][j - 1][0][0];
							dp[i][j][num][1] %= MOD;
						} else {
							for (int k = 1; k < num; k++) {
								dp[i][j][num][l] += dp[i - 1][j][k][l - 1] + dp[i][j - 1][k][l - 1];
								dp[i][j][num][l] %= MOD;
							}
						}

					}
				}

			}
		}
		int ans[] = new int[C + 1];
		for (int l = 0; l <= C; l++) {
			for (int k = 0; k <= Math.max(C,1); k++) {
				ans[l] += dp[N][M][k][l];
				ans[l] %= MOD;
			}
			System.out.print(ans[l] + " ");
		}

	}

}
