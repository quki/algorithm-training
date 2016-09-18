package quki.algorithm.greedy;

import java.util.Scanner;

/**
 * 막 여러 경우로 나누는게 아니라 범위로 풀기!
 * 
 * @author quki
 *
 */
public class BOJ2875 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int women = 0;
		int men = 0;
		int ans = 0;

		while (women + men <= N + M - K && women <= N && men <= M) {
			women += 2;
			men++;
			ans++;
		}
		System.out.println(ans - 1);
	}

}
