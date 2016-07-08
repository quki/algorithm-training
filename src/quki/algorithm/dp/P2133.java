
package quki.algorithm.dp;

import java.util.Scanner;

public class P2133 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d[] = new int[31];
        d[0] = 1;
        d[2] = 3;
        for (int i = 4; i <= n; i++) {
            d[i] = 3* d[i-2];
            int k = 4;
            while(i-k>=0){
                d[i]+= 2*d[i-k];
                k = k+2;
            }
        }
        System.out.println(d[n]);
    }

}
