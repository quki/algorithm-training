
package quki.algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 팰린드룸?
 * 재귀 + 메모이제이션
 * 메모이제이션을 하는 이유: 입력이 여러개이기 때문에
 * @author quki
 *
 */
public class BOJ10942RecursiveAndMemoization {

    public static int isPalindrome(int[] a, int[][] d, int start, int end) {

        if (d[start][end] != -1)
            return d[start][end];

        if (start == end)
            return d[start][end] = 1;
        if (start + 1 == end) {
            if (a[start] == a[end]) {
                return d[start][end] = 1;
            } else {
                return d[start][end] = 0;
            }
        }
        if (a[start] == a[end]) {
            return d[start][end] = isPalindrome(a, d, start + 1, end - 1);
        } else {
            return d[start][end] = 0;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n + 1];
        int d[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            Arrays.fill(d[i], -1);
        }
        int m = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        while (m-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            sb.append(isPalindrome(a, d, start, end));
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
