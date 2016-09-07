package quki.algorithm.floyd;

import java.util.Scanner;
/**
 * 
 * 경로 찍어내는 문제
 * Divide!
 * Conquer 라고 할 수 있나? OK!
 * 
 * @author quki
 *
 */
public class BOJ11780 {

	// Divide and Conquer 방식을 이용
	public static String getPath(int u, int v, int path[][]) {
		
		if (path[u][v] == u)
			return " "+v;
		
		int k = path[u][v];
		String front = getPath(u, k, path);
		String back = getPath(k, v, path);
		return front + back;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int d[][] = new int[n + 1][n + 1];

		while (m-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();
			if (d[u][v] == 0 || d[u][v] > c) {
				d[u][v] = c;
			}
		}
		// int parent[] = new int[n+1];
		// 일차원 배열은 single start single end일 때나 가능
		int path[][] = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				path[i][j] = i; // 출발 점으로 초기화
			}
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (d[i][k] != 0 && d[k][j] != 0 && i != j) {
						if (d[i][j] > d[i][k] + d[k][j] || d[i][j] == 0) {
							d[i][j] = d[i][k] + d[k][j];
							path[i][j] = k;
						}
					}
				}
			}
		}
		StringBuffer ans = new StringBuffer();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				ans.append(d[i][j]);
				ans.append(" ");
			}
			ans.append("\n");
		}
		StringBuffer temp; 
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				temp = new StringBuffer();
				if(i == j){
					temp.append(0);
				}else{
					temp.append(i);
					temp.append(getPath(i, j, path));
					String line[] = temp.toString().split(" ");
					ans.append(line.length);
					ans.append(" ");
				}
				ans.append(temp.toString());
				ans.append("\n");
			}
			
		}
		System.out.println(ans);
		
	}

}
