
package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ1520 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n + 1][m + 1];
        int[][] d = new int[n + 1][m + 1];
        boolean[][] c = new boolean[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int dx[] = {
                0, 0, 1, -1
        };
        int dy[] = {
                1, -1, 0, 0
        };
        d[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];
                    if (nx <= m && ny <= n) {
                        if(a[i][j] < a[ny][nx])
                        d[i][j] += d[ny][nx];
                    }

                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            sb.append("\n");
            for (int j = 1; j <= m; j++) {
                sb.append(d[i][j]+" ");
            }
        }
        System.out.println(sb);

    }

}
