
package quki.algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1254 {

    /**
     * MemoizationÇÏ¸é¼­ return
     * 
     * @return 1: ÆÓ¸°µå·ë, 0: ÆÓ¸°µå·ëX, -1: ¾ÆÁ÷ Memoization¾ÈÇÑ ÁöÁ¡
     */
    public static int isPelindrome(int start, int end, String line, int d[][]) {

        if (d[start][end] != -1)
            return d[start][end];

        if (start == end)
            return d[start][end] = 1;

        if (start + 1 == end) {
            if (line.charAt(start) == line.charAt(end)) {
                return d[start][end] = 1;
            } else {
                return d[start][end] = 0;
            }
        }

        if (line.charAt(start) == line.charAt(end)) {
            return d[start][end] = isPelindrome(start + 1, end - 1, line, d);
        } else {
            return d[start][end] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int n = line.length();
        int d[][] = new int[2 * n - 1][2 * n - 1];

        for (int i = 0; i < 2 * n - 1; i++) {
            Arrays.fill(d[i], -1);
        }

        if (isPelindrome(0, n-1, line, d) == 1) {
            System.out.println(line.length());
        } else {
            
            int point = n-1;
            for(int i = 0 ; i<=n-1;i++){
                if(isPelindrome(i, n-1, line, d) == 1){
                    point = i;
                    break;
                }
            }
            for (int i = point-1; i >= 0; i--) {

                line = line + line.charAt(i);
                if (isPelindrome(0, line.length() - 1, line, d) == 1) {
                    System.out.println(line.length());
                    break;
                }
            }
        }

    }

}
