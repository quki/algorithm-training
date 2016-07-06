
package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ11727 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long dp[] = new long[1001];
        dp[1] = 1L;
        dp[2] = 3L;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }
        System.out.println(dp[n]);
    }

}
