package quki.algorithm.boj;

import java.util.Scanner;

public class P2869 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();
        
        int ans = 0;
        int sum = 0;
        while(sum < v){
            sum += a ;
            ans++;
            if(sum >= v) break;
            sum -= b;
        }
        System.out.println(ans);
    }

}
