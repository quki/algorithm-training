package quki.algorithm.floyd;

import java.util.Scanner;

public class BOJ1956 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int d[][] = new int[n + 1][n + 1];
		while (m-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();
			d[u][v] = c;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (d[i][k] != 0 && d[k][j] != 0) {
						if (d[i][j] > d[i][k] + d[k][j] || d[i][j] == 0) {
							d[i][j] = d[i][k] + d[k][j];
						}
					}
				}
			}
		}
		int min = 1000000000;
		int vertex = -1;
		for (int i = 1; i <= n; i++) {
			if (d[i][i] == 0)
				continue;
			
			if(min > d[i][i]) {
				vertex = i;
				min = d[i][i];
			}
		}
		if(vertex == -1){
			System.out.println(-1);
		}else{
			System.out.println(d[vertex][vertex]);
		}
		

	}

}
