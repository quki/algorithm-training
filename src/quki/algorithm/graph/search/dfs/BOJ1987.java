package quki.algorithm.graph.search.dfs;

import java.util.HashSet;
import java.util.Scanner;
/**
 * DP로 풀면 오히려 틀리는 문제, 판다문제와 다르다.
 * 판다 문제는 경로가 겹치지 않지만, 이문제는 경로가 달라질 수 있기때문에 메모이제이션을 하면 안된다
 * 
 * @author quki
 *
 */
public class BOJ1987 {

	static int dx[] = { 0, 0, -1, 1 }; // 상, 하, 좌, 우
	static int dy[] = { -1, 1, 0, 0 };
	static int N;
	static int M;

	static int go( String a[][], HashSet<String> check, int i, int j) {

		int max = 1;

		for (int k = 0; k < dx.length; k++) {
			int newJ = j + dx[k];
			int newI = i + dy[k];
			if (newI >= 0 && newI < N && newJ >= 0 && newJ < M) {
				if (!check.contains(a[newI][newJ])) {
					check.add(a[newI][newJ]);
					max = Math.max(max, go(a, check, newI, newJ) + 1);
					check.remove(a[newI][newJ]);
				}
			}

		}

		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		String a[][] = new String[N][M];
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < line.length(); j++) {
				a[i][j] = Character.toString(line.charAt(j));
			}
		}

		HashSet<String> check = new HashSet<>();
		check.add(a[0][0]);
		System.out.println(go(a, check, 0, 0));

	}

}
