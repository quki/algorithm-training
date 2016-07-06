
package quki.algorithm.dp;

import java.util.Scanner;

/**
 * 시간복잡도 O(n) 총 채워야하는 칸의 수 * 1칸을 채우는 데 필요한 복잡도 그러므로, n*1
 * 
 * @author quki
 */
public class BOJ1463bj {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+1;
            if(i%2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }
            if(i%3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }
        }
        System.out.println(dp[n]);

    }
}
