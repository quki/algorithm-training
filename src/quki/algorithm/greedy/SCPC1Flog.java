package quki.algorithm.greedy;

import java.util.Scanner;
/**
 * °³±¸¸® ¶Ù±â
 * 
 * @author quki
 *
 */
public class SCPC1Flog {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();
		for (test_case = 1; test_case <= TC; test_case++) {
			int N = sc.nextInt();
			int[] a = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				a[i] = sc.nextInt();
			}
			int K = sc.nextInt();

			int ans = 0;
			for (int i = 0; i <= N - 1; i++) {
				if (a[i + 1] > a[i] + K) {
					ans = -1;
					break;
				}
			}

			if (ans != -1) {
				int curr = a[0];
				for (int i = 1; i <= N; i++) {
					if(a[i] > curr+K){
						curr = a[i-1];
						ans++;
					}
				
				}
				ans++;
			}

			System.out.println("Case #" + test_case);
			System.out.println(ans);
		}
	}

}
