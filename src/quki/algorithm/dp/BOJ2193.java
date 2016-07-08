
package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ2193 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long d[][] = new long[n+1][2];
        d[1][1] = 1;
        for(int i = 2; i<=n;i++){
            d[i][0] = d[i-1][0]+d[i-1][1];
            d[i][1] = d[i-1][0];
        }
        long ans = 0;
        for(int j = 0; j<2;j++){
            ans+=d[n][j];
        }
        System.out.println(ans);
    }

}
