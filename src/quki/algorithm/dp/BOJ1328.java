package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ1328 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();
        int mod = 1000000007;
        long d[][][] = new long[N+1][L+1][R+1];
        d[1][1][1] = 1;
        for(int i = 2; i<=N;i++){
            for(int j = 1; j<=L; j++){ 
                for(int k = 1; k<=R;k++){ 
                    d[i][j][k] = (d[i-1][j-1][k] + d[i-1][j][k-1]+d[i-1][j][k]*(i-2))%mod;
                    
                    /*
                     * d[i][j][k] += (d[i-1][j-1][k] + d[i-1][j][k-1])%mod;
                     * d[i][j][k] += d[i-1][j][k]*(i-2)%mod;  <-- 틀림! mod계산 먼저하고 더하므로!
                     */
                }
            }
        }
        
        System.out.println(d[N][L][R]);
        
    }

}
