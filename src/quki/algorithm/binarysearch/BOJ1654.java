package quki.algorithm.binarysearch;

import java.util.Arrays;
import java.util.Scanner;
/**
 * N * log(랜선의 최대 길이)
 * @author quki
 *
 */
public class BOJ1654 {

	public static boolean isPossible(int a[], int N, long mid) {

		int count = 0;
		for (int lanCable : a) {
			count += (lanCable / mid);
		}

		return count >= N;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int N = sc.nextInt();
		int a[] = new int[K];
		for (int i = 0; i < K; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		long left = 1;
		long right = a[K - 1];
		long ans = 0;
		while (left <= right) {
			long mid = (left + right) / 2; // 랜선의 길이
			
			if (isPossible(a, N, mid)) {
				left = mid + 1;
				ans = Math.max(ans, mid);
			} else {
				right = mid - 1;
			}
		}

		System.out.println(ans);

	}

}
