
package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ10942OnlyForLoop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n + 1];
        int d[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        
        for (int i = 1; i <= n; i++)
            d[i][i] = 1;
        for (int i = 1; i <= n - 1; i++) {
            if (a[i] == a[i + 1])
                d[i][i + 1] = 1;
        }

        for (int k = 2; k <= n - 1; k++) { // 간격
            for (int i = 1; i <= n - k; i++) {
                int j = i + k;
                if (a[i] == a[j] && d[i + 1][j - 1] == 1)
                    d[i][j] = 1;
            }
        }
        
        // 데이터 갯수
        int m = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        while (m-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            sb.append(d[start][end]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
