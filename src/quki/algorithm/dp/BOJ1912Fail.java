
package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ1912Fail {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a[] = new long[n + 1];
        long d[][] = new long[n + 1][n + 1]; // 배열 크기가 10만 X 10만 이면 메모리가 38146MB라서 런타임 에러?
        for (int i = 1; i <= n; i++) {
            int e = sc.nextInt();
            a[i] = e;
        }
        int inf = -1000000000;
        long max = inf;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                d[i][j] = d[i][j-1] + a[j];
                max = Math.max(max, d[i][j]);
            }
        }
        System.out.println(max);
    }

}
