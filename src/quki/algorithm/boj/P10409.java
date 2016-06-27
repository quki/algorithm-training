
package quki.algorithm.boj;

import java.util.Scanner;

public class P10409 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int sum = 0;
        int count = 0;
        boolean check = false;
        while (n-- > 0) {
            int x = sc.nextInt();
            if (!check) {
                if (sum + x <= m) {
                    sum += x;
                    count++;
                } else {
                    check = true;
                }
            }

        }
        System.out.println(count);
    }

}
