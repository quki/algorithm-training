
package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ1520RecursiveAndMemoization {

    static int dx[] = {
            0, 0, 1, -1
    };

    static int dy[] = {
            1, -1, 0, 0
    };

    public static int go(int i, int j, int[][] a, int[][] d) {
        int n = a.length-1;
        int m = a[0].length-1;

        if (i == n && j == m)
            return 1;
        
        if (d[i][j] > 0) {
            return d[i][j];
        }
        
        for (int k = 0; k < 4; k++) {
            int nx = j + dx[k];
            int ny = i + dy[k];
            
            if (nx>=1 && nx <= m && ny>=1 && ny <= n) {
                if (a[i][j] > a[ny][nx]) {
                    d[i][j] += go(ny, nx, a, d);
                }
            }

        }

        return d[i][j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n + 1][m + 1];
        int[][] d = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        //d[1][1] = 1;
        //System.out.println(go(1, 1, a, d));
        go(1, 1, a, d);
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            sb.append("\n");
            for (int j = 1; j <= m; j++) {
                sb.append(d[i][j] + " ");
            }
        }
        System.out.println(sb);

    }

}
