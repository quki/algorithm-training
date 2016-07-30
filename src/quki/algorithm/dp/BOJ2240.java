
package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ2240 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = new int[n + 1];
        int d[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        
        // 초기화 작업
        if (a[1] == 1) {
            d[1][0] = 1;
        } else {
            d[1][1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= m; j++) {

                if (j == 0) {
                    d[i][j] = d[i - 1][j];
                } else {
                    d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]);
                }

                if ((j % 2 == 0 && a[i] == 1) || (j % 2 == 1 && a[i] == 2)) {
                    d[i][j]++;
                }

            }

        }
        int max = 0;
        for (int i = 0; i <= m; i++) {
            max = Math.max(max, d[n][i]);
        }

        System.out.println(max);

    }

}
