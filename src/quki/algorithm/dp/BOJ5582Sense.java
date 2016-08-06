
package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ5582Sense {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        if (a.length() > b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        int max = 0;
        int i = a.length() - 1;
        int j = a.length() - 1;
        while (i <= j && i >= 0 && j >= 0) {
            String cmp = a.substring(i, j + 1);
            if (b.contains(cmp)) {
                i = i - 1;
                max = Math.max(max, cmp.length());
            } else {
                if (i == j) {
                    i = i - 1;
                }
                j = j - 1;
            }
        }

        System.out.println(max);

    }
}
