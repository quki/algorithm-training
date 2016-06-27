package quki.algorithm.boj;

import java.util.Scanner;

public class P2525 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int h = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();
            
            int plusHour = (s+m)/60;
            int min  = s+m - plusHour*60;
            
            int hour  = h+plusHour;
            hour  = hour % 24;
            
            System.out.println(hour+" "+min);
            
    }

}
