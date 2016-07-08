
package quki.algorithm.dp;

import java.util.Scanner;

/**
 * BOJ 계단오르기 문제
 * 포도주 문제랑 비교!
 * 1차원/2차원 배열 모두 가능
 * 
 * @author quki
 */
public class BOJ2579 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n + 1];
        int d[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        
        d[1] = a[1];
        d[2] = a[1]+a[2];
        for(int i = 3;i<=n;i++){
            d[i] = Math.max(a[i-1]+d[i-3], d[i-2])+a[i];
        }
        
        System.out.println(d[n]);
    }

}
