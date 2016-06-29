package quki.algorithm.boj;

import java.util.Scanner;

public class P2163 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ans = (m-1) + m*(n-1);
        System.out.println(ans);
    }

}
