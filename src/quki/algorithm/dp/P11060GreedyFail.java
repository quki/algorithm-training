
package quki.algorithm.dp;

import java.util.Scanner;

public class P11060GreedyFail {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] s = new int[n];
        int inf = 1000000000;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            a[i] = x;
            if(i==0){
                s[i] = 0;
            }else{
                s[i] =  inf;
            }
        }
        for(int i = 0; i<n;i++){
            int t = a[i];
            for(int j = 1; j<=t; j++){
                int newIndex = i+j;
                if(newIndex <= n-1){
                    if(s[newIndex] > s[i]+1){
                        s[newIndex] =  s[i]+1;
                    }
                }
            }
            
        }
        int ans = s[n-1];
        if(ans == inf) ans =-1;
        System.out.println(ans);
    }

}
