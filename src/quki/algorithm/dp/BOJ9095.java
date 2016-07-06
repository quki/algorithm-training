package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ9095 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int n = sc.nextInt();
            int dp[] = new int[11];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int i = 4; i<=n;i++){
                dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
            }
            System.out.println(dp[n]);
        }
        
    }

}
