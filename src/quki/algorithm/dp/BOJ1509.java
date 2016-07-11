package quki.algorithm.dp;

import java.util.Scanner;

/**
 * 팰린드롬 분할 개수
 * @author quki
 *
 */
public class BOJ1509 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int n = line.length();
        line = " "+line;
        boolean[][] c = new boolean[n+1][n+1];  // 팰린드룸이 맞으면 1, 아니면 0
        for (int i=1; i<=n; i++) {
            c[i][i] = true;
        }
        for (int i=1; i<=n-1; i++) {
            if (line.charAt(i) == line.charAt(i+1)) {
                c[i][i+1] = true;
            }
        }
        for (int k=2; k<n; k++) {
            for (int i=1; i<=n-k; i++) {
                int j = i+k;
                c[i][j] = (line.charAt(i) == line.charAt(j) && c[i+1][j-1]);
            }
        }
        
        int[] d = new int[n+1]; // d[i] : i번째 까지 팰린드룸 최소 개수
        for (int i=1; i<=n; i++) {
            d[i] = -1;
            for (int j=1; j<=i; j++) {
                if (c[j][i]) {
                    if (d[i] == -1 || d[i] > d[j-1]+1) {
                        d[i] = d[j-1]+1;
                    }
                }
            }
        }
        System.out.println(d[n]);
    }

}
