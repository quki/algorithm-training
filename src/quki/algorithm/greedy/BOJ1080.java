package quki.algorithm.greedy;

import java.util.Scanner;
/**
 * 행렬 뒤집기 문제
 * 
 * @author quki
 *
 */
public class BOJ1080 {

	static void flip(int y, int x, int[][] b) {
		for (int i = y; i < y + 3; i++) {
			for (int j = x; j < x + 3; j++) {
				if (b[i][j] == 0) {
					b[i][j] = 1;
				} else {
					b[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int a[][] = new int[N][M];
		int b[][] = new int[N][M];
		sc.nextLine();

		// a행렬 초기화
		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < M; j++) {
				a[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
			}
		}
		// b행렬 초기화
		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < M; j++) {
				b[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
			}
		}
		int ans = 0;
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (a[i][j] != b[i][j]) {
					ans++;
					flip(i, j, b);
				}
			}
		}
		
		for (int i = 0; i < N ; i++) {
			for (int j = 0; j < M ; j++) {
				if (a[i][j] != b[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}

		System.out.println(ans);

	}

}
