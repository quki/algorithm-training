package quki.algorithm.floyd;

import java.util.Scanner;
/**
 * 
 * 경로 찍어내는 문제
 * Divide Conquer 라고 할 수 있나? OK!
 * 
 * 플로이드 와샬문제는 동적계획법이다!
 * https://ko.wikipedia.org/wiki/%ED%94%8C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%9B%8C%EC%85%9C_%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
 * 
 * @author quki
 *
 */
public class BOJ11780 {

	// Divide and Conquer 방식을 이용
	public static String getPath(int i, int j, int path[][]) {
		
		if (path[i][j] == 0)
			return i+" ";
		
		int k = path[i][j];
		String front = getPath(i, k, path);
		String back = getPath(k, j, path);
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
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(i == j){
					ans.append(0);
				}else{
					String pathStr = getPath(i, j, path)+ j;
					String line[] = pathStr.split(" ");
					ans.append(line.length);
					ans.append(" ");
					ans.append(pathStr);
				}
				ans.append("\n");
			}
			
		}
		System.out.println(ans);
		
	}

}
