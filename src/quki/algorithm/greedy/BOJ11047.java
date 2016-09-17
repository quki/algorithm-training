package quki.algorithm.greedy;

import java.util.Scanner;
/**
 * 문제에서 주어진 동전의 가치
 * Ai가 Ai-1의 배수라서
 * 그리디 알고리즘이 가능
 * 
 * @author quki
 *
 */
public class BOJ11047 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[] = new int[n + 1];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int count = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (m == 0)
				break;

			if (m / a[i] == 0)
				continue;

			int k = m / a[i]; // 몫(개수)
			count += k;
			m = m % a[i];
		}
		
		System.out.println(count);
	}

}
