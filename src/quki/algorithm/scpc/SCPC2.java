package quki.algorithm.scpc;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 시간 초과
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
			boolean bomb[] = new boolean[N+1]; 
			for (int i = 1; i <= L; i++) {
				int b = sc.nextInt();
				bomb[b] = true;
			}
			Arrays.fill(d[0], 1);
			int mod = 1000000009;
			for (int n = 1; n <= N; n++) {
				
				if(bomb[n])
					continue;
				
				for (int k = 1; k <= K; k++) {

					int sum = 0;

					if (n - k >= 0) {
						for (int j = 1; j <= K; j++) {
							if (j != k) {
								sum = (sum + d[n - k][j]) % mod;
							}
						}
					}

					d[n][k] = sum;
				}
			}

			System.out.println("Case #" + test_case);
			int ans = 0;
			for(int i = 1; i<=K ; i++){
				ans+= d[N][i];
			}
			System.out.println(ans);

		}
	}

}
