package quki.algorithm.floyd;

import java.util.Scanner;
/**
 * 경로가 있는지 확인하는 Floyd Warshall
 * @author quki
 *
 */
public class BOJ11403 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d[][] = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				d[i][j] = sc.nextInt();
			}
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (d[i][k] == 1 && d[k][j] == 1) {
						d[i][j] = 1;
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(d[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}

	}

}
