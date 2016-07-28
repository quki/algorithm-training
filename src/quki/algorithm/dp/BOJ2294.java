
package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ2294 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int d[][] = new int[2][k + 1];
        int inf = 1000000000;
        d[0][0] = 1;

        for (int i = 1; i < k + 1; i++) {
            d[1][i] = inf;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j - a[i] >= 0) {
                    d[0][j] += d[0][j - a[i]];
                    d[1][j] = Math.min(d[1][j], d[1][j - a[i]] + 1);
                }
            }
        }
        if(d[1][k] == inf) d[1][k] = inf; 
        System.out.println(d[1][k]);

    }

}
