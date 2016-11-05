package quki.algorithm.math;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 에라토스테네스의 채
 *
 */
public class BOJ2581 {

	static final int INF = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean isPrime[] = new boolean[M + 1];
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		for (int i = 2; i <= M; i++) {
			if (isPrime[i]) {
				for (int j = i + i; j <= M; j += i) {
					isPrime[j] = false;
				}
			}
		}
		int ans1 = 0;
		int ans2 = INF;
		for (int i = N; i <= M; i++) {
			if (isPrime[i]) {
				ans1 += i;
				if (ans2 > i) {
					ans2 = i;
				}
			}
		}

		if (ans1 == 0) {
			System.out.println(-1);
		} else {
			System.out.println(ans1 + "\n" + ans2);
		}

	}

}
