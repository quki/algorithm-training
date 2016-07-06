
package quki.algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1463 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n + 1];
        int inf = 1000000000;
        Arrays.fill(a, inf);
        a[1] = 0;
        for (int i = 1; i <= n - 1; i++) {
            if (i + 1 <= n) {
                a[i + 1] = Math.min(a[i] + 1, a[i + 1]);
            }
            if (2 * i <= n) {
                a[2 * i] = Math.min(a[i] + 1, a[2 * i]);
            }
            if (3 * i <= n) {
                a[3 * i] = Math.min(a[i] + 1, a[3 * i]);
            }
        }
        System.out.println(a[n]);
    }

}
