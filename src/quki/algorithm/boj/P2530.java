package quki.algorithm.boj;

import java.util.Scanner;

/**
 * Clock
 * @author quki
 *
 */
public class P2530 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int h = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();
            int needS = sc.nextInt();
            
            int plusMin = (s+needS)/60;
            int sec = (s+needS)%60;
            int plusHour = (m+plusMin)/60;
            int min = (m+plusMin)%60;
            int hour  = h+plusHour;
            hour  = hour % 24;
            
            System.out.println(hour+" "+min+" "+sec);
            
    }

}
