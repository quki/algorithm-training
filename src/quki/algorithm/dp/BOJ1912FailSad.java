
package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ1912FailSad {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        int d[][] = new int[2][n + 1];
        int INI = a[1];
        d[0][1] = INI;
        d[1][1] = INI;
        
        // 분기가 너무 나뉘는 좋지 않은 코드이다.
        for (int i = 2; i <= n; i++) {
            if (a[i - 1] < a[i - 1] + a[i]) {
                if (a[i - 1] + a[i] < a[i]) {
                    d[0][i] = Math.max(d[0][i - 1], a[i]);
                } else {
                    d[0][i] = Math.max(d[0][i - 1], a[i - 1] + a[i]);
                }
            } else {
                    d[0][i] = d[0][i - 1];
            }
            d[1][i] = Math.max(d[1][i - 1] + a[i], a[i]);
        }
        System.out.println(Math.max(d[0][n], d[1][n]));
    }
}
