package quki.algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * LIS 
 * O(n^2)
 * 
 * @author quki
 *
 */
public class BOJ1365 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		int d[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.fill(d,1);
		for (int i = 1; i < n; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i]) {
					max = Math.max(max, d[j]);
					d[i] = max + 1;
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, d[i]);
		}
		ans = n - ans;
		System.out.println(ans);
	}

}
