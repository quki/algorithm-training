package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ5582LCS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int n = a.length();
        int m = b.length();
        
        int d[][] = new int[n+1][m+1];
        int max = 0;
        for(int i = 1; i<=n ; i++){
            for(int j = 1; j<=m; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    d[i][j] = d[i-1][j-1] + 1;
                }
                max = Math.max(max, d[i][j]);
            }
        }
        System.out.println(max);
    }

}
