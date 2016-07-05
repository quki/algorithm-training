
package quki.algorithm.math;

import java.util.Scanner;

public class BOJ1476 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();
        int ans = 0;
        while (true) {
            ans++;
            int eR = (ans % 15 == 0)? 15 : ans%15;
            int sR = (ans % 28 == 0)? 28 : ans%28;
            int mR = (ans % 19 == 0)? 19 : ans%19;
            if (eR == E && sR == S && mR == M)
                break;
        }
        System.out.println(ans);
    }
}
