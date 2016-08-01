
package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ1912 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        int d[] = new int[n + 1]; // d[n] : n 까지의 최대값
        int e = a[1];
        d[1] = e;
        for (int i = 2; i <= n; i++) {
            if(d[i-1] < d[i-1] + a[i]){
                d[i] = d[i-1]+a[i];
            }else{
                d[i] = d[i-1];
            }
        }
        System.out.println(d[n]);
    }
}
