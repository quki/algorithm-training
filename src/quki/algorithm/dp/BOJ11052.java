
package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ11052 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n + 1];
        int dp[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        dp[1] = a[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1]+a[1], a[i]);
        }
        System.out.println(dp[n]);
    }

}
