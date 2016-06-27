
package quki.algorithm.boj;

import java.util.Scanner;

public class P1075 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();
        int newN = n / 100 * 100;
        int r = newN % f; // ³ª¸ÓÁö
        int ans = f-r;
        if(r == 0) ans = 0;
        
        StringBuffer sb = new StringBuffer();
        if(ans<10){
            sb.append("0"+ans);
        }else{
            sb.append(ans);
        }
        System.out.println(sb);
    }

}
