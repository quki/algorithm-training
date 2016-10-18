package quki.algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;
/**
 * DP + Divide and conquer
 * 
 * @author quki
 *
 */
public class BOJ11049 {

    public static int go(int[][] a, int[][] d, int i, int j) {
        if (d[i][j] > 0) {
            return d[i][j];
        }
        if (i == j) {
            return 0;
        }
        if (i+1 == j) {
            return a[i][0]*a[i][1]*a[j][1];
        }
        for (int k=i; k<j; k++) {
            int t1 = go(a,d,i,k);
            int t2 = go(a,d,k+1,j);
            int t3 = a[i][0]*a[k][1]*a[j][1];
            if (d[i][j] == -1 || d[i][j] > t1+t2+t3) {
                d[i][j] = t1+t2+t3;
            }
        }
        return d[i][j];
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][2];
        for (int i=0; i<n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        int[][]d = new int[n][n];
        for(int i = 0; i<n ; i++){
            Arrays.fill(d[i], -1);
        }
        System.out.println(go(a,d,0,n-1));
    }

}
