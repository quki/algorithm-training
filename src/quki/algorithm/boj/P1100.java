
package quki.algorithm.boj;

import java.util.Scanner;

/**
 * BOJ #1100
 * 
 * @author quki
 */
public class P1100 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        for (int i = 0; i < 8; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if (i % 2 == 0) { // Â¦¼ö rowÀÏ ¶§, 0,2,4,6
                    if (j % 2 == 0) { // Èò»ö
                       if(c =='F') count++;
                    }
                } else {
                    if (j % 2 != 0) { // Èò»ö
                        if(c =='F') count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

}
