
package quki.algorithm.dp;

import java.util.Scanner;

/**
 * 이동하기
 * 
 * @author quki
 */
public class BOJ11048 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[][] = new int[n + 1][m + 1];
        int d[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int max = Math.max(d[i - 1][j - 1], d[i - 1][j]);
                d[i][j] = Math.max(max, d[i][j - 1]) + a[i][j];
            }
        }

        System.out.println(d[n][m]);
    }

}
