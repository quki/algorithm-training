
package quki.algorithm.boj;

import java.util.ArrayList;
import java.util.Scanner;

public class P1009 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int ans = a;
            ArrayList<Integer> al = new ArrayList<>();
            al.add(ans % 10); // initial val
            for (int i = 1; i < b; i++) {
                ans = (ans*a) % 10;
                if (al.get(0) != ans) {
                    al.add(ans);
                } else {
                    break;
                }
            }
            int interval = al.size();
            b = b % interval;
            if(b == 0){
                ans = al.get(interval-1);    
            }else{
                ans = al.get(b-1);
            }
            
            if (ans == 0)
                ans = 10;
            
            System.out.println(ans);
        }

    }

}
