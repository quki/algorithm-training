package quki.algorithm.boj;

import java.util.Scanner;

public class P1085 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int horizon = Math.min(x, w-x);
        int vertical = Math.min(y, h-y);
        if(horizon>=vertical){
            System.out.println(vertical);
        }else{
            System.out.println(horizon);
        }
    }

}
