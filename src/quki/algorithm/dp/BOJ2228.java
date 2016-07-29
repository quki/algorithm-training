
package quki.algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2228 {

    final static int inf = -1000000000;

    public static int sum(int i, int j, int a[]) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += a[k];
        }
        return sum;
    }

    public static int go(int i, int j, int depth, int m, int a[], int d[][]) {
        depth++;
        if (depth == m) {
            return d[i][j] = sum(i, j, a);
        }

        for (int k = i + 1; k <= j; k++) {
            int t1 = go(i, k - 1, depth, m, a, d);
            int t2 = sum(k, j, a);
            int max = t1 > t2 ? t1 : t2;
            if (d[i][j] < max) {
                d[i][j] = max;
            }
        }

        return d[i][j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = new int[n];
        int d[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            Arrays.fill(d[i], inf);
        }

        System.out.println(go(0, n - 1, 0, m, a, d));
        /*StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("\n");
            for (int j = 0; j < n; j++) {
                sb.append(d[i][j] + " ");
            }
        }
        System.out.println(sb);*/
    }

}
