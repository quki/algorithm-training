package quki.algorithm.floyd;

import java.util.Scanner;
/**
 * 경로가 없으면
 * d[i][j] == 0
 * 
 * @author quki
 *
 */
public class BOJ11404 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int d[][] = new int[n + 1][n + 1];

		while (m-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();
			
			// edge가 두개가 될 수 있으므로
			// 무조건 최소 cost를 가진 edge로 지나야지
			if(d[u][v] == 0 || d[u][v] > c){ 
                d[u][v] = c;
            }
		}

		// 중요! d[i][j] == 0 이라는 뜻은 이동할 수 없다는 뜻이지만,
		// 가장 초기의 d 배열은 인접한 cost만 표기 된다.
		// 그러므로 중간의 k를 활용해서 모든 경우의 정점을 Relaxation한다.
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (d[i][k] != 0 && d[k][j] != 0 && i!=j) {
						if (d[i][j] > d[i][k] + d[k][j] || d[i][j] == 0) {
							d[i][j] = d[i][k] + d[k][j];
						}
					}
				}
			}
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sb.append(d[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

}
