
package quki.algorithm.dp;

import java.util.Scanner;

/**
 * 포도주 시식!
 * 
 * @author quki
 *
 */
public class BOJ2156 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n + 1];
		int d[][] = new int[n + 1][3];
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
		d[1][1] = a[1];
		for (int i = 2; i <= n; i++) {
			d[i][0] = Math.max(d[i - 1][0], d[i - 1][1]);
			d[i][0] = Math.max(d[i - 1][2], d[i][0]);
			d[i][1] = d[i - 1][0] + a[i];
			d[i][2] = d[i - 1][1] + a[i];
		}

		int max = -1;
		for (int i = 0; i < 3; i++) {
			max = Math.max(d[n][i], max);
		}
		System.out.println(max);
	}

}
