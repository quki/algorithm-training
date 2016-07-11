
package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ2167 {

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

        int t = sc.nextInt();
        while (t-- > 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int sum = 0;
            for (int k = i; k <= x; k++) {
                for (int s = j; s <= y; s++) {
                    sum+= a[k][s];
                }
            }
            System.out.println(sum);

        }
    }

}
