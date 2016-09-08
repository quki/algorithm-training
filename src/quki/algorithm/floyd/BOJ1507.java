package quki.algorithm.floyd;

import java.util.Scanner;
/**
 * 모든 간선을 검사하며
 * 필요없는 간선을 제거하는 Technique
 * 
 * @author quki
 *
 */
public class BOJ1507 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				d[i][j] = sc.nextInt();
			}
		}
		// 필요없는 간선은 제거하자
		boolean unused[][] = new boolean[n][n];
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				if (k == i)
					continue;
				for (int j = 0; j < n; j++) {

					if (k == j)
						continue;
					if (i == j)
						continue;

					if (d[i][j] == d[i][k] + d[k][j]) {
						unused[i][j] = true;
					}
					
					// 입력이 이미 최단경로가 주어져있는데,
					// 다시 최단경로를 계산해보니 더 짧아진 경우
					// 입력이 모순이 되니 -1을 출력하자.
					if (d[i][j] > d[i][k] + d[k][j]) {
						System.out.println(-1);
						System.exit(0);
					}
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (!unused[i][j]) {
					ans += d[i][j];
				}
			}
		}

		System.out.println(ans);

	}

}
