
package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ2410 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long d[] = new long[n + 1];
        d[0] = 1;
        int k = 1;
        int mod = 1000000000;
        while (k <= n) {
            for (int i = 1; i <= n; i++) {
                if(i-k>=0)
                d[i] = (d[i] + d[i - k])%mod;
            }
            k *=2;
        }
        System.out.println(d[n]);
    }

}
