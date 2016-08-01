
package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ1495 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();
        int a[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        boolean d[][] = new boolean[n + 1][m + 1];

        d[0][s] = true;
        for (int i = 0; i <= n - 1; i++) {  // d[i+1][newJ], 미래의 항(i+1)을 연산하는 방식!
            for (int j = 0; j <= m; j++) {
                if (d[i][j]) {
                    if (j - a[i + 1] >= 0) {
                        d[i + 1][j - a[i + 1]] = true;
                    }

                    if (j + a[i + 1] <= m) {
                        d[i + 1][j + a[i + 1]] = true;
                    }
                }
            }
        }
        for (int j = m; j >= 0; j--) {
            if (d[n][j]) {
                System.out.println(j);
                break;
            }
            if (j == 0 && !d[n][j]) {
                System.out.println(-1);
            }
        }

    }

}
